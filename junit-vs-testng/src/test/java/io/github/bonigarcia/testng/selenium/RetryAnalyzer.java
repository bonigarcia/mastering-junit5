/*
 * (C) Copyright 2021 Boni Garcia (https://bonigarcia.github.io/)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package io.github.bonigarcia.testng.selenium;

import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    static final int DEFAULT_MAX_RETRIES = 3;

    final AtomicInteger retryCount = new AtomicInteger(1);

    @Override
    public boolean retry(ITestResult result) {
        Method method = result.getMethod().getConstructorOrMethod().getMethod();
        int maxRetries = DEFAULT_MAX_RETRIES;
        if (method.isAnnotationPresent(Retry.class)) {
            Retry retry = method.getAnnotation(Retry.class);
            maxRetries = retry.value();
        }
        if (retryCount.get() <= maxRetries) {
            logError(result.getThrowable());
            retryCount.incrementAndGet();
            return true;
        }
        return false;
    }

    private void logError(Throwable e) {
        System.err.println("Attempt test execution #" + retryCount.get()
                + " failed (" + e.getClass().getName() + "thrown):  "
                + e.getMessage());
    }

}

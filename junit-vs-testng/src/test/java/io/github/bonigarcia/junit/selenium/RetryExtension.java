/*
 * (C) Copyright 2025 Boni Garcia (https://bonigarcia.github.io/)
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
package io.github.bonigarcia.junit.selenium;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

public class RetryExtension implements TestExecutionExceptionHandler {

    static final int DEFAULT_MAX_RETRIES = 3;

    final AtomicInteger retryCount = new AtomicInteger(1);

    @Override
    public void handleTestExecutionException(ExtensionContext extensionContext,
            Throwable throwable) throws Throwable {
        logError(throwable);

        extensionContext.getTestMethod().ifPresent(method -> {
            int maxRetries = method.getAnnotation(Retry.class) != null
                    ? method.getAnnotation(Retry.class).value()
                    : DEFAULT_MAX_RETRIES;

            while (retryCount.incrementAndGet() <= maxRetries) {
                try {
                    extensionContext.getExecutableInvoker().invoke(method,
                            extensionContext.getRequiredTestInstance());
                    return;
                } catch (Throwable t) {
                    logError(t);

                    if (retryCount.get() >= maxRetries) {
                        throw t;
                    }
                }
            }
        });
    }

    private void logError(Throwable e) {
        System.err.println("Attempt test execution #" + retryCount.get()
                + " failed (" + e.getClass().getName() + "thrown):  "
                + e.getMessage());
    }

}
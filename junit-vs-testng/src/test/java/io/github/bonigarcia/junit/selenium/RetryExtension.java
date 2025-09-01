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

import java.lang.reflect.Method;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

public class RetryExtension implements TestExecutionExceptionHandler {

    static final int DEFAULT_MAX_RETRIES = 3;

    private final int maxRetries;

    public RetryExtension() {
        this.maxRetries = DEFAULT_MAX_RETRIES;
    }

    public RetryExtension(int maxRetries) {
        this.maxRetries = maxRetries;
    }

    @Override
    public void handleTestExecutionException(ExtensionContext context,
            Throwable firstFailure) throws Throwable {
        logError(firstFailure, 1); // attempt #1 already failed

        int attempt = 1;
        while (attempt < maxRetries) {
            attempt++;
            try {
                // Re-run test method (no @BeforeEach/@AfterEach)
                Method method = context.getRequiredTestMethod();
                Object instance = context.getRequiredTestInstance();
                context.getExecutableInvoker().invoke(method, instance);
                return; // Success: swallow the original exception
            } catch (Throwable t) {
                logError(t, attempt);
                if (attempt >= maxRetries) {
                    throw t; // failure after last retry
                }
            }
        }
        throw firstFailure; // throw original failure as a fallback
    }

    private void logError(Throwable e, int attempt) {
        System.err.println("Attempt #" + attempt + " failed ("
                + e.getClass().getName() + " thrown): " + e.getMessage());
    }
}
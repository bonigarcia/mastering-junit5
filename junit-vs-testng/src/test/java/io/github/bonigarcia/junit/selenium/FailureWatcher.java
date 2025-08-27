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

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.SeleniumUtils;

public class FailureWatcher implements TestExecutionExceptionHandler {

    @Override
    public void handleTestExecutionException(ExtensionContext context,
            Throwable throwable) throws Throwable {

        context.getTestInstance().ifPresent(testInstance -> {
            WebDriver driver = SeleniumUtils
                    .getDriverFromTestInstance(testInstance,
                    "driver");
            SeleniumUtils.getScreenshotAsFile(driver, context.getDisplayName());
        });

        throw throwable;
    }

}

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

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Store;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.SeleniumUtils;

public class Reporter implements BeforeAllCallback, BeforeEachCallback,
        AfterTestExecutionCallback {

    static final String STORE_NAMESPACE = "report-store";
    static final String STORE_NAME = "reports";
    static final String REPORT_NAME = "report-junit.html";

    ExtentReports report;
    ExtentTest test;

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        Store store = context.getRoot()
                .getStore(ExtensionContext.Namespace.create(STORE_NAMESPACE));
        report = store.get(STORE_NAME, ExtentReports.class);
        if (report == null) {
            report = new ExtentReports();
            store.put(STORE_NAME, report);

            Runtime.getRuntime().addShutdownHook(new Thread(report::flush));
        }
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(REPORT_NAME);
        report.attachReporter(htmlReporter);
    }

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        test = report.createTest(context.getDisplayName());
    }

    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {
        context.getTestInstance().ifPresent(testInstance -> {
            WebDriver driver = (WebDriver) SeleniumUtils
                    .getFieldFromTestInstance(testInstance, "driver");
            String screenshot = SeleniumUtils.getScreenshotAsBase64(driver);
            test.addScreenCaptureFromBase64String(screenshot);
        });
    }

}
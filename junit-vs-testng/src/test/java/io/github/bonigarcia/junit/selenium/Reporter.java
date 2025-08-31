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

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Store;
import org.junit.jupiter.api.extension.TestWatcher;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.SeleniumUtils;

public class Reporter implements BeforeAllCallback, BeforeEachCallback,
        AfterTestExecutionCallback, TestWatcher {

    static final String STORE_NAMESPACE = "report-store";
    static final String STORE_NAME = "reports";
    static final String REPORT_NAME = "report-junit.html";

    ExtentReports report;
    Map<String, ExtentTest> tests;

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        Store store = context.getRoot()
                .getStore(ExtensionContext.Namespace.create(STORE_NAMESPACE));
        report = store.get(STORE_NAME, ExtentReports.class);
        if (report == null) {
            report = new ExtentReports();
            tests = new HashMap<>();
            store.put(STORE_NAME, report);

            Runtime.getRuntime().addShutdownHook(new Thread(report::flush));
        }
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(REPORT_NAME);
        report.attachReporter(htmlReporter);
    }

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        ExtentTest test = report.createTest(context.getDisplayName());
        context.getTags().forEach(test::assignCategory);
        tests.put(context.getUniqueId(), test);
    }

    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {
        context.getTestInstance().ifPresent(testInstance -> {
            SeleniumUtils.getDriverFromTestInstance(testInstance)
                    .ifPresent(driver -> {
                        String screenshot = SeleniumUtils
                                .getScreenshotAsBase64(driver);
                        tests.get(context.getUniqueId())
                                .addScreenCaptureFromBase64String(screenshot);
                    });
        });
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        tests.get(context.getUniqueId()).fail(cause);
    }

    @Override
    public void testDisabled(ExtensionContext context,
            Optional<String> reason) {
        tests.get(context.getUniqueId()).skip(reason.orElse("Disabled test"));
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        tests.get(context.getUniqueId()).skip(cause);
    }

}
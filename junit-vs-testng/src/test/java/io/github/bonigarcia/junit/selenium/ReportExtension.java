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

import java.lang.reflect.Field;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Store;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportExtension implements BeforeAllCallback, BeforeEachCallback,
        AfterTestExecutionCallback {

    static final String STORE_NAME = "reports";
    static final ExtensionContext.Namespace REPORT_NAMESPACE = ExtensionContext.Namespace
            .create("report-store");
    ExtentReports report;
    ExtentTest test;

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        Store store = context.getRoot().getStore(REPORT_NAMESPACE);
        report = store.get(STORE_NAME, ExtentReports.class);

        if (report == null) {
            report = new ExtentReports();
            store.put(STORE_NAME, report);

            Runtime.getRuntime().addShutdownHook(new Thread(report::flush));
        }

        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(
                "report-junit.html");
        report.attachReporter(htmlReporter);
    }

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        test = report.createTest(context.getDisplayName());
    }

    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {
        context.getTestInstance().ifPresent(instance -> {
            try {
                Class<?> clazz = instance.getClass();
                Field field = null;
                while (clazz != null) { // Seek driver in test class or parent
                    try {
                        field = clazz.getDeclaredField("driver");
                        break; // found it
                    } catch (NoSuchFieldException e) {
                        clazz = clazz.getSuperclass(); // move up
                    }
                }
                if (field != null) {
                    field.setAccessible(true);
                    WebDriver driver = (WebDriver) field.get(instance);
                    String screenshot = ((TakesScreenshot) driver)
                            .getScreenshotAs(OutputType.BASE64);
                    test.addScreenCaptureFromBase64String(screenshot);

                } else {
                    throw new RuntimeException(
                            "Driver not found in test class");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

}
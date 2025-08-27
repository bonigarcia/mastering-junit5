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
package io.github.bonigarcia.testng.selenium;

import java.lang.reflect.Field;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reporter implements ITestListener {

    static final String REPORT_NAME = "report-testng.html";

    ExtentReports report;
    ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);

        report = new ExtentReports();
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(REPORT_NAME);
        report.attachReporter(htmlReporter);
    }

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        test = report.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        Object testInstance = result.getInstance();

        String screenshot = takeScreenShot(testInstance);
        test.addScreenCaptureFromBase64String(screenshot);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);

        report.flush();
    }

    private String takeScreenShot(Object testInstance) {
        try {
            Class<?> clazz = testInstance.getClass();
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
                WebDriver driver = (WebDriver) field.get(testInstance);
                String screenshot = ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.BASE64);
                return screenshot;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        throw new RuntimeException("Driver not found in test class");
    }

}

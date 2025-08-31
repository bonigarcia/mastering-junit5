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

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.SeleniumUtils;

public class Reporter implements ITestListener {

    static final String REPORT_NAME = "report-testng.html";

    ExtentReports report;
    Map<String, ExtentTest> tests;

    @Override
    public void onStart(ITestContext context) {
        report = new ExtentReports();
        tests = new HashMap<>();
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(REPORT_NAME);
        report.attachReporter(htmlReporter);
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = report.createTest(result.getInstanceName());
        Arrays.asList(result.getMethod().getGroups())
                .forEach(test::assignCategory);
        tests.put(result.id(), test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Object testInstance = result.getInstance();
        SeleniumUtils.getDriverFromTestInstance(testInstance)
                .ifPresent(driver -> {
                    String screenshot = SeleniumUtils
                            .getScreenshotAsBase64(driver);
                    tests.get(result.id())
                            .addScreenCaptureFromBase64String(screenshot);
                });
    }

    @Override
    public void onTestFailure(ITestResult result) {
        tests.get(result.id()).fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        tests.get(result.id()).skip(result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        report.flush();
    }
}

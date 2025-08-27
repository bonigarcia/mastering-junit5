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

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.SeleniumUtils;

class ExtentReportsJupiterTest {

    static ExtentReports report;
    ExtentTest test;
    WebDriver driver;

    @BeforeAll
    static void setupClass() {
        report = new ExtentReports();
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(
                "report-junit.html");
        report.attachReporter(htmlReporter);
    }

    @BeforeEach
    void setup(TestInfo testInfo) {
        test = report.createTest(testInfo.getDisplayName());

        driver = new ChromeDriver();
    }

    @AfterEach
    void teardown() {
        String screenshot = SeleniumUtils.getScreenshotAsBase64(driver);
        test.addScreenCaptureFromBase64String(screenshot);

        driver.quit();
    }

    @AfterAll
    static void teardownClass() {
        report.flush();
    }

    @Test
    void testReporting1() {
        checkIndex(driver);
    }

    @Test
    void testReporting2() {
        checkIndex(driver);
    }

    void checkIndex(WebDriver driver) {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        assertThat(driver.getTitle()).contains("Selenium WebDriver");
    }

}

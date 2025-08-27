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

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Method;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsNGTest {

    ExtentReports report;
    ExtentTest test;
    WebDriver driver;

    @BeforeClass
    public void setupClass() {
        report = new ExtentReports();
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(
                "report-testng.html");
        report.attachReporter(htmlReporter);
    }

    @BeforeMethod
    public void setup(Method method) {
        test = report.createTest(method.getName());

        driver = new ChromeDriver();
    }

    @AfterMethod
    public void teardown() {
        test.addScreenCaptureFromBase64String(getScreenshotAsBase64());

        driver.quit();
    }

    @AfterClass
    public void teardownClass() {
        report.flush();
    }

    @Test
    public void testReporting1() {
        checkIndex(driver);
    }

    @Test
    public void testReporting2() {
        checkIndex(driver);
    }

    void checkIndex(WebDriver driver) {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        assertThat(driver.getTitle()).contains("Selenium WebDriver");
    }

    String getScreenshotAsBase64() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    }

}

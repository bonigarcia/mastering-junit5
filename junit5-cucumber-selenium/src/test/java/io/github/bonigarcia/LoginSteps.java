/*
 * (C) Copyright 2020 Boni Garcia (https://bonigarcia.github.io/)
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
package io.github.bonigarcia;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {

    private WebDriver driver;

    @When("I navigate to {string}")
    public void iNavigateTo(String url) {
        driver = WebDriverManager.chromedriver().create();
        driver.get(url);
    }

    @And("I login with the username {string} and password {string}")
    public void iLogin(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);

    }

    @And("I click Submit")
    public void iPressEnter() {
        driver.findElement(By.cssSelector("button")).click();
    }

    @Then("I should be see the message {string}")
    public void iShouldSee(String result) {
        try {
            WebDriverWait wait = new WebDriverWait(driver,
                    Duration.ofSeconds(10));
            wait.until(ExpectedConditions.textToBePresentInElementLocated(
                    By.tagName("body"), result));
        } catch (NoSuchElementException e) {
            throw new AssertionError(
                    "\"" + result + "\" not available in results");
        } finally {
            driver.quit();
        }
    }

}

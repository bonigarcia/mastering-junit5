
package io.github.bonigarcia;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;

@Disabled
@ExtendWith(SeleniumExtension.class)
public class AppiumTest {

    @DriverCapabilities
    DesiredCapabilities capabilities = new DesiredCapabilities();
    {
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("deviceName", "Android");
    }

    @Test
    void testWithAndroid(AppiumDriver<WebElement> android) {
        String context = android.getContext();
        android.context("NATIVE_APP");
        android.findElement(By.id("com.android.chrome:id/terms_accept"))
                .click();
        android.findElement(By.id("com.android.chrome:id/negative_button"))
                .click();
        android.context(context);

        android.get("https://bonigarcia.github.io/selenium-jupiter/");
        assertTrue(android.getTitle().contains("JUnit 5 extension"));
    }

}

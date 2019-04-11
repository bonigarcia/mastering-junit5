
package io.github.bonigarcia;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.remote.RemoteWebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Disabled
@ExtendWith(SeleniumExtension.class)
class RemoteWebDriverTest {

    @Test
    void testWithRemoteChrome(
            @DriverUrl("http://localhost:4444/wd/hub") @DriverCapabilities({
                    "browserName=chrome",
                    "version=59" }) RemoteWebDriver remoteChrome) {

        remoteChrome.get("https://bonigarcia.github.io/selenium-jupiter/");

        assertTrue(remoteChrome.getTitle().contains("JUnit 5 extension"));
    }

}

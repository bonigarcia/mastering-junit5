
package io.github.bonigarcia;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

@ExtendWith(SeleniumExtension.class)
public class LocalWebDriverTest {

    @Test
    public void testWithChrome(ChromeDriver chrome) {
        chrome.get("https://bonigarcia.github.io/selenium-jupiter/");

        assertTrue(chrome.getTitle().startsWith("Selenium-Jupiter"));
    }

    @Test
    public void testWithFirefox(FirefoxDriver firefox) {
        firefox.get("http://www.seleniumhq.org/");

        assertTrue(firefox.getTitle().startsWith("Selenium"));
    }

    @Test
    public void testWithHeadlessBrowsers(HtmlUnitDriver htmlUnit,
            PhantomJSDriver phantomjs) {
        htmlUnit.get("https://bonigarcia.github.io/selenium-jupiter/");
        phantomjs.get("https://bonigarcia.github.io/selenium-jupiter/");

        assertTrue(htmlUnit.getTitle().contains("JUnit 5 extension"));
        assertNotNull(phantomjs.getPageSource());
    }

}

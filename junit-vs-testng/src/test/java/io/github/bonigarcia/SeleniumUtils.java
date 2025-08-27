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
package io.github.bonigarcia;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class SeleniumUtils {

    public static String getScreenshotAsBase64(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    }

    public static void getScreenshotAsFile(WebDriver driver, String filename) {
        File screenshot = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);
        Path destination = Paths.get(filename + ".png");
        try {
            Files.move(screenshot.toPath(), destination, REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static WebDriver getDriverFromTestInstance(Object testInstance,
            String fieldName) {
        try {
            Class<?> clazz = testInstance.getClass();
            Field field = null;
            while (clazz != null) { // Seek driver in test class or parent
                try {
                    field = clazz.getDeclaredField(fieldName);
                    break; // found it
                } catch (NoSuchFieldException e) {
                    clazz = clazz.getSuperclass(); // move up
                }
            }
            if (field != null) {
                field.setAccessible(true);
                return (WebDriver) field.get(testInstance);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        throw new RuntimeException("Driver not found in test class");
    }

}

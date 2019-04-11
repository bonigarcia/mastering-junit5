
package io.github.bonigarcia;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CustomNamesParameterizedTest {

    @DisplayName("Display name of test container")
    @ParameterizedTest(name = "[{index}] first argument=\"{0}\", second argument={1}")
    @CsvSource({ "mastering, 1", "parameterized, 2", "tests, 3" })
    void testWithCustomDisplayNames(String first, int second) {
        System.out.println(
                "Testing with parameters: " + first + " and " + second);
    }

}

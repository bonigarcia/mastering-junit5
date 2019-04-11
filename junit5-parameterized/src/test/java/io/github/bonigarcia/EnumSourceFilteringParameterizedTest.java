
package io.github.bonigarcia;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.params.provider.EnumSource.Mode.EXCLUDE;
import static org.junit.jupiter.params.provider.EnumSource.Mode.MATCH_ALL;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class EnumSourceFilteringParameterizedTest {

    @ParameterizedTest
    @EnumSource(value = TimeUnit.class, names = { "DAYS", "HOURS" })
    void testWithFilteredEnum(TimeUnit argument) {
        System.out.println("Parameterized test with some (TimeUnit) argument: "
                + argument);
        assertNotNull(argument);
    }

    @ParameterizedTest
    @EnumSource(value = TimeUnit.class, mode = EXCLUDE, names = { "DAYS",
            "HOURS" })
    void testWithExcludeEnum(TimeUnit argument) {
        System.out.println(
                "Parameterized test with excluded (TimeUnit) argument: "
                        + argument);
        assertNotNull(argument);
    }

    @ParameterizedTest
    @EnumSource(value = TimeUnit.class, mode = MATCH_ALL, names = "^(M|N).+SECONDS$")
    void testWithRegexEnum(TimeUnit argument) {
        System.out.println(
                "Parameterized test with regex filtered (TimeUnit) argument: "
                        + argument);
        assertNotNull(argument);
    }

}

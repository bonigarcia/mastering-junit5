
package io.github.bonigarcia;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ImplicitConversionParameterizedTest {

    @ParameterizedTest
    @ValueSource(strings = "true")
    void testWithImplicitConversionToBoolean(Boolean argument) {
        System.out.println("Argument " + argument + " is a type of "
                + argument.getClass());
        assertTrue(argument);
    }

    @ParameterizedTest
    @ValueSource(strings = "11")
    void testWithImplicitConversionToInteger(Integer argument) {
        System.out.println("Argument " + argument + " is a type of "
                + argument.getClass());
        assertTrue(argument > 10);
    }

    @ParameterizedTest
    @ValueSource(strings = "SECONDS")
    void testWithImplicitConversionToEnum(TimeUnit argument) {
        System.out.println("Argument " + argument + " is a type of "
                + argument.getDeclaringClass());
        assertNotNull(argument.name());
    }

    @ParameterizedTest
    @ValueSource(strings = "2017-07-25")
    void testWithImplicitConversionToLocalDate(LocalDate argument) {
        System.out.println("Argument " + argument + " is a type of "
                + argument.getClass());
        assertNotNull(argument);
    }

}


package io.github.bonigarcia;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.EnumSource;

class ExplicitConversionParameterizedTest {

    @ParameterizedTest
    @EnumSource(TimeUnit.class)
    void testWithExplicitArgumentConversion(
            @ConvertWith(CustomArgumentsConverter.class) String argument) {
        System.out.println("Argument " + argument + " is a type of "
                + argument.getClass());

        assertNotNull(argument);
    }

}

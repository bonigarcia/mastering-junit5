
package io.github.bonigarcia;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MethodSourceMixedTypesParameterizedTest {

    static Stream<Arguments> stringAndIntProvider() {
        return Stream.of(Arguments.of("Mastering", 10),
                Arguments.of("JUnit 5", 20));
    }

    @ParameterizedTest
    @MethodSource("stringAndIntProvider")
    void testWithMultiArgMethodSource(String first, int second) {
        System.out.println("Parameterized test with two arguments: (String) "
                + first + " and (int) " + second);

        assertNotNull(first);
        assertNotEquals(0, second);
    }

}

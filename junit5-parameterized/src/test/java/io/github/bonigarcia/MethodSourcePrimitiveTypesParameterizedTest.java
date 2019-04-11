
package io.github.bonigarcia;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class MethodSourcePrimitiveTypesParameterizedTest {

    static IntStream intProvider() {
        return IntStream.of(0, 1);
    }

    @ParameterizedTest
    @MethodSource("intProvider")
    void testWithIntProvider(int argument) {
        System.out
                .println("Parameterized test with (int) argument: " + argument);
        assertNotNull(argument);
    }

    static DoubleStream doubleProvider() {
        return DoubleStream.of(2d, 3d);
    }

    @ParameterizedTest
    @MethodSource("doubleProvider")
    void testWithDoubleProvider(double argument) {
        System.out.println(
                "Parameterized test with (double) argument: " + argument);
        assertNotNull(argument);
    }

    static LongStream longProvider() {
        return LongStream.of(4L, 5L);
    }

    @ParameterizedTest
    @MethodSource("longProvider")
    void testWithLongProvider(long argument) {
        System.out.println(
                "Parameterized test with (long) argument: " + argument);
        assertNotNull(argument);
    }

}

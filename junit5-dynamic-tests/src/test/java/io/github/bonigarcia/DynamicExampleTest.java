
package io.github.bonigarcia;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.stream.Stream;

import static org.junit.jupiter.api.DynamicTest.dynamicTest;

class DynamicExampleTest {

    @TestFactory
    Stream<DynamicTest> dynamicTestsFromStream() {
        Stream<String> inputStream = Stream.of("A", "B", "C");
        return inputStream.map(
                input -> dynamicTest("Display name for input " + input, () -> System.out.println("Testing " + input)));
    }

}

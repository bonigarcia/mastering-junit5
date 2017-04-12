/*
 * (C) Copyright 2017 Boni Garcia (http://bonigarcia.github.io/)
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

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.stream;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Function;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.ThrowingConsumer;

class StreamExampleTest {

    @TestFactory
    Stream<DynamicTest> streamTest() {
        // Input data
        Integer array[] = { 1, 2, 3 };
        Iterator<Integer> inputGenerator = Arrays.asList(array).iterator();

        // Display names
        Function<Integer, String> displayNameGenerator = (
                input) -> "Data input:" + input;

        // Test executor
        ThrowingConsumer<Integer> testExecutor = (input) -> {
            System.out.println(input);
            assertTrue(input % 2 == 0);
        };

        // Returns a stream of dynamic tests
        return stream(inputGenerator, displayNameGenerator, testExecutor);
    }

}
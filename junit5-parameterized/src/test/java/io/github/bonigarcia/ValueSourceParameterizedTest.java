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

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValueSourceParameterizedTest {

    @ParameterizedTest
    @ValueSource(strings = { "Hello", "World" })
    void testWithStrings(String param) {
        System.out.println("String parameter: " + param);
        assertNotNull(param);
    }

    @ParameterizedTest
    @ValueSource(ints = { 0, 1 })
    void testWithInts(int param) {
        System.out.println("int parameter: " + param);
        assertNotNull(param);
    }

    @ParameterizedTest
    @ValueSource(booleans = { true, false })
    void testWithBooleans(boolean param) {
        System.out.println("boolean parameter: " + param);
        assertNotNull(param);
    }

}

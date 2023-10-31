/*
 * (C) Copyright 2017 Boni Garcia (https://bonigarcia.github.io/)
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
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled
class DummyTest {

    @Test
    void successTest() {
        System.out.println("This is a sucess test");
        assertTrue(true);
    }

    @Test
    void failTest1() {
        System.out.println("This is a failed test [1]");
        fail();
    }

    @Test
    void failTest2() {
        System.out.println("This is a failed test [2]");
        fail();
    }

    @Disabled
    @Test
    void ignoredTest() {
        // Nothing
    }

}

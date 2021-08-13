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

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("A stack test")
class StackTest {

    @Test
    @DisplayName("is instantiated")
    void isInstantiated() {
    }

    @Nested
    @DisplayName("when empty")
    class WhenNew {

        @Test
        @DisplayName("is empty")
        void isEmpty() {
        }

        @Test
        @DisplayName("throws Exception when popped")
        void throwsExceptionWhenPopped() {
        }

        @Test
        @DisplayName("throws Exception when peeked")
        void throwsExceptionWhenPeeked() {
        }

        @Nested
        @DisplayName("after pushing an element")
        class AfterPushing {

            @Test
            @DisplayName("it is no longer empty")
            void isNotEmpty() {
            }

            @Test
            @DisplayName("returns the element when popped")
            void returnElementWhenPopped() {
            }

            @Test
            @DisplayName("returns the element when peeked")
            void returnElementWhenPeeked() {
            }
        }
    }
}
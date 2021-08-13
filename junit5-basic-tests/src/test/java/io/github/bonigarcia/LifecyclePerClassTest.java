/*
 * (C) Copyright 2020 Boni Garcia (https://bonigarcia.github.io/)
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

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.slf4j.Logger;

@TestInstance(Lifecycle.PER_CLASS)
class LifecyclePerClassTest {

    static final Logger log = getLogger(lookup().lookupClass());

    @BeforeAll
    void setupAll() {
        log.debug("@BeforeAll");
    }

    @BeforeEach
    void setup() {
        log.debug("@BeforeEach");
    }

    @Test
    void test1() {
        log.debug("@Test [1]");
    }

    @Test
    void test2() {
        log.debug("@Test [2]");
    }

    @AfterEach
    void teardown() {
        log.debug("@AfterEach");
    }

    @AfterAll
    void teardownAll() {
        log.debug("@AfterAll");
    }

}

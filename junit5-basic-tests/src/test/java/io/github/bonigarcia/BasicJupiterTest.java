/*
 * (C) Copyright 2020 Boni Garcia (http://bonigarcia.github.io/)
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

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

class BasicJupiterTest {

    static final Logger log = getLogger(lookup().lookupClass());

    MySUT mySut;

    @BeforeEach
    void setup() {
        // setup
        mySut = new MySUT("Test_" + System.nanoTime());
        mySut.init();
    }

    @Test
    void sumTest() {
        log.debug("Testing sum method in {} SUT", mySut.getName());

        // exercise
        int sum = mySut.sum(1, 2, 3);

        // verify
        Assertions.assertTrue(sum == 6);
    }

    @Test
    void concanateTest() {
        log.debug("Testing sum concatenate in {} SUT", mySut.getName());

        // exercise
        String phrase = mySut.concatenate("hello", "world");

        // verify
        Assertions.assertTrue(phrase.equals("hello world"));
    }

    @AfterEach
    void teardown() {
        // release
        mySut.release();
    }

}

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

import static java.lang.invoke.MethodHandles.lookup;
import static org.junit.Assert.assertTrue;
import static org.slf4j.LoggerFactory.getLogger;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import org.slf4j.Logger;

@RunWith(Theories.class)
public class MyTheoryTest {

    static final Logger log = getLogger(lookup().lookupClass());

    @DataPoints
    public static int[] positiveIntegers() {
        return new int[] { 1, 10, 100 };
    }

    @Theory
    public void testSum(int a, int b) {
        log.debug("Checking {} + {}", a, b);
        assertTrue(a + b > a);
        assertTrue(a + b > b);
    }
}

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

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;


class CustomTestOrder implements MethodOrderer {
    @Override
    public void orderMethods(MethodOrdererContext context) {
        context.getMethodDescriptors().sort(
                (MethodDescriptor m1, MethodDescriptor m2) ->
                        m1.getMethod().getName().compareToIgnoreCase(m2.getMethod().getName()));
    }
}

@TestMethodOrder(CustomTestOrder.class)
class CustomOrderedTest {

    static final Logger log = getLogger(lookup().lookupClass());

    @Test
    void testStep1() {
        log.debug("Step 1");
    }

    @Test
    void testStep2() {
        log.debug("Step 2");
    }

    @Test
    void testStep0() {
        log.debug("Step 0");
    }

}

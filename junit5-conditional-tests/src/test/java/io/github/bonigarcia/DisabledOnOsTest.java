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

import static org.slf4j.LoggerFactory.getLogger;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import static io.github.bonigarcia.Os.MAC;
import static java.lang.invoke.MethodHandles.lookup;
import static io.github.bonigarcia.Os.LINUX;

class DisabledOnOsTest {

    static final Logger log = getLogger(lookup().lookupClass());

    @DisabledOnOs({ MAC, LINUX })
    @Test
    void conditionalTest() {
        log.debug("This test will be disabled on MAC and LINUX");
    }

}

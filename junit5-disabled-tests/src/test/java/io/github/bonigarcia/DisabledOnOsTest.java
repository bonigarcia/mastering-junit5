/*
 * (C) Copyright 2018 Boni Garcia (https://bonigarcia.github.io/)
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
import static org.junit.jupiter.api.condition.OS.LINUX;
import static org.junit.jupiter.api.condition.OS.MAC;
import static org.junit.jupiter.api.condition.OS.WINDOWS;
import static org.slf4j.LoggerFactory.getLogger;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.slf4j.Logger;

class DisabledOnOsTest {

    static final Logger log = getLogger(lookup().lookupClass());

    @DisabledOnOs(LINUX)
    @Test
    void notLinuxTest() {
        log.debug("Disabled on Linux");
    }

    @DisabledOnOs(WINDOWS)
    @Test
    void notWinTest() {
        log.debug("Disabled on Windows");
    }

    @DisabledOnOs(MAC)
    @Test
    void notMacTest() {
        log.debug("Disabled on Mac");
    }

}

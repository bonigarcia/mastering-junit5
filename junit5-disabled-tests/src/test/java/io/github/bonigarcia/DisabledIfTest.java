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

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariables;
import org.junit.jupiter.api.condition.DisabledIfSystemProperties;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledIf;
import org.slf4j.Logger;

@Disabled("All tests in this class are skipped")
class DisabledIfTest {

    static final Logger log = getLogger(lookup().lookupClass());

    @Test
    @EnabledIf("customCondition")
    void test() {
        log.debug("This test is executed");
    }

    @DisabledIf("customCondition")
    void skippedTest() {
        log.debug("This test is NOT executed");
    }

    @DisabledIfEnvironmentVariable(named = "ENV", matches = "staging-server")
    void envTest() {
        log.debug(
                "This test is executed depending on the value of an environment variable");
    }

    @DisabledIfEnvironmentVariables({
            @DisabledIfEnvironmentVariable(named = "ENV", matches = ".*development.*"),
            @DisabledIfEnvironmentVariable(named = "OS_ARCH", matches = ".*64.*") })
    void envsTest() {
        log.debug(
                "This test is executed depending on the value of several environment variables");
    }

    @DisabledIfSystemProperty(named = "ci-server", matches = "true")
    void sysPropTest() {
        log.debug(
                "This test is executed depending on the value of a system property");
    }

    @DisabledIfSystemProperties({
            @DisabledIfSystemProperty(named = "ci-server", matches = "true"),
            @DisabledIfSystemProperty(named = "jenkins", matches = "true") })
    void sysPropsTest() {
        log.debug(
                "This test is executed depending on the value of several system properties");
    }

    boolean customCondition() {
        return true;
    }

}

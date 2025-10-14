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
import static org.junit.jupiter.api.condition.JRE.JAVA_17;
import static org.junit.jupiter.api.condition.JRE.JAVA_18;
import static org.junit.jupiter.api.condition.JRE.JAVA_19;
import static org.junit.jupiter.api.condition.JRE.JAVA_25;
import static org.slf4j.LoggerFactory.getLogger;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledForJreRange;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.slf4j.Logger;

class DisabledOnJreRangeTest {

    static final Logger log = getLogger(lookup().lookupClass());

    @Test
    @EnabledOnJre(JAVA_17)
    void onlyOnJava17() {
        log.debug("This test is executed only for JRE 17");
    }

    @Test
    @EnabledOnJre({ JAVA_18, JAVA_19 })
    void onJava18Or19() {
        log.debug("This test is executed only for JRE 18 or 19 ");
    }

    @Test
    @EnabledForJreRange(min = JAVA_19, max = JAVA_25)
    void fromJava19to25() {
        log.debug("This test is executed only for JRE 19 to 25");
    }

    @Test
    @EnabledForJreRange(min = JAVA_18)
    void fromJava18toCurrentJavaFeatureNumber() {
        log.debug("This test is executed only for JRE 18+");
    }

    @Test
    @EnabledForJreRange(max = JAVA_18)
    void maxJava18() {
        log.debug("This test is executed only up to JRE 18");
    }

    @Test
    @DisabledOnJre(JAVA_17)
    void notOnJava17() {
        log.debug("This test is executed only for JRE != 17");
    }

    @Test
    @DisabledForJreRange(min = JAVA_18, max = JAVA_19)
    void notFromJava18to19() {
        log.debug("This test is executed only for JRE != 18 to 19");
    }

    @Test
    @DisabledForJreRange(min = JAVA_18)
    void notFromJava18toCurrentJavaFeatureNumber() {
        log.debug("This test is executed only for JRE < 18");
    }

    @Test
    @DisabledForJreRange(max = JAVA_25)
    void notFromJava25() {
        log.debug("This test is executed only for JRE < 25");
    }

}

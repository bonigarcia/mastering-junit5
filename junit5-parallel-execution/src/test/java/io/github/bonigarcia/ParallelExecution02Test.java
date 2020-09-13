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

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

class ParallelExecution02Test {

    static final Logger log = getLogger(lookup().lookupClass());

    @Test
    void test01() {
        log.debug("ParallelExecution02Test.test01");
    }

    @Test
    void test02() {
        log.debug("ParallelExecution02Test.test02");
    }

    @Test
    void test03() {
        log.debug("ParallelExecution02Test.test03");
    }

}

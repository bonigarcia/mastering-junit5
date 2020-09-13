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
import static org.junit.Assert.fail;
import static org.slf4j.LoggerFactory.getLogger;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.slf4j.Logger;

public class TestRuleWatcher {

    static final Logger log = getLogger(lookup().lookupClass());

    @Rule
    public TestWatcher watchman = new TestWatcher() {
        @Override
        protected void succeeded(Description description) {
            log.debug("Test succeeded: {}", description.getMethodName());
        }

        @Override
        protected void failed(Throwable e, Description description) {
            log.debug("Test failed: {}", description.getMethodName());
        }
    };

    @Ignore
    @Test
    public void redTest() {
        fail();
    }

    @Test
    public void greenTest() {
    }

}

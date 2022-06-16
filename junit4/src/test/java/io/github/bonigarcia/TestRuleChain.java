/*
 * (C) Copyright 2022 Boni Garcia (https://bonigarcia.github.io/)
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

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.slf4j.Logger;

public class TestRuleChain {

    static final Logger log = getLogger(lookup().lookupClass());

    @Rule
    public TestRule chain = RuleChain.outerRule(new BasicRule("outer"))
            .around(new BasicRule("middle")).around(new BasicRule("inner"));

    @BeforeClass
    public static void beforeclass() {
        log.debug("@BeforeClass");
    }

    @Before
    public void before() {
        log.debug("@Before");
    }

    @Test
    public void test1() {
        log.debug("@Test 1");
    }

    @Test
    public void test2() {
        log.debug("@Test 2");
    }

    @Test
    public void test3() {
        log.debug("@Test 3");
    }

    @AfterClass
    public static void afterclass() {
        log.debug("@AfterClass");
    }

    @After
    public void after() {
        log.debug("@After");
    }

    private static class BasicRule implements TestRule {

        private String name;

        public BasicRule(String name) {
            this.name = name;
        }

        public Statement apply(final Statement base,
                final Description description) {
            log.debug("Rule {} applied", name);
            return base;
        }

    }

}

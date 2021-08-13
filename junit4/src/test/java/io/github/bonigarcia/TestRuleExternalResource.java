/*
 * (C) Copyright 2017 Boni Garcia (https://bonigarcia.github.io/)
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

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExternalResource;
import org.slf4j.Logger;

public class TestRuleExternalResource {

    static final Logger log = getLogger(lookup().lookupClass());

    private Resource resource;

    @Rule
    public ExternalResource rule = new ExternalResource() {
        @Override
        protected void before() throws Throwable {
            resource = new Resource();
            resource.open();
        }

        @Override
        protected void after() {
            resource.close();
        }
    };

    @Test
    public void someTest() throws Exception {
        log.debug("Resource in one test {}", resource.get());
    }

    @Test
    public void someTest2() throws Exception {
        log.debug("Resource in other test {}", resource.get());
    }

}

class Resource {
    static final Logger log = getLogger(lookup().lookupClass());

    public void open() {
        log.debug("Opened");
    }

    public void close() {
        log.debug("Closed");
    }

    public double get() {
        return Math.random();
    }
}

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

import java.lang.reflect.Method;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;
import org.junit.jupiter.api.extension.ExtensionContext.Store;
import org.junit.jupiter.api.extension.TestExtensionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimingExtension
        implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

    static final Logger log = LoggerFactory
            .getLogger(TimingExtension.class.getName());

    @Override
    public void beforeTestExecution(TestExtensionContext context)
            throws Exception {
        getStore(context).put(context.getTestMethod().get(),
                System.currentTimeMillis());
    }

    @Override
    public void afterTestExecution(TestExtensionContext context)
            throws Exception {
        Method testMethod = context.getTestMethod().get();
        long start = getStore(context).remove(testMethod, long.class);
        long duration = System.currentTimeMillis() - start;

        log.info("Method {} took {} ms", testMethod.getName(), duration);
    }

    private Store getStore(TestExtensionContext context) {
        return context.getStore(Namespace.create(getClass(), context));
    }

}

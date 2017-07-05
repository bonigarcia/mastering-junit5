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

import java.lang.reflect.AnnotatedElement;
import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.platform.commons.util.AnnotationUtils;

public class OsCondition implements ExecutionCondition {

    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(
            ExtensionContext context) {

        Optional<AnnotatedElement> element = context.getElement();
        ConditionEvaluationResult out = ConditionEvaluationResult
                .enabled("@DisabledOnOs is not present");

        Optional<DisabledOnOs> disabledOnOs = AnnotationUtils
                .findAnnotation(element, DisabledOnOs.class);

        if (disabledOnOs.isPresent()) {
            Os myOs = Os.determine();
            if (Arrays.asList(disabledOnOs.get().value()).contains(myOs)) {
                out = ConditionEvaluationResult
                        .disabled("Test is disabled on " + myOs);
            } else {
                out = ConditionEvaluationResult
                        .enabled("Test is not disabled on " + myOs);
            }
        }

        System.out.println(out);

        return out;
    }

}

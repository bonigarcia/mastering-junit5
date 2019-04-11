
package io.github.bonigarcia;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.platform.commons.util.AnnotationUtils;

import java.lang.reflect.AnnotatedElement;
import java.util.Arrays;
import java.util.Optional;

class OsCondition implements ExecutionCondition {

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

        System.out.println("--> " + out.getReason().get());
        return out;
    }

}

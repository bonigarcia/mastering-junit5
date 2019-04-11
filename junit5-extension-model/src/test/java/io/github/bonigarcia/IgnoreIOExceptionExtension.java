
package io.github.bonigarcia;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

import java.io.IOException;

class IgnoreIOExceptionExtension
        implements TestExecutionExceptionHandler {

    @Override
    public void handleTestExecutionException(ExtensionContext context,
            Throwable throwable) throws Throwable {

        if (throwable instanceof IOException) {
            return;
        }
        throw throwable;
    }

}


package io.github.bonigarcia;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import java.io.IOException;

class ExceptionTest {

    @RegisterExtension
    static IgnoreIOExceptionExtension ignoreIOExceptionExtension = new IgnoreIOExceptionExtension();

    @Test
    void firstTest() throws IOException {
        throw new IOException("IO Exception");
    }

    @Test
    void secondTest() throws IOException {
        throw new IOException("My IO Exception");
    }

}

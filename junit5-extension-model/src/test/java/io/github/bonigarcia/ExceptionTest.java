
package io.github.bonigarcia;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

public class ExceptionTest {

    @RegisterExtension
    static IgnoreIOExceptionExtension ignoreIOExceptionExtension = new IgnoreIOExceptionExtension();

    @Test
    public void firstTest() throws IOException {
        throw new IOException("IO Exception");
    }

    @Test
    public void secondTest() throws IOException {
        throw new IOException("My IO Exception");
    }

}

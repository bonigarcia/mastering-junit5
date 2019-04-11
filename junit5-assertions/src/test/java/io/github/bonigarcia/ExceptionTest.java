
package io.github.bonigarcia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ExceptionTest {

    @Test
    void exceptionTesting() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    throw new IllegalArgumentException("a message");
                });
        assertEquals("a message", exception.getMessage());
    }

}

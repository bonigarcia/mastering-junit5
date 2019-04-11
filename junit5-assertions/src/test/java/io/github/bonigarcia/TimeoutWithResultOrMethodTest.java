
package io.github.bonigarcia;

import static java.time.Duration.ofMinutes;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import org.junit.jupiter.api.Test;

class TimeoutWithResultOrMethodTest {

    @Test
    void timeoutNotExceededWithResult() {
        String actualResult = assertTimeout(ofMinutes(1), () -> {
            return "hi there";
        });
        assertEquals("hi there", actualResult);
    }

    @Test
    void timeoutNotExceededWithMethod() {
        String actualGreeting = assertTimeout(ofMinutes(1),
                TimeoutWithResultOrMethodTest::greeting);
        assertEquals("hello world!", actualGreeting);
    }

    private static String greeting() {
        return "hello world!";
    }

}


package io.github.bonigarcia;

import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMinutes;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

class TimeoutWithResultOrMethodTest {

    @Test
    void timeoutNotExceededWithResult() {
        String actualResult = assertTimeout(ofMinutes(1), () -> "hi there");
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

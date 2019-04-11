
package io.github.bonigarcia;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class TimeoutWithPreemptiveTerminationTest {

    @Disabled
    @Test
    void timeoutExceededWithPreemptiveTermination() {
        assertTimeoutPreemptively(ofMillis(10), () -> {
            Thread.sleep(100);
        });
    }

}

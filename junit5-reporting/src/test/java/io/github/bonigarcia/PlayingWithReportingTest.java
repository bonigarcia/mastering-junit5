
package io.github.bonigarcia;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Disabled
class PlayingWithReportingTest {

    @Test
    void successTest() {
        assertTrue(true);
    }

    @Test
    void failureTest() {
        assertTrue(false);
    }

    @Test
    void errorTest() {
        throw new RuntimeException("This test is broken!");
    }

}

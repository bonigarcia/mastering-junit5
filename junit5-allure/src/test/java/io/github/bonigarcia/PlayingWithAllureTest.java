
package io.github.bonigarcia;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Disabled
class PlayingWithAllureTest {

    @Test
    void successTest() {
        assertTrue(true);
    }

    @Test
    void failureTest() {
        assertTrue(false);
    }

    @Test
    void brokenTest() {
        throw new RuntimeException("This test seems to be broken!");
    }

    @Test
    void slowSucessTest() throws InterruptedException {
        Thread.sleep(500);
    }

    @Test
    void slowFailureTest() throws InterruptedException {
        Thread.sleep(600);
        assertTrue(false);
    }

    @Test
    void slowBrokenTest() throws InterruptedException {
        Thread.sleep(700);
        throw new RuntimeException("ZZZ...");
    }

}

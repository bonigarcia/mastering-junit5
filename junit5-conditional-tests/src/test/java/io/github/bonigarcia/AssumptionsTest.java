
package io.github.bonigarcia;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

class AssumptionsTest {

    @Test
    void assumeTrueTest() {
        assumeTrue(false);
        fail("Test 1 failed");
    }

    @Test
    void assumeFalseTest() {
        assumeFalse(this::getTrue);
        fail("Test 2 failed");
    }

    private boolean getTrue() {
        return true;
    }

    @Test
    void assummingThatTest() {
        assumingThat(false, () -> fail("Test 3 failed"));
    }

}

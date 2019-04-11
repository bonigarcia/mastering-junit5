
package io.github.bonigarcia;

import org.junit.Test;

import static org.junit.Assume.assumeFalse;

public class TestAssumptions {

    @Test
    public void assumptionTest() {
        assumeFalse(true);
        // This test will be skipped
    }

}

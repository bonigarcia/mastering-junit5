
package io.github.bonigarcia;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LegacyJUnit4Test {

    @Test
    public void myFirstTest() {
        String message = "1+1 should be equal to 2";
        System.out.println(message);

        assertEquals(message, 2, 1 + 1);
    }

}

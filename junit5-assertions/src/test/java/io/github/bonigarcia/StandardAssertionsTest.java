
package io.github.bonigarcia;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StandardAssertionsTest {

    @Test
    void standardAssertions() {
        assertEquals(2, 2);
        assertTrue(true,
                "The optional assertion message is now the last parameter");
        assertFalse(false, "Really " + "expensive " + "message" + ".");
    }

}

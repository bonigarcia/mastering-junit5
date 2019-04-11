
package io.github.bonigarcia;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GroupedAssertionsTest {

    @Test
    void groupedAssertions() {
        Address address = new Address("John", "Smith");

        // In a grouped assertion all assertions are executed, and any
        // failures will be reported together.
        assertAll("address", () -> assertEquals("John", address.getFirstName()),
                () -> assertEquals("Smith", address.getLastName()));
    }

}

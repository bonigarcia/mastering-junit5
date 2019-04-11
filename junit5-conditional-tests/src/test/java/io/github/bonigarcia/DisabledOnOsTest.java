
package io.github.bonigarcia;

import org.junit.jupiter.api.Test;

import static io.github.bonigarcia.Os.LINUX;
import static io.github.bonigarcia.Os.MAC;

class DisabledOnOsTest {

    @DisabledOnOs({ MAC, LINUX })
    @Test
    void conditionalTest() {
        System.out.println("This test will be disabled on MAC and LINUX");
    }

}

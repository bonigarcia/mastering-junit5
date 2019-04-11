
package io.github.bonigarcia;

import org.junit.jupiter.api.Test;

class NonFunctionalTest {

    @Test
    @Load
    void testOne() {
        System.out.println("Non-Functional Test 1 (Performance/Load)");
    }

    @Test
    @Stress
    void testTwo() {
        System.out.println("Non-Functional Test 2 (Performance/Stress)");
    }

    @Test
    @Security
    void testThree() {
        System.out.println("Non-Functional Test 2 (Security)");
    }

    @Test
    @Usability
    void testFour() {
        System.out.println("Non-Functional Test 2 (Usability)");
    }

}

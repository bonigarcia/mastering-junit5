
package io.github.bonigarcia;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LifecycleJUnit5Test {

    @BeforeAll
    static void setupAll() {
        System.out.println("Setup ALL TESTS in the class");
    }

    @BeforeEach
    void setup() {
        System.out.println("Setup EACH TEST in the class");
    }

    @Test
    void testOne() {
        System.out.println("TEST 1");
    }

    @Test
    void testTwo() {
        System.out.println("TEST 2");
    }

    @AfterEach
    void teardown() {
        System.out.println("Teardown EACH TEST in the class");
    }

    @AfterAll
    static void teardownAll() {
        System.out.println("Teardown ALL TESTS in the class");
    }

}

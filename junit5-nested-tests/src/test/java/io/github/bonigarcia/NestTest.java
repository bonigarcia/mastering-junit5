
package io.github.bonigarcia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class NestTest {

    @BeforeEach
    void setup1() {
        System.out.println("Setup 1");
    }

    @Test
    void topTest() {
        System.out.println("Test 1");
    }

    @Nested
    class InnerClass1 {
        @BeforeEach
        void setup2() {
            System.out.println("Setup 2");
        }

        @Test
        void innerTest1() {
            System.out.println("Test 2");
        }

        @Nested
        class InnerClass2 {
            @Test
            void innerTest2() {
                System.out.println("Test 3");
            }
        }
    }
}

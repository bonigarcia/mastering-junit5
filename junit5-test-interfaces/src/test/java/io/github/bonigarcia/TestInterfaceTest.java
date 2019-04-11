
package io.github.bonigarcia;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestInterfaceTest implements TestLifecycleLogger, TimeExecutionLogger,
        TestInterfaceDynamicTestsDemo {

    @Test
    void isEqualValue() {
        assertEquals(1, 1);
    }

}


package io.github.bonigarcia;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import static org.junit.Assert.assertEquals;

public class TestRuleName {

    @Rule
    public TestName name = new TestName();

    @Test
    public void testA() {
        assertEquals("testA", name.getMethodName());
    }

      @Test
    public void testB() {
        assertEquals("testB", name.getMethodName());
    }
}

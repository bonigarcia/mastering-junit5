
package io.github.bonigarcia;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

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

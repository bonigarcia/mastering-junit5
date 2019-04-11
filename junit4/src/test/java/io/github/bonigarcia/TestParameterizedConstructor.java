
package io.github.bonigarcia;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class TestParameterizedConstructor {

    private int input1;
    private int input2;
    private int sum;

    public TestParameterizedConstructor(int input1, int input2, int sum) {
        this.input1 = input1;
        this.input2 = input2;
        this.sum = sum;
    }

    @Parameters(name = "{index}: input1={0} input2={1} sum={2}?")
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][] { { 1, 1, 2 }, { 2, 2, 4 }, { 3, 3, 6 } });
    }

    @Test
    public void testSum() {
        assertTrue(input1 + "+" + input2 + " is not " + sum,
                input1 + input2 == sum);
    }

}

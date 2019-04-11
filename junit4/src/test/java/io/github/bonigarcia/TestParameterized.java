
package io.github.bonigarcia;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestParameterized {

    @Parameter(0)
    public int input1;

    @Parameter(1)
    public int input2;

    @Parameter(2)
    public int sum;

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

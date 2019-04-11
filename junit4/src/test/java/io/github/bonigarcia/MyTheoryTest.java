
package io.github.bonigarcia;

import static org.junit.Assert.assertTrue;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class MyTheoryTest {

    @DataPoints
    public static int[] positiveIntegers() {
        return new int[] { 1, 10, 100 };
    }

    @Theory
    public void testSum(int a, int b) {
        System.out.println("Checking " + a + "+" + b);
        assertTrue(a + b > a);
        assertTrue(a + b > b);
    }
}

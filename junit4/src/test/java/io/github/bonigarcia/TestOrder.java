
package io.github.bonigarcia;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestOrder {

    @Test
    public void testA() {
        System.out.println("Test 1");
    }

    @Test
    public void testB() {
        System.out.println("Test 2");
    }

    @Test
    public void testC() {
        System.out.println("Test 3");
    }

}

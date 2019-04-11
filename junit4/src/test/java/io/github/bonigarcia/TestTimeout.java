
package io.github.bonigarcia;

import org.junit.Ignore;
import org.junit.Test;

public class TestTimeout {

    @Ignore
    @Test(timeout = 10)
    public void test() {
        while (true)
            ;
    }

}

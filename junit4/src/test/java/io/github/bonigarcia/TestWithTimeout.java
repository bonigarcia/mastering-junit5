
package io.github.bonigarcia;

import org.junit.Ignore;
import org.junit.Test;

public class TestWithTimeout {

    @Ignore
    @Test(timeout = 1000)
    public void test() throws InterruptedException {
        Thread.sleep(2000);
    }

}

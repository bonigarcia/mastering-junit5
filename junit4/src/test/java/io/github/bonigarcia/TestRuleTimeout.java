
package io.github.bonigarcia;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class TestRuleTimeout {

    @Rule
    public Timeout globalTimeout = new Timeout(100, MILLISECONDS);

    @Ignore
    @Test
    public void testInfiniteLoop() {
        while (true)
            ;
    }

    @Test
    public void testDoNothing() {
    }
}

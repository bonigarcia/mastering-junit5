
package io.github.bonigarcia;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

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


package io.github.bonigarcia;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestRuleExpectedException {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void throwsNothing() {
    }

    @Test
    public void throwsNullPointerException() {
        thrown.expect(NullPointerException.class);
        throw new NullPointerException();
    }

}

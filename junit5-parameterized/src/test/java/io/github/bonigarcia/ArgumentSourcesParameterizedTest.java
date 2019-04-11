
package io.github.bonigarcia;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ArgumentsSources;

class ArgumentSourcesParameterizedTest {

    @ParameterizedTest
    @ArgumentsSources({ @ArgumentsSource(CustomArgumentsProvider1.class),
            @ArgumentsSource(CustomArgumentsProvider2.class) })
    void testWithArgumentsSource(String first, int second) {
        System.out.println("Parameterized test with (String) " + first
                + " and (int) " + second);

        assertNotNull(first);
        assertTrue(second > 0);
    }

}


package io.github.bonigarcia;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

class DependencyInjectionTest {

    @ExtendWith(MyParameterResolver.class)
    @Test
    void test(Object parameter) {
        System.out.println("My parameter " + parameter);
    }

}

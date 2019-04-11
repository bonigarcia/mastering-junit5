
package io.github.bonigarcia;

import org.junit.jupiter.params.converter.SimpleArgumentConverter;

class CustomArgumentsConverter extends SimpleArgumentConverter {

    @Override
    protected Object convert(Object source, Class<?> targetType) {
        return String.valueOf(source);
    }

}

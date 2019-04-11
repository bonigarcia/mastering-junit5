
package io.github.bonigarcia;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

class CustomArgumentsProvider2 implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(
            ExtensionContext context) {

        System.out.println("Arguments provider [2] to test "
                + context.getTestMethod().get().getName());

        return Stream.of(Arguments.of("more", 3), Arguments.of("arguments", 4));
    }

}

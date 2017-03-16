package io.github.bonigarcia;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

public class ExceptionTest {

    @ExtendWith(IgnoreIOExceptionExtension.class)
    @Test
    public void test1() throws IOException {
        throw new IOException("My IO Exception");
    }

    @Test
    public void test2() throws IOException {
        throw new IOException("My IO Exception");
    }

}

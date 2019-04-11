
package io.github.bonigarcia;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleSpringBootTest {

    @Autowired
    public MessageComponent messageComponent;

    @Test
    public void test() {
        assertEquals("Hello world!", messageComponent.getMessage());
    }
}

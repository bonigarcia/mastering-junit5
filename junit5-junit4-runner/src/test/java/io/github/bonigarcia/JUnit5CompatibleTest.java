
package io.github.bonigarcia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class JUnit5CompatibleTest {

	@Test
	void myTest() {
		String message = "1+1 should be equal to 2";
		System.out.println(message);

		assertEquals(2, 1 + 1, message);
	}

}

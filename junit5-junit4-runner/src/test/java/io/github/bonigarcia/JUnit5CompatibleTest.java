
package io.github.bonigarcia;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(JUnitPlatform.class)
public class JUnit5CompatibleTest {

	@Test
	void myTest() {
		String message = "1+1 should be equal to 2";
		System.out.println(message);

		assertEquals(2, 1 + 1, message);
	}

}

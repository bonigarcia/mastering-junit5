
package io.github.bonigarcia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MyFirstJUnit5Test {

	@Test
	void myFirstTest() {
		String message = "1+1 should be equal to 2";
		System.out.println(message);

		assertEquals(2, 1 + 1, message);
	}

}

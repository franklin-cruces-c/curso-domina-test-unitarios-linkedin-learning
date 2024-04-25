package cl.zeventek.dominatestunitarios;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MetodoAssertEqualsTest {

	@Test
	void testSintaxis() {
		Assertions.assertEquals(2, 2);// import org.junit.jupiter.api.Assertions;
		assertEquals(2, 2);// import static org.junit.jupiter.api.Assertions.*;
	}

	@Test
	void test1() {
		assertEquals(2, 3);
	}

	@Test
	void test2() {
		assertEquals("", " ");
	}

	@Test
	void test3() {
		assertEquals("", "\n");
	}
}

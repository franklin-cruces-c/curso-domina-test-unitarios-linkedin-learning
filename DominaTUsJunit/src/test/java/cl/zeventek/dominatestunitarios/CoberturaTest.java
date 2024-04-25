package cl.zeventek.dominatestunitarios;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CoberturaTest {

	@Test
	void test1() {
		assertEquals(2, Cobertura.cuentas(2));
	}
	@Test
	void test2() {
		assertEquals(2, Cobertura.cuentas(2));
		assertEquals(9, Cobertura.cuentas(3));
	}
	@Test
	void test3() {
		assertEquals(2, Cobertura.cuentas(2));
		assertEquals(9, Cobertura.cuentas(3));
		assertEquals(-5, Cobertura.cuentas(5));
	}	

}

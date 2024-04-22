package cl.zeventek.dominatestunitarios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class FailTest {

	@Test
	void test1() {
		double res1=0;
		try {
			 res1 = Fail.raiz(25.0);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		assertEquals(5.0,res1);
	}
	@Test
	void test2a() {
		try {
			double res1 = Fail.raiz(-25.0);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			assertTrue(true);
		}
	}
	@Test
	void test2b() {
		try {
			double res1 = Fail.raiz(25.0);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			assertTrue(true);
		}
	}
	@Test
	void test2c() {
		try {
			double res1 = Fail.raiz(-25.0);
			fail("Debería haber lanzado una excepción");
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			assertTrue(true);
		}
	}
	@Test
	void test2d() {
		try {
			double res1 = Fail.raiz(25.0);
			fail("Debería haber lanzado una excepción");
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			assertTrue(true);
		}
	}	
}

package cl.zeventek.dominatestunitarios;

import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class ComprobandoLineasTest {

	@Test
	void test1() {
		try {
			int[] nums = new int[] {1,2};
			int num = nums[10];
			fail("Se esperaba una excepción");
		}catch(ArrayIndexOutOfBoundsException e) {
			assertTrue(e.getMessage().contains("10"));
		}catch(Throwable t) {
			fail(t);
		}
	}

	@Test
	void test2() {
		int[] nums = new int[] {1,2};
		assertThrows(ArrayIndexOutOfBoundsException.class, () ->{
			int num = nums[10];
		});
	}
	
	@Test
	void test3() {
		int[] nums = new int[] {1,2};
		assertThrows(ArrayIndexOutOfBoundsException.class, () ->{
			int num = nums[1];
		}); // ko
		//org.opentest4j.AssertionFailedError: Expected java.lang.ArrayIndexOutOfBoundsException to be thrown, 
		// but nothing was thrown.
	}
	
	@Test
	void test4() {
		int[] nums = new int[] {1,2};
		assertThrows(NullPointerException.class, () ->{
			int num = nums[10];
		}); // ko
		//org.opentest4j.AssertionFailedError: Unexpected exception type thrown, 
		//expected: <java.lang.NullPointerException> but was: <java.lang.ArrayIndexOutOfBoundsException>
	}
	
	@Test
	void test5() {
		int[] nums = new int[] {1,2};
		assertThrows(Exception.class, () ->{
			int num = nums[10];
		}); // ok
	}	

}

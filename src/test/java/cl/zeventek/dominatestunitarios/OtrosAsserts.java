package cl.zeventek.dominatestunitarios;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.Test;

class OtrosAsserts {

	@Test
	void test1() {
		int x = 3;
		assertAll(
				  () -> assertEquals(3, x),
				  () -> assertFalse(x % 2 == 0), 
				  () -> assertTrue(x > 0),
				  () -> assertNotNull(Integer.valueOf(x))
				);// ok

	}
	@Test
	void test2() {
		int x = 4;
		assertAll(
				  () -> assertEquals(4, x),
				  () -> assertFalse(x % 2 == 0), 
				  () -> assertTrue(x > 0),
				  () -> assertNotNull(Integer.valueOf(x))
				);// ko:
		//org.opentest4j.MultipleFailuresError: Multiple Failures (1 failure)
		//org.opentest4j.AssertionFailedError: expected: <false> but was: <true>
	}

	@Test
	void test3() {
		assertTimeout(Duration.of(1, ChronoUnit.MILLIS),
				() ->{
					System.out.println("3 hola");
					Thread.sleep(10);
					System.out.println("adios");
				}
		);// ko:
		//org.opentest4j.AssertionFailedError: execution exceeded timeout of 1 ms by 10 ms
	}
	@Test
	void test4() {
		assertTimeout(Duration.of(20, ChronoUnit.MILLIS),
				() ->{
					System.out.println("4 hola");
					Thread.sleep(2);
					System.out.println("adios");
				}
		);// ok
	}	
	@Test
	void test5() {
		assertTimeoutPreemptively(Duration.of(1, ChronoUnit.MILLIS),
				() ->{
					System.out.println("5 hola");
					Thread.sleep(10);
					System.out.println("adios");
				}
		);// ko:
		//org.opentest4j.AssertionFailedError: execution timed out after 1 ms
	}
	@Test
	void test6() {
		assertTimeoutPreemptively(Duration.of(20, ChronoUnit.MILLIS),
				() ->{
					System.out.println("6 hola");
					Thread.sleep(2);
					System.out.println("adios");
				}
		);// ok
	}		
}

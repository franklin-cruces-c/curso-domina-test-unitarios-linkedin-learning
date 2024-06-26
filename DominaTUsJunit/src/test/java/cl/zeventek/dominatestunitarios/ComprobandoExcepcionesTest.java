package cl.zeventek.dominatestunitarios;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class ComprobandoExcepcionesTest {

	@Test
	void test1() {
		List<String> l1 = Arrays.asList("hola","qué tal","adiós");
		List<String> l2 = Arrays.asList("hola","qué tal","adiós");

		assertLinesMatch(l1, l2);
	}

	@Test
	void test2() {
		List<String> esperada = Arrays.asList("hola",">>>>","adiós");
		List<String> obtenida = Arrays.asList("hola","qué tal","adiós");
	
		assertLinesMatch(esperada, obtenida);//ok
	}
	
	@Test
	void test3() {
		List<String> esperada = Arrays.asList("hola",">>>>","adiós");
		List<String> obtenida = Arrays.asList("hola","qué tal","como estás", "adiós");
		
		assertLinesMatch(esperada, obtenida);//ok
	}
	
	@Test
	void test4() {
		List<String> esperada = Arrays.asList("hola",">> 2 >>","adiós");
		List<String> obtenida = Arrays.asList("hola","qué tal","como estás", "adiós");
		
		assertLinesMatch(esperada, obtenida);//ok
	}
	
	@Test
	void test5() {
		List<String> esperada = Arrays.asList("hola",">> 3 >>","adiós");
		List<String> obtenida = Arrays.asList("hola","qué tal","como estás", "adiós");
		
		assertLinesMatch(esperada, obtenida);//ko
		//org.opentest4j.AssertionFailedError: expected line #3:`adiós` not found - actual lines depleted
	}
	
	@Test
	void test6() {
		List<String> esperada = Arrays.asList("hola",">> 1 >>","adiós");
		List<String> obtenida = Arrays.asList("hola","qué tal","como estás", "adiós");
		
		assertLinesMatch(esperada, obtenida);//ko
		//org.opentest4j.AssertionFailedError: expected line #3 doesn't match actual line #3		
		//expected: `adiós`
		//  actual: `como estás`
	}
	
	@Test
	void test7() {
		List<String> esperada = Arrays.asList("hola",">> 1 >>","\\d+","adiós");
		List<String> obtenida = Arrays.asList("hola","qué tal","33", "adiós");
		
		assertLinesMatch(esperada, obtenida);//ok
	}
	
	@Test
	void test8() {
		List<String> esperada = Arrays.asList("hola",">> 1 >>","\\d+","adiós");
		List<String> obtenida = Arrays.asList("hola","qué tal","s33", "adiós");
		
		assertLinesMatch(esperada, obtenida);//ko
		//org.opentest4j.AssertionFailedError: expected line #3 doesn't match actual line #3
		//expected: `\d+`
		// actual: `s33`
	}

	@Test
	void test9() {
		List<String> esperada = Arrays.asList(
				"Inicio operación",
				"a = \\d+",
				">> trazas previas >>",
				"En operación",
				">> trazas posteriores >>",
				"Fin operación");
		List<String> obtenida = Arrays.asList(
				"Inicio operación",
				"a = 3",
				"b = 8",
				"a + b = 11",
				"En operación",
				"Fin operación");
		
		assertLinesMatch(esperada, obtenida);//ok
	}
}

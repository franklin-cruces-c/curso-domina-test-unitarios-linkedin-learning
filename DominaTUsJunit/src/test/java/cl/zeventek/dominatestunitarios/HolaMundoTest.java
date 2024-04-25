package cl.zeventek.dominatestunitarios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class HolaMundoTest {
	
	@Test
	void testOut() {
		PrintStream originalOut = System.out; // salida original
		ByteArrayOutputStream bos = new ByteArrayOutputStream();// nueva salida
		System.setOut(new PrintStream(bos)); // reemplazo de salida
		
		HolaMundo.main(null);
		String salida = bos.toString(); // recuperación  del contenido
		assertEquals("Hola mundo\n", salida);
		
		System.setOut(originalOut); // restauración de la consola
	}
	
	@Test
	void testErr() {
		PrintStream originalErr = System.out; // salida original
		ByteArrayOutputStream bos = new ByteArrayOutputStream();// nueva salida
		System.setErr(new PrintStream(bos)); // reemplazo de salida
		
		HolaMundo.main(null);
		String salida = bos.toString(); // recuperación  del contenido
		assertEquals("Y adiós", salida.trim());
		
		System.setErr(originalErr); // restauración de la consola
	}	

	@Test
	void testOutErr() {
		PrintStream originalOut = System.out; // salida original
		ByteArrayOutputStream bos = new ByteArrayOutputStream();// nueva salida
		System.setOut(new PrintStream(bos)); // reemplazo de salida
		
		PrintStream originalErr = System.out; // salida original
		ByteArrayOutputStream bosErr = new ByteArrayOutputStream();// nueva salida
		System.setErr(new PrintStream(bosErr)); // reemplazo de salida		
		
		HolaMundo.main(null);		
		String salida = bos.toString(); // recuperación  del contenido
		assertEquals("Hola mundo\n", salida);
		
		String salidaErr = bosErr.toString(); // recuperación  del contenido
		assertEquals("Y adiós", salidaErr.trim());		
		
		System.setOut(originalOut); // restauración de la consola		
		System.setErr(originalErr); // restauración de la consola		
		
	}	
}

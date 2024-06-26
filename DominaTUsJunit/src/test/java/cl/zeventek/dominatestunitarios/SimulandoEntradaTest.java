package cl.zeventek.dominatestunitarios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class SimulandoEntradaTest {

	@Test
	void test1() {
		InputStream originalIn = System.in;
		ByteArrayInputStream bis = new ByteArrayInputStream("hoy hace sol".getBytes());
		System.setIn(bis);
		
		assertEquals("HOY HACE SOL", gritando());
		
		System.out.println(originalIn);
	}
	@Test
	private static String gritando() {
		try(Scanner s = new Scanner(System.in)){
			String mensaje = s.nextLine();
			return mensaje.toUpperCase();
		}
	}
}

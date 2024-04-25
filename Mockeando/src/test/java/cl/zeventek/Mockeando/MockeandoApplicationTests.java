package cl.zeventek.Mockeando;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MockeandoApplicationTests {
	private Pitagoras pita;
	private SuperCalculadora sc;
	
	
	@BeforeEach
	public void setup() {
		sc = Mockito.mock(SuperCalculadora.class);
		pita = new Pitagoras(sc);
	}
/**
 * este test falla porque no está implementado todavía el metodo raiz de la clase calculadora
 */
/*	
	@Test
	void test1() {
		SuperCalculadora sc = new SuperCalculadora();
		Pitagoras p = new Pitagoras(sc);
		double res = p.hipotenusa(3, 4);
		assertEquals(5, res);
	}
*/
	@Test
	void test1() {
		Mockito.when(sc.raiz(25)).thenReturn(5.0);

		double res = pita.hipotenusa(3, 4);
		assertEquals(5, res);
	}
	@Test
	void test2() {
		Mockito.when(sc.raiz(25)).thenReturn(5.0);

		double res = pita.hipotenusaMal(3, 4);
		assertEquals(5, res);
	}
	
	@Test
	void test3() {
		Mockito.when(sc.raiz(16)).thenReturn(4.0);

		double res = pita.hipotenusaMal(3, 4);
		assertEquals(5, res);
	}
	@Test
	void test5() {
		Mockito.when(sc.raiz(100)).thenReturn(10.0);
		
		double res = pita.hipotenusa(6, 8);
		assertEquals(10, res);
	}
	/**
	 * Error al mockear se establece mal el valor a devolver por el metodo raiz
	 */
	@Test
	void test6() {
		Mockito.when(sc.raiz(100)).thenReturn(100.0);
		
		double res = pita.hipotenusa(6, 8);
		assertEquals(10, res);
	}	
}

package cl.zeventek.Mockeando;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MockeandoApplicationTests {

	@Test
	void test1() {
		SuperCalculadora sc = new SuperCalculadora();
		Pitagoras p = new Pitagoras(sc);
		double res = p.hipotenusa(3, 4);
		assertEquals(5, res);
	}

}

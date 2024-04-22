package cl.zeventek.dominatestunitarios;

public class Fail {
	public static double raiz(double num) throws IllegalAccessException {
		if (num < 0) {
			throw new IllegalAccessException("Num debe ser positivo");
		}
		return Math.sqrt(num);
	}

}

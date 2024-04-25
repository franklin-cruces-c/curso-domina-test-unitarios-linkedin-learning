package cl.zeventek.dominatestunitarios;

public class Complejidad {
	public static int cuentas(int num) {
		int res = 0;
		if (num % 2 == 0) { // es par devolvemos el mismo numero
			res = num;
		} else if (num % 3 == 0 || num % 5 == 0) {// es multiplo de tres o de cinco devolvemos el cuadrado
			res = num * num;
		} else { // si no le cambiamos el signo
			res = -num;
		}
		return res;
	}
}

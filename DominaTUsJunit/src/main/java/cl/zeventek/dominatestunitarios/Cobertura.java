package cl.zeventek.dominatestunitarios;

public class Cobertura {
	public static int cuentas(int num) {
		if (num % 2 == 0) { // es par devolvemos el mismo numero
			return num;
		} else if (num % 3 == 0) {// es multiplo de tres devolvemos el cuadrado
			return num * num;
		} else { // si no le cambiamos el signo
			return -num;
		}
	}

}

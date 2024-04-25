package cl.zeventek.Mockeando;

public class Pitagoras {
	private SuperCalculadora sc;
	
	public Pitagoras(SuperCalculadora sc) {
		this.sc=sc;
	}
	
	public double hipotenusa(int cateto1, int cateto2) {
		return sc.raiz(cateto1 * cateto1 + cateto2 * cateto2);
	}
	public double hipotenusaMal(int cateto1, int cateto2) {
		return sc.raiz(cateto2 * cateto2);
	}

}

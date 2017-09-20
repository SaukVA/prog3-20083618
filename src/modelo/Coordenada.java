package modelo;

public class Coordenada {
	private int x;
	private int y;
	private static int NUMERO_COORDENADA;
	
	public Coordenada(int x, int y) {
		this.x=x;
		this.y=y;
		NUMERO_COORDENADA++;
	}
	
	public Coordenada(Coordenada otra) {
		x=otra.x;
		y=otra.y;
	}
	
	public int getNumeroCoordenada() {
		return NUMERO_COORDENADA;
	}
	
	public String toString() {
		return "Coordenada [x=" + x + ", y=" + y + "]";
	}

	public int getX() {return x;}

	public int getY() {return y;}
	
	/*el baile del sambito
	 * a todos nos gusta
	 */
	
	
}

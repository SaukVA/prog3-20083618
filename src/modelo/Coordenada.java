package modelo;

/**
 * En esta practica se pretende que se comprenda el leguage Java
 * con la traduccion de un esquema de UML a lenguaje Java.
 * 
 * Los metodos de los que consta este objeto son: constructor,
 * geters de las variables(x,y,NUMERO_COORDENADA), un metodo 
 * que se encarga de traducir a String  las variables de 
 * las coordenada(toString()), otro metodo encargado de 
 * la suma de dos  Coordenadas (suma()) y por ultimo el metodo 
 * equals() encatgado de comprobar si las dos coordenadas son iguales.
 * 
 * @author Saul Verdu Aparicio DNI:20083618-H
 **/

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
	
	public static int getNumeroCoordenadas(){
		return NUMERO_COORDENADA;
	}
	
	public String toString() {
		return "(" + x + "," + y + ")";
	}

	public int getX() {return x;}

	public int getY() {return y;}
	
	public Coordenada suma(Coordenada otra) {
		Coordenada ret= new Coordenada(otra.x+x,otra.y+y);
		return ret;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordenada other = (Coordenada) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
}

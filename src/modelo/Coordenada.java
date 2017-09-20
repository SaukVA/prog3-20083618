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
		return "Coordenada [x=" + x + ", y=" + y + "]";
	}

	public int getX() {return x;}

	public int getY() {return y;}
	
	public Coordenada suma(Coordenada otra) {
		Coordenada ret= new Coordenada(otra.x+x,otra.y+y);
		return ret;
	}
	
	public boolean equals(Object otro) {
		if(otro instanceof Coordenada) {
			Coordenada other =(Coordenada) otro;
			return (x==other.x)&& (y==other.y);
		}
		else {return false;}
	}
	
}

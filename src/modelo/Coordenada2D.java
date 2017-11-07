package modelo;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;

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

public class Coordenada2D extends Coordenada {
	private int x;
	private int y;

	/**Constructor de la Coordenada el cual  coge x e y los inicializa
	 * 
	 * @param x 
	 * @param y
	 * @throws ExcepcionCoordenadaIncorrecta 
	 */
	public Coordenada2D(int x, int y) throws ExcepcionCoordenadaIncorrecta {
		if(x>=0 &&y>=0) {	
			this.x=x;
			this.y=y;
		}
		else {
			throw new ExcepcionCoordenadaIncorrecta ();
		}
	}
	
	public Coordenada2D(Coordenada2D otra) {
		if(otra!=null) {
			x=otra.x;
			y=otra.y;
		}
		else {
			throw new  ExcepcionArgumentosIncorrectos();
		}
	}
	
	/**
	 * devuelve la Coordenada en formato de String
	 */
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	
	/** @return la X de a Coordenada
	 */
	public int getX() {return x;}

	/** @return la Y de a Coordenada
	*/
	public int getY() {return y;}
	
	/**Funcion que suma dos coordenadas para obtener una nueva
	 * 
	 * @param otra Es la Coordenada que se va a sumar con la que realiza la funcion
	 * @return Suma de ambas coordenadas 
	 * @throws ExcepcionCoordenadaIncorrecta 
	 */
	
	public Coordenada2D suma (Coordenada otra) throws ExcepcionCoordenadaIncorrecta{
		if(otra!=null) {
			Coordenada2D res = new Coordenada2D(((Coordenada2D)otra).getX()+x,((Coordenada2D)otra).getY()+y);
			return res;
		}
		else
			throw new ExcepcionArgumentosIncorrectos();
		
	}

	
	/**
	 * La funcion ashCode sirve para dar le un codigo unico a cada objeto
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	
	/**
	 * Sirve para comprobar que las dos coordenadas son iguales
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordenada2D other = (Coordenada2D) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	
}

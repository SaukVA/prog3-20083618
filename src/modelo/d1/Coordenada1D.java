/**
 * @author Saul Verdu Aparicio DNI:20083618-H
 */
package modelo.d1;

import modelo.Coordenada;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;

/**
 * The Class Coordenada1D.
 */
public class Coordenada1D extends Coordenada{
	
	/** The x. */
	private int x;
	
	/**
	 * Instantiates a new coordenada 1 D.
	 *
	 * @param x the x
	 * @throws ExcepcionCoordenada1DIncorrecta the excepcion coordenada 1 D incorrecta
	 */
	public Coordenada1D(int x) throws ExcepcionCoordenada1DIncorrecta {
		if(x>=0)
			this.x=x;
		else
			throw new ExcepcionCoordenada1DIncorrecta(x);
	}
	
	/**
	 * Instantiates a new coordenada 1 D.
	 *
	 * @param otra the otra
	 * @throws ExcepcionArgumentosIncorrectos the excepcion argumentos incorrectos
	 */
	public Coordenada1D(Coordenada1D otra) throws ExcepcionArgumentosIncorrectos {
		if(otra!=null)
			x=otra.getX();
		else
			throw new ExcepcionArgumentosIncorrectos();
	}
	
	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public int getX() {return x;}

	/**
	 * devuelve la Coordenada en formato de String.
	 *
	 * @return the string
	 */
	public String toString() {
		return "(" + x + ")";
	}

	/**
	 * La funcion ashCode sirve para dar le un codigo unico a cada objeto.
	 *
	 * @return the int
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		return result;
	}

	/**
	 * Sirve para comprobar que las dos coordenadas son iguales.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordenada1D other = (Coordenada1D) obj;
		if (x != other.x)
			return false;
		return true;
	}

	/**
	 * Funcion que suma dos coordenadas para obtener una nueva.
	 *
	 * @param otra Es la Coordenada que se va a sumar con la que realiza la funcion
	 * @return Suma de ambas coordenadas
	 * @throws ExcepcionCoordenada1DIncorrecta the excepcion coordenada 1 D incorrecta
	 */
	public Coordenada1D suma(Coordenada otra) throws ExcepcionCoordenada1DIncorrecta{
		if(otra!=null) {
			Coordenada1D res=new Coordenada1D (x+((Coordenada1D) otra).getX());
			return res;
		}
		else
			throw new ExcepcionArgumentosIncorrectos();
		
	}
	
}

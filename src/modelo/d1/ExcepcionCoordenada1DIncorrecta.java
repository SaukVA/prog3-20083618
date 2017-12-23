/**
 * @author Saul Verdu Aparicio DNI:20083618-H
 */
package modelo.d1;

import modelo.excepciones.ExcepcionCoordenadaIncorrecta;

/**
 * The Class ExcepcionCoordenada1DIncorrecta.
 */
public class ExcepcionCoordenada1DIncorrecta extends ExcepcionCoordenadaIncorrecta {
	
	/** The x. */
	private int x;
	
	/**
	 * Instantiates a new excepcion coordenada 1 D incorrecta.
	 *
	 * @param x the x
	 */
	public ExcepcionCoordenada1DIncorrecta(int x) {
		this.x=x;
	}
	
	/**
	 * Get The Menssage.
	 *
	 * @return the Menssage
	 */
	public String getMessage() {
		return "Coordenada 1D Incorrecta";
	} 
	
	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public int getX() {return x;}
}

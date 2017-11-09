/**
 * @author Saul Verdu Aparicio DNI:20083618-H
 */
package modelo;

import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
/**
 * The Class Coordenada.
 */
public abstract class Coordenada {

	/**
	 * Instantiates a new coordenada.
	 */
	public Coordenada() {
		
	}
	
	/**
	 * Suma.
	 *
	 * @param otra the otra
	 * @return the coordenada
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 */
	public abstract Coordenada suma(Coordenada otra) throws ExcepcionCoordenadaIncorrecta;

}

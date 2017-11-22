/**
 * @author Saul Verdu Aparicio DNI:20083618-H
 */
package modelo;

import modelo.excepciones.ExcepcionCoordenadaIncorrecta;

public abstract class Tablero2D extends Tablero{ 

	/**
	 * Instantiates a new tablero 2 D.
	 *
	 * @param ancho the ancho
	 * @param alto the alto
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 */
	public Tablero2D(int ancho, int alto) throws ExcepcionCoordenadaIncorrecta {
        super(new Coordenada2D(ancho, alto));
	}
}
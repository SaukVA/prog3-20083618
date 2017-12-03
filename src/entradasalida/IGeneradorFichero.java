/**
 * @author Saul Verdu Aparicio DNI:20083618-H
 */
package entradasalida;

import java.io.File;

import entradasalida.excepciones.ExcepcionGeneracion;
import modelo.Juego;

/**
 * The Interface IGeneradorFichero.
 */
public interface IGeneradorFichero {
	
	/**
	 * Genera fichero.
	 *
	 * @param file the file
	 * @param juego the juego
	 * @param iteraciones the iteraciones
	 * @throws ExcepcionGeneracion the excepcion generacion
	 */
	public void generaFichero(File file, Juego juego, int iteraciones) throws ExcepcionGeneracion;
}
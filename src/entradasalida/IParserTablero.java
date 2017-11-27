/**
 * @author Saul Verdu Aparicio DNI:20083618-H
 */
package entradasalida;

import entradasalida.excepciones.ExcepcionLectura;
import modelo.Tablero;

/**
 * The Interface ParserTableros.
 */
public interface IParserTablero {

	/**
	 * Lee tablero.
	 *
	 * @param cadena the cadena
	 * @return the tablero
	 * @throws ExcepcionLectura the excepcion lectura
	 */
	public Tablero leeTablero(String cadena)throws ExcepcionLectura;
}

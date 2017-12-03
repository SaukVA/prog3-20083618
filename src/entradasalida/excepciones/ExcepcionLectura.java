/**
 * @author Saul Verdu Aparicio DNI:20083618-H
 */
package entradasalida.excepciones;

/**
 * The Class ExcepcionLectura.
 */
public class ExcepcionLectura extends Exception {

	/**
	 * Instantiates a new excepcion lectura.
	 */
	public ExcepcionLectura() {super();}
	
	/**
	 * Instantiates a new excepcion lectura.
	 *
	 * @param s the s
	 */
	public ExcepcionLectura(String s) {super(s);}
	
	/**
	 * Instantiates a new excepcion lectura.
	 *
	 * @param a the a
	 */
	public ExcepcionLectura(Throwable a) {super(a);}
}

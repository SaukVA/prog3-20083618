/**
 * @author Saul Verdu Aparicio DNI:20083618-H
 */
package modelo.excepciones;

/**
 * The Class ExcepcionEjecucion.
 */
public class ExcepcionEjecucion extends RuntimeException {

	
	/**
	 * Instantiates a new excepcion ejecucion.
	 *
	 * @param mensaje the mensaje
	 */
	public ExcepcionEjecucion(String mensaje) {
		super(mensaje);
	}
	
	/**
	 * Instantiates a new excepcion ejecucion.
	 *
	 * @param causa the causa
	 */
	public ExcepcionEjecucion(Throwable causa) {
		super(causa);
	}
}

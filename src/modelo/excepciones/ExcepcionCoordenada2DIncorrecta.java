/**
 * @author Saul Verdu Aparicio DNI:20083618-H
 */
package modelo.excepciones;

/**
 * The Class ExcepcionCoordenada2DIncorrecta.
 */
public class ExcepcionCoordenada2DIncorrecta extends ExcepcionCoordenadaIncorrecta {
	
	/** The x. */
	private int x;
	
	/** The y. */
	private int y;
	
	/**
	 * Instantiates a new excepcion coordenada 2 D incorrecta.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public ExcepcionCoordenada2DIncorrecta(int x, int y) {
		super();
		this.x=x;
		this.y=y;
	}
	
	/**
	 * Get The Menssage
	 *
	 * @return the Menssage
	 */
	public String getMessage() {
		return"Coordenada 2D Incorrecta";
	}
	
	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public int getX() {return x;}
	
	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	public int getY() {return y;}

}

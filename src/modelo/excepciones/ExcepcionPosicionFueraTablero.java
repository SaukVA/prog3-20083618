/**
 * @author Saul Verdu Aparicio DNI:20083618-H
 */
package modelo.excepciones;

import modelo.Coordenada;

/**
 * The Class ExcepcionPosicionFueraTablero.
 */
public class ExcepcionPosicionFueraTablero extends Exception {
	
	/** The dimensiones. */
	private Coordenada dimensiones;
	
	/** The coordenada. */
	private Coordenada coordenada;
	
	/**
	 * Instantiates a new excepcion posicion fuera tablero.
	 *
	 * @param dimensiones the dimensiones
	 * @param coordenada the coordenada
	 */
	public ExcepcionPosicionFueraTablero(Coordenada dimensiones,Coordenada coordenada) {
		this.dimensiones=dimensiones;
		this.coordenada=coordenada;
	}
	
	/**
	 * Gets the Message.
	 *
	 * @return the Message
	 */
	public String getMessage(){
		return"Posicion Fuera del Tabero";
	}
	
	/**
	 * Gets the dimensiones.
	 *
	 * @return the dimensiones
	 */
	public Coordenada getDimensiones() {return dimensiones;}
	
	/**
	 * Gets the coordenada.
	 *
	 * @return the coordenada
	 */
	public Coordenada getCoordenada() {return coordenada;}
}

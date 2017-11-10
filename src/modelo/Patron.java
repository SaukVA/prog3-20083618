/**
 * @author Saul Verdu Aparicio DNI:20083618-H
 */
package modelo;

import java.util.Collection;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionPosicionFueraTablero;


/**
 * The Class Patron.
 */
public class Patron {
	
	/** The nombre. */
	private String nombre;
	
	/** The tablero. */
	private Tablero tablero;

	/**
	 * Instantiates a new patron.
	 *
	 * @param nombre the nombre
	 * @param tablero the tablero
	 */
	public Patron(String nombre, Tablero tablero){
		if(nombre!=null && tablero!=null) {
			this.nombre=nombre;
			this.tablero=tablero;
		}
		else{
			throw new ExcepcionArgumentosIncorrectos();
		}
	}

	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * Gets the celda.
	 *
	 * @param posicion the posicion
	 * @return the celda
	 * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
	 */
	public EstadoCelda getCelda(Coordenada posicion) throws ExcepcionPosicionFueraTablero{
		if(posicion!=null) {
			return tablero.getCelda(posicion);
		}
		else {
			throw new ExcepcionArgumentosIncorrectos();
		}
	}

	/**
	 * Gets the posiciones.
	 *
	 * @return the posiciones
	 */
	public Collection <Coordenada> getPosiciones(){
		return tablero.getPosiciones();
	}

	/**
	 * devuelve el Patron en formato de String.
	 *
	 * @return the string
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(nombre);
		sb.append("\n");
		sb.append(tablero.toString());
		return sb.toString();
	}
}

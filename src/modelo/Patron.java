/**
 * @author Saul Verdu Aparicio DNI:20083618-H
 */
package modelo;

import java.util.Collection;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionPosicionFueraTablero;


// TODO: Auto-generated Javadoc
/**
 * The Class Patron.
 *
 * @param <TipoCoordenada> the generic type
 */
public class Patron <TipoCoordenada extends Coordenada>{
	
	/** The nombre. */
	private String nombre;
	
	/** The tablero. */
	private Tablero<TipoCoordenada> tablero;

	/**
	 * Instantiates a new patron.
	 *
	 * @param nombre the nombre
	 * @param tablero the tablero
	 */
	public Patron(String nombre, Tablero<TipoCoordenada> tablero){
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
	public EstadoCelda getCelda(TipoCoordenada posicion) throws ExcepcionPosicionFueraTablero{
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
	public Collection <TipoCoordenada> getPosiciones(){
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

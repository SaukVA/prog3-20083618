/**
 * @author Saul Verdu Aparicio DNI:20083618-H
 */
package modelo;

import modelo.excepciones.ExcepcionPosicionFueraTablero;

/**
 * The Class Regla.
 */
public abstract class Regla <TipoCoordenada extends Coordenada>{
	
	/**
	 * Instantiates a new regla.
	 */
	public Regla () {}
	
	/**
	 * Calcula siguiente estado celda.
	 *
	 * @param tablero the tablero
	 * @param posicion the posicion
	 * @return the estado celda
	 * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
	 */
	public abstract EstadoCelda calculaSiguienteEstadoCelda(Tablero<TipoCoordenada> tablero, TipoCoordenada posicion) throws ExcepcionPosicionFueraTablero;
}

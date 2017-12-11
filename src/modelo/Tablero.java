/**
 * @author Saul Verdu Aparicio DNI:20083618-H
 */
package modelo;

import static modelo.EstadoCelda.*;
import modelo.Coordenada;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

import java.util.Set;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * The Class Tablero.
 *
 * @param <TipoCoordenada> the generic type
 */
public abstract class Tablero <TipoCoordenada extends Coordenada>{
	
	/** The dimensiones. */
	protected TipoCoordenada dimensiones;
	
	/** The celdas. */
	protected HashMap<TipoCoordenada,EstadoCelda> celdas = new HashMap<TipoCoordenada,EstadoCelda>();
	
	/**
	 * Instantiates a new tablero.
	 *
	 * @param dimensiones the dimensiones
	 */
	protected Tablero(TipoCoordenada dimensiones) {
		
		if (dimensiones==null) {throw new 	ExcepcionArgumentosIncorrectos();}
		
		this.dimensiones=dimensiones;

	}
	
	/**
	 * Gets the dimensiones.
	 *
	 * @return the dimensiones
	 */
	public TipoCoordenada getDimensiones() {
		return dimensiones;
	}
	
	/**
	 * Gets the posiciones.
	 *
	 * @return the posiciones
	 */
	public Collection <TipoCoordenada> getPosiciones(){
		Set<TipoCoordenada> resp = celdas.keySet();
		return resp;
	}

	/**
	 * Gets the celda.
	 *
	 * @param posicion the posicion
	 * @return the celda
	 * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
	 */
	public EstadoCelda getCelda(TipoCoordenada posicion) throws ExcepcionPosicionFueraTablero {
		if(posicion!=null) {
			if(celdas.containsKey(posicion)) {
				return celdas.get(posicion);  
			}
			else {
				throw new ExcepcionPosicionFueraTablero(dimensiones, posicion);
			}
		}
		else {
			throw new ExcepcionArgumentosIncorrectos ();
		}
	}
	
	/**
	 * Sets the celda.
	 *
	 * @param posicion the posicion
	 * @param e the e
	 * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
	 */
	public void setCelda(TipoCoordenada posicion, EstadoCelda e) throws ExcepcionPosicionFueraTablero {
		if(celdas.containsKey(posicion)) {
			celdas.put(posicion,e);  
		}
		else {
			if(posicion==null) {
				throw new ExcepcionArgumentosIncorrectos (); 
			}
			else {
				throw new ExcepcionPosicionFueraTablero(dimensiones, posicion);
			}
		}
	}

	/**
	 * Gets the posiciones vecinas CCW.
	 *
	 * @param posicion the posicion
	 * @return the posiciones vecinas CCW
	 * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
	 * @throws ExcepcionEjecucion the excepcion ejecucion
	 */
	public abstract ArrayList<TipoCoordenada> getPosicionesVecinasCCW(TipoCoordenada posicion) throws ExcepcionPosicionFueraTablero, ExcepcionEjecucion;

	
	/**
	 * Carga patron.
	 *
	 * @param patron the patron
	 * @param coordenadaInicial the coordenada inicial
	 * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
	 */
	public void cargaPatron(Patron<TipoCoordenada> patron, TipoCoordenada coordenadaInicial) throws ExcepcionPosicionFueraTablero {
		
		try {
		if(coordenadaInicial!=null && patron!= null) {
			Collection <TipoCoordenada> c =patron.getPosiciones();
			for( TipoCoordenada coor : c) {
				TipoCoordenada suma= (TipoCoordenada) coordenadaInicial.suma(coor);
				if(!this.celdas.containsKey(suma)) {
					throw new ExcepcionPosicionFueraTablero(dimensiones, suma);
				}
			}
			
			for(TipoCoordenada coor: c) {
					EstadoCelda e = patron.getCelda(coor);
					TipoCoordenada suma2 = (TipoCoordenada) coordenadaInicial.suma(coor);
					celdas.put(suma2, e);
				
			}
		}
		else {
			throw new ExcepcionArgumentosIncorrectos ();
		}
	}
		catch (ExcepcionCoordenadaIncorrecta e) {
			throw new ExcepcionEjecucion(e);
		}
	}

	/**
	 * Contiene.
	 *
	 * @param posicion the posicion
	 * @return true, if successful
	 */
	public boolean contiene(TipoCoordenada posicion) {
		if(posicion!=null) {
			return celdas.containsKey(posicion);
		}
		else {
			throw new ExcepcionArgumentosIncorrectos ();
		}
	}

}

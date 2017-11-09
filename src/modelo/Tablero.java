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
 */
public abstract class Tablero {
	
	/** The dimensiones. */
	protected Coordenada dimensiones;
	
	/** The celdas. */
	protected HashMap<Coordenada,EstadoCelda> celdas = new HashMap<Coordenada,EstadoCelda>();
	
	/**
	 * Instantiates a new tablero.
	 *
	 * @param dimensiones the dimensiones
	 */
	protected Tablero(Coordenada dimensiones) {
		
		if (dimensiones==null) {throw new 	ExcepcionArgumentosIncorrectos();}
		
		this.dimensiones=dimensiones;

	}
	
	/**
	 * Gets the dimensiones.
	 *
	 * @return the dimensiones
	 */
	public Coordenada getDimensiones() {
		return dimensiones;
	}
	
	/**
	 * Gets the posiciones.
	 *
	 * @return the posiciones
	 */
	public Collection <Coordenada> getPosiciones(){
		Set<Coordenada> resp = celdas.keySet();
		return resp;
	}

	/**
	 * Gets the celda.
	 *
	 * @param posicion the posicion
	 * @return the celda
	 * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
	 */
	public EstadoCelda getCelda(Coordenada posicion) throws ExcepcionPosicionFueraTablero {
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
	public void setCelda(Coordenada posicion, EstadoCelda e) throws ExcepcionPosicionFueraTablero {
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
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
	 * @throws ExcepcionEjecucion the excepcion ejecucion
	 */
	public abstract ArrayList<Coordenada> getPosicionesVecinasCCW(Coordenada posicion) throws ExcepcionCoordenadaIncorrecta, ExcepcionPosicionFueraTablero, ExcepcionEjecucion;

	/**
	 * Carga patron.
	 *
	 * @param patron the patron
	 * @param coordenadaInicial the coordenada inicial
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
	 */
	public void cargaPatron(Patron patron, Coordenada coordenadaInicial) throws ExcepcionCoordenadaIncorrecta, ExcepcionPosicionFueraTablero {
		 
		if(coordenadaInicial!=null) {
			Collection <Coordenada> c = patron.getPosiciones();
			for( Coordenada coor : c) {
				Coordenada suma=coordenadaInicial.suma(coor);
				if(!this.celdas.containsKey(suma)) {
					throw new ExcepcionPosicionFueraTablero(dimensiones, coor);
				}
			}
			
			for(Coordenada coor: c) {
				try {
					EstadoCelda e = patron.getCelda(coor);
					Coordenada suma2 = coordenadaInicial.suma(coor);
					celdas.put(suma2, e);
				}
				catch (ExcepcionCoordenadaIncorrecta e) {
					throw new ExcepcionEjecucion(e);
				}
			}
		}
		else {
			throw new ExcepcionArgumentosIncorrectos ();
		}
	}

	/**
	 * Contiene.
	 *
	 * @param posicion the posicion
	 * @return true, if successful
	 */
	public boolean contiene(Coordenada posicion) {
		if(posicion!=null) {
			return celdas.containsKey(posicion);
		}
		else {
			throw new ExcepcionArgumentosIncorrectos ();
		}
	}

}

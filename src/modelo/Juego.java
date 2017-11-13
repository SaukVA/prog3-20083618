/**
 * @author Saul Verdu Aparicio DNI:20083618-H
 */
package modelo;


import java.util.ArrayList;
import java.util.Collection;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;


/**
 * The Class Juego.
 */
public class Juego {
	
	/** The regla. */
	private Regla regla;
	
	/** The tablero. */
	private Tablero tablero;
	
	/** The patrones usados. */
	private ArrayList <Patron> patronesUsados = new ArrayList<Patron>();
	
	/**
	 * Instantiates a new juego.
	 *
	 * @param tablero the tablero
	 * @param regla the regla
	 */
	public Juego(Tablero tablero, Regla regla) {
		if(tablero==null || regla==null) {
			throw new ExcepcionArgumentosIncorrectos();
		}
		this.tablero=tablero;
		this.regla=regla;
	}
	
	/**
	 * Carga patron.
	 *
	 * @param p the p
	 * @param posicionInicial the posicion inicial
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
	 */
	public void cargaPatron(Patron p, Coordenada posicionInicial) throws ExcepcionCoordenadaIncorrecta, ExcepcionPosicionFueraTablero {
		if(posicionInicial==null) {throw new ExcepcionArgumentosIncorrectos();}	
		tablero.cargaPatron(p,posicionInicial);
		patronesUsados.add(p);
	}
	

	/**
	 * Actualiza.
	 *
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
	 */
	public void actualiza() {
		try {
			Collection <Coordenada> c = tablero.getPosiciones();
			ArrayList <EstadoCelda> estado = new ArrayList<EstadoCelda>();
			int i=0;
			for(Coordenada coor : c) {
				estado.add(regla.calculaSiguienteEstadoCelda(tablero, coor));
			}
			for(Coordenada coor : c) {
				tablero.setCelda(coor, estado.get(i));
				i++;
			}
		}
		catch(ExcepcionPosicionFueraTablero e) {
			throw new ExcepcionEjecucion(e);
		}
	
	}
	

	/**
	 * Gets the tablero.
	 *
	 * @return the tablero
	 */
	public Tablero getTablero() {return this.tablero;}

	/**
	 * Gets the patrones.
	 *
	 * @return the patrones
	 */
	public ArrayList<Patron> getPatrones(){return patronesUsados;}
}

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

// TODO: Auto-generated Javadoc
/**
 * The Class Juego.
 *
 * @param <TipoCoordenada> the generic type
 */
public class Juego <TipoCoordenada extends Coordenada>{
	
	/** The regla. */
	private Regla<TipoCoordenada>  regla;
	
	/** The tablero. */
	private Tablero<TipoCoordenada> tablero;
	
	/** The patrones usados. */
	private ArrayList <Patron<TipoCoordenada> > patronesUsados = new ArrayList<Patron<TipoCoordenada> >();
	
	
	/**
	 * Instantiates a new juego.
	 *
	 * @param tablero the tablero
	 * @param regla the regla
	 */
	public Juego(Tablero<TipoCoordenada> tablero, Regla<TipoCoordenada>  regla) {
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
	 * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
	 */
	public void cargaPatron(Patron<TipoCoordenada>  p, TipoCoordenada posicionInicial) throws  ExcepcionPosicionFueraTablero {
		if(posicionInicial==null) {throw new ExcepcionArgumentosIncorrectos();}	
		tablero.cargaPatron(p,posicionInicial);
		patronesUsados.add(p);
	}
	

	/**
	 * Actualiza.
	 */
	public void actualiza() {
		try {
			Collection <TipoCoordenada> c = tablero.getPosiciones();
			ArrayList <EstadoCelda> estado = new ArrayList<EstadoCelda>();
			int i=0;
			for(TipoCoordenada coor : c) {
				estado.add(regla.calculaSiguienteEstadoCelda(tablero, coor));
			}
			for(TipoCoordenada coor : c) {
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
	public Tablero<TipoCoordenada> getTablero() {return this.tablero;}

	/**
	 * Gets the patrones.
	 *
	 * @return the patrones
	 */
	public ArrayList<Patron<TipoCoordenada> > getPatrones(){return patronesUsados;}
}

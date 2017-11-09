package modelo;


import java.util.ArrayList;
import java.util.Collection;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

public class Juego {
	
	private Regla regla;
	private Tablero tablero;
	private ArrayList <Patron> patronesUsados = new ArrayList<Patron>();
	
	public Juego(Tablero tablero, Regla regla) {
		if(tablero==null || regla==null) {
			throw new ExcepcionArgumentosIncorrectos();
		}
		this.tablero=tablero;
		this.regla=regla;
	}
	
	public void cargaPatron(Patron p, Coordenada posicionInicial) throws ExcepcionCoordenadaIncorrecta, ExcepcionPosicionFueraTablero {
		if(posicionInicial==null) {throw new ExcepcionArgumentosIncorrectos();}	
		tablero.cargaPatron(p,posicionInicial);
		patronesUsados.add(p);
	}
	

	public void actualiza() throws ExcepcionCoordenadaIncorrecta, ExcepcionPosicionFueraTablero {
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
	

	public Tablero getTablero() {return this.tablero;}

	public ArrayList<Patron> getPatrones(){return patronesUsados;}
}

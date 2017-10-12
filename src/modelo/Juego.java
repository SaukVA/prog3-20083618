package modelo;

import java.util.ArrayList;
import java.util.Collection;

public class Juego {
	
	private ReglaConway regla;
	private Tablero tablero;
	private ArrayList <Patron> patronesUsados = new ArrayList<Patron>();
	
	public Juego(Tablero tablero, ReglaConway regla) {
		this.tablero=tablero;
		this.regla=regla;
	}
	
	public void cargaPatron(Patron p, Coordenada posicionInicial) {
		if(tablero.cargaPatron(p,posicionInicial)) {
			patronesUsados.add(p);
		}
		else {
			System.out.println("Error cargando plantilla " + p.getNombre() + " en "+posicionInicial.toString()+"\n");
		}
	}
	
	public void actualiza() {
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
	
	public Tablero getTablero() {return this.tablero;}
	
	public ArrayList<Patron> getPatrones(){return patronesUsados;}
}

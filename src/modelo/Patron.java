package modelo;

import java.util.Collection;

public class Patron {
	
	private String nombre;
	private Tablero tablero;
	
	public Patron(String nombre, Tablero tablero) {
		this.nombre=nombre;
		this.tablero=tablero;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public EstadoCelda getCeldas(Coordenada posicion){
		return tablero.getCelda(posicion);
	}
	
	public Collection <Coordenada> getPosiciones(){
		return tablero.getPosiciones();
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(nombre);
		sb.append("\n");
		sb.append(tablero.toString());
		return sb.toString();
	}
}

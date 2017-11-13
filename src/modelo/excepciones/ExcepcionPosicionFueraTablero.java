package modelo.excepciones;

import modelo.Coordenada;

public class ExcepcionPosicionFueraTablero extends Exception {
	
	private Coordenada dimensiones;
	private Coordenada coordenada;
	
	public ExcepcionPosicionFueraTablero(Coordenada dimensiones,Coordenada coordenada) {
		this.dimensiones=dimensiones;
		this.coordenada=coordenada;
	}
	
	//Reparar.
	public String getMessage(){
		return"Posicion Fuera del Tabero";
	}
	
	public Coordenada getDimensiones() {return dimensiones;}
	
	public Coordenada getCoordenada() {return coordenada;}
}

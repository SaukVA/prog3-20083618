package modelo;

import static modelo.EstadoCelda.*;
import modelo.Coordenada; 
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;


public class Tablero {
	private static final int Max=1;
	private List<Coordenada> dimensiones = new ArrayList<Coordenada>();
	private HashMap<Coordenada,EstadoCelda> celdas;
	
	public Tablero(Coordenada dimensiones) {
		
		int j=0;
		
		if(this.dimensiones.size()<=Max) {
			this.dimensiones.add(new Coordenada(dimensiones));
			for(int i=0; i<dimensiones.getX();i++) {
				for(j=0;j<dimensiones.getY();j++) {
					this.celdas.put(new Coordenada(i,j),MUERTA);
				}
				j=0;
			}
		}
	}

	public Coordenada getDimensiones() {
		return dimensiones.get(1);
	}
	
	public Collection <Coordenada> getPosiciones(){
		Set<Coordenada> resp = celdas.keySet();
		return resp;
	}
	
	public void muestraErrorPosicionInvalida(Coordenada c) {
		System.out.printf("Error: La celda "+ c.toString() +" no existe");
	}
	
	public EstadoCelda getCelda(Coordenada posicion) {
		if(celdas.containsKey(new Coordenada(posicion))) {
			return celdas.get(new Coordenada(posicion));  
		}
		else {
			return null;
		}
	}
	
	public void setCelda(Coordenada posicion, EstadoCelda e) {
		if(celdas.containsKey(new Coordenada(posicion))) {
			celdas.put(new Coordenada(posicion),e);  
		}
	}
	
	public ArrayList<Coordenada> getPosicionesVecinasCCW(Coordenada posicion) {
		
		ArrayList<Coordenada> resp =new ArrayList<Coordenada>();
		
		for(int i=0; i<=7;i++) {
			switch(i) {
				case 0: 
					resp.add(new Coordenada(posicion.getX()-1,posicion.getY()-1));
					break;
				case 1: 
					resp.add(new Coordenada(posicion.getX()-1,posicion.getY()));
					break;
				case 2: 
					resp.add(new Coordenada(posicion.getX()-1,posicion.getY()+1));
					break;
				case 3: 
					resp.add(new Coordenada(posicion.getX(),posicion.getY()+1));
					break;
				case 4: 
					resp.add(new Coordenada(posicion.getX()+1,posicion.getY()+1));
					break;
				case 5: 
					resp.add(new Coordenada(posicion.getX()+1,posicion.getY()));
					break;
				case 6: 
					resp.add(new Coordenada(posicion.getX()+1,posicion.getY()-1));
					break;
				case 7: 
					resp.add(new Coordenada(posicion.getX(),posicion.getY()-1));
					break;
			}
		}
		return resp;
	}
	
	//boolean cargaPatron(Patron patron, Coordenada coordenadaInicial) {}
	
	boolean contiene(Coordenada posicion) {
		return celdas.containsKey(posicion);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		return null;
	}
}

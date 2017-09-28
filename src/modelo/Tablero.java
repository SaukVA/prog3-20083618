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
	
	void ArrayList<Coordenada> getPosicionesVecinasCCW(Coordenada posicion){
		
		ArrayList<Coordenada> c = new ArrayList<Coordenada> ();
		int x = posicion.getX();
		
		for()
	}
}

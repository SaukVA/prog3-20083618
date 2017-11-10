package mains;

import modelo.Coordenada2D;
import modelo.TableroCeldasCuadradas;
import modelo.EstadoCelda;
import modelo.Juego;
import modelo.ReglaConway;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

public class MainPruebas {

	public static void main(String[] args) throws ExcepcionCoordenadaIncorrecta, ExcepcionPosicionFueraTablero {

			
			TableroCeldasCuadradas t1 = new TableroCeldasCuadradas(5,5);
			ReglaConway r =new ReglaConway();
			Coordenada2D c = new Coordenada2D(0,1);
			Coordenada2D c2 = new Coordenada2D(0,2);
			Coordenada2D c3 = new Coordenada2D(0,3);
			Coordenada2D c4 = new Coordenada2D(0,0);
			
			System.out.println("Hola");
			System.out.println(t1.toString());
			
			t1.setCelda(c,EstadoCelda.VIVA);
			t1.setCelda(c2,EstadoCelda.VIVA);
			t1.setCelda(c3,EstadoCelda.VIVA);
			t1.setCelda(c4,EstadoCelda.VIVA);
			
			Juego juego = new Juego(t1, r);
			
			System.out.println(t1.toString());
			
			juego.actualiza();
			System.out.println(t1.toString());
			
			t1.setCelda(c,EstadoCelda.MUERTA);
			t1.setCelda(c2,EstadoCelda.MUERTA);
			System.out.println(t1.toString());
			
			juego.actualiza();
			System.out.println(t1.toString());
			
			
	}
}

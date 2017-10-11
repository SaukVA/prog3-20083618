package mains;


import modelo.Tablero;
import modelo.Coordenada;
import modelo.EstadoCelda;


public class MainPrueba {

	public static void main(String[] args) {
		
		Tablero tableroPatron = new Tablero(new Coordenada(3,3));
		tableroPatron.setCelda(new Coordenada(0,0), EstadoCelda.MUERTA);
		tableroPatron.setCelda(new Coordenada(1,0), EstadoCelda.VIVA);
		tableroPatron.setCelda(new Coordenada(2,0), EstadoCelda.MUERTA);
		tableroPatron.setCelda(new Coordenada(0,1), EstadoCelda.MUERTA);
		tableroPatron.setCelda(new Coordenada(1,1), EstadoCelda.MUERTA);
		tableroPatron.setCelda(new Coordenada(2,1), EstadoCelda.VIVA);
		tableroPatron.setCelda(new Coordenada(0,2), EstadoCelda.VIVA);
		tableroPatron.setCelda(new Coordenada(1,2), EstadoCelda.VIVA);
		tableroPatron.setCelda(new Coordenada(2,2), EstadoCelda.VIVA);

		
		System.out.print(tableroPatron.toString());
	}
}

package mains;

import modelo.Coordenada2D;
import modelo.TableroCeldasCuadradas;
import modelo.EstadoCelda;
import modelo.Juego;
import modelo.ReglaConway;
import modelo.Tablero1D;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionPosicionFueraTablero;
import entradasalida.excepciones.ExcepcionLectura;
import entradasalida.textoplano.*;

public class MainPruebas {

	public static void main(String[] args) throws ExcepcionCoordenadaIncorrecta, ExcepcionPosicionFueraTablero, ExcepcionLectura {

			ParserTablero1D p= new ParserTablero1D ();
			String s= new String("** **");
			Tablero1D t= (Tablero1D) p.leeTablero(s);
			System.out.println(t.toString());
	}
}

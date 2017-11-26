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

			ParserTablero2D p= new ParserTablero2D ();
			String s= new String("*****\n** **\n*****");
			TableroCeldasCuadradas t= (TableroCeldasCuadradas) p.leeTablero(s);
			System.out.println(t.toString());
	}
}

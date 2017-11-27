package mains;

import modelo.Coordenada2D;
import modelo.TableroCeldasCuadradas;
import modelo.EstadoCelda;
import modelo.Juego;
import modelo.ReglaConway;
import modelo.Tablero;
import modelo.Tablero1D;
import modelo.Tablero2D;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionPosicionFueraTablero;
import entradasalida.ParserTableros;
import entradasalida.excepciones.ExcepcionLectura;
import entradasalida.textoplano.*;

public class MainPruebas {

	public static void main(String[] args) throws ExcepcionCoordenadaIncorrecta, ExcepcionPosicionFueraTablero, ExcepcionLectura {

			String s= new String("** **");
			String s2= new String("**\n *");
			ParserTableros p= new ParserTableros();
			Tablero t= p.leeTablero(s);
			Tablero t2= p.leeTablero(s2);
			System.out.println(t.toString());
			System.out.println(t2.toString());
	}
}

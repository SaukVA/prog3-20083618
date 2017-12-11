package mains;

import modelo.d1.Tablero1D;
import modelo.d2.Coordenada2D;
import modelo.d2.ReglaConway;
import modelo.d2.Tablero2D;
import modelo.d2.TableroCeldasCuadradas;
import modelo.EstadoCelda;
import modelo.Juego;
import modelo.Tablero;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

import entradasalida.ParserTableros;
import entradasalida.excepciones.ExcepcionLectura;
import entradasalida.txt.*;

public class MainPruebas {

	public static void main(String[] args) throws ExcepcionLectura{

			String s= new String("** **");
			String s2= new String("**\n *");
			ParserTableros p= new ParserTableros();
			Tablero t= p.leeTablero(s);
			Tablero t2= p.leeTablero(s2);
			System.out.println(t.toString());
			System.out.println(t2.toString());
	}
}

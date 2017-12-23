package mains;

import java.io.File;

import modelo.Coordenada;
import modelo.Juego;
import modelo.Patron;
import modelo.Regla;
import modelo.Tablero;
import modelo.d1.Coordenada1D;
import modelo.d2.Coordenada2D;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionPosicionFueraTablero;
import entradasalida.Factory;
import entradasalida.IGeneradorFichero;
import entradasalida.ParserTableros;
import entradasalida.excepciones.ExcepcionGeneracion;
import entradasalida.excepciones.ExcepcionLectura;

/**
 * The Class Main4.
 */
public class Main4 {
	
	/**
	 * Run.
	 *
	 * @param dimensiones the dimensiones
	 * @param posicionCargaPatron the posicion carga patron
	 * @param cadena the cadena
	 * @param fichero the fichero
	 * @param iteraciones the iteraciones
	 * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
	 * @throws ExcepcionGeneracion the excepcion generacion
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 * @throws ExcepcionLectura the excepcion lectura
	 */
	void run(Coordenada dimensiones, Coordenada posicionCargaPatron, String cadena, String fichero, int iteraciones) throws ExcepcionPosicionFueraTablero, ExcepcionGeneracion, ExcepcionCoordenadaIncorrecta, ExcepcionLectura {
		Tablero tablero = Factory.creaTablero(dimensiones);
		Regla regla = Factory.creaRegla(tablero);		
		Tablero tableroPatron = ParserTableros.leeTablero(cadena);
		Patron p = new Patron("Entrada", tableroPatron);
		
		Juego juego = new Juego(tablero, regla);
		juego.cargaPatron(p, posicionCargaPatron);
		IGeneradorFichero generador = Factory.creaGeneradorFichero(tablero, FileUtils.getFileExtension(fichero));
		generador.generaFichero(new File(fichero), juego, iteraciones);		
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String [] args) {
		Main4 objeto = new Main4();
		try {			
			objeto.run(new Coordenada1D(80), new Coordenada1D(40), "*", "p4-1d.txt", 30);
			objeto.run(new Coordenada1D(80), new Coordenada1D(40), "*", "p4-1d.gif", 30);
			objeto.run(new Coordenada2D(10, 5), new Coordenada2D(0, 0), " * \n  *\n***", "p4-2d.txt", 5);
			objeto.run(new Coordenada2D(10, 5), new Coordenada2D(0, 0), " * \n  *\n***", "p4-2d.gif", 5);
		} catch (ExcepcionPosicionFueraTablero | ExcepcionGeneracion
				| ExcepcionCoordenadaIncorrecta | ExcepcionLectura e) {
			e.printStackTrace(); // esto no debe dar nunca
		}
	}
}

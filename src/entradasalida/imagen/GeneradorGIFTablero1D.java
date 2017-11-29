/**
 * @author Saul Verdu Aparicio DNI:20083618-H
 */
package entradasalida.imagen;

import java.io.File;

import entradasalida.IGeneradorFichero;
import entradasalida.excepciones.ExcepcionGeneracion;
import gifs.ImagenGIF;
import modelo.Juego;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.Coordenada1D;

/**
 * The Class GeneradorGIFTablero1D.
 */
public class GeneradorGIFTablero1D implements IGeneradorFichero{

	/**
	 * Instantiates a new generador GIF tablero 1 D.
	 */
	public GeneradorGIFTablero1D() {}
	
	/**
	 * Genera fichero.
	 *
	 * @param file the file
	 * @param juego the juego
	 * @param iteraciones the iteraciones
	 * @throws ExcepcionGeneracion the excepcion generacion
	 */
	public void generaFichero(File file, Juego juego, int iteraciones) throws ExcepcionGeneracion {
		
		if(file==null || juego==null) {
			throw new ExcepcionArgumentosIncorrectos();
		}
		
		if(iteraciones<=0) {
			throw new ExcepcionGeneracion(new String("Numero de interacciones no valido")); 
		}
		int ancho = ((Coordenada1D) juego.getTablero().getDimensiones()).getX();
		
		ImagenGIF g = new ImagenGIF(ancho,iteraciones);
		
		for(int i=0; i<=iteraciones-1;i++) {
			for(int j=0; j<=ancho-1;j++) {
				g.pintaCuadrado(i, j);
			}
			juego.actualiza();
		}
		
		g.guardaFichero(file);
		
	}

}

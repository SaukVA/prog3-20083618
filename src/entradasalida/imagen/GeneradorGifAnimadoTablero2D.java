package entradasalida.imagen;

import java.io.File;

import entradasalida.IGeneradorFichero;
import entradasalida.excepciones.ExcepcionGeneracion;
import gifs.ImagenGIF;
import gifs.ImagenGIFAnimado;
import modelo.Coordenada2D;
import modelo.EstadoCelda;
import modelo.Juego;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenada2DIncorrecta;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

public class GeneradorGifAnimadoTablero2D implements IGeneradorFichero {

	public GeneradorGifAnimadoTablero2D() {}
	
	public void generaFichero(File file, Juego juego, int iteraciones) throws ExcepcionGeneracion {
		
		try {
			if(file==null || juego==null) {
				throw new ExcepcionArgumentosIncorrectos();
			}
			if(iteraciones<=0) {
				throw new ExcepcionGeneracion(new String("Numero de interacciones no valido")); 
			}
			
			ImagenGIFAnimado g = new ImagenGIFAnimado(100);
			int ancho = ((Coordenada2D) juego.getTablero().getDimensiones()).getX();
			int alto = ((Coordenada2D) juego.getTablero().getDimensiones()).getY();
			
			for(int i=0; i<=iteraciones-1; i++) {
				ImagenGIF fotograma = new ImagenGIF(ancho,alto);
				for(int x=0; x<=ancho-1;x++) {
					for(int y=0; y<=alto-1;y++) {
						
						if(juego.getTablero().getCelda((new Coordenada2D(x,y)))==EstadoCelda.VIVA) {
							
						}
					}
				}
				g.addFotograma(fotograma);
				juego.actualiza();
			}
			g.guardaFichero(file);
		}
		catch(ExcepcionCoordenada2DIncorrecta e) {
			throw new ExcepcionGeneracion(e);
		}
		catch(ExcepcionPosicionFueraTablero f) {
			throw new ExcepcionGeneracion(f);
		}
	}

}

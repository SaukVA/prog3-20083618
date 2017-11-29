/**
 * @author Saul Verdu Aparicio DNI:20083618-H
 */
package entradasalida.textoplano;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import entradasalida.IGeneradorFichero;
import entradasalida.excepciones.ExcepcionGeneracion;
import modelo.Imprimible;
import modelo.Juego;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;

/**
 * The Class GeneradorFicheroPlano.
 */
public class GeneradorFicheroPlano implements IGeneradorFichero {

	/**
	 * Instantiates a new generador fichero plano.
	 */
	public GeneradorFicheroPlano(){}
	
	/**
	 * Genera fichero.
	 *
	 * @param file the file
	 * @param juego the juego
	 * @param iteraciones the iteraciones
	 * @throws ExcepcionGeneracion the excepcion generacion
	 */
	public void generaFichero(File file, Juego juego, int iteraciones) throws ExcepcionGeneracion {
		try {
			if(file==null || juego==null) {
				throw new ExcepcionArgumentosIncorrectos();
			}
			if(iteraciones<=0) {
				throw new ExcepcionGeneracion(new String("Numero de interacciones no valido")); 
			}
			
			PrintWriter fichero = new PrintWriter(file); 
			
			for(int i=0; i<=iteraciones-1; i++) {
				juego.actualiza();
				fichero.println(((Imprimible) juego.getTablero()).generaCadena());
			}
			
			fichero.close();
		}
		catch( FileNotFoundException e) {
			throw new ExcepcionGeneracion(e);
		}
	}
}

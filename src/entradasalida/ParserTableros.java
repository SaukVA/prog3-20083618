/**
 * @author Saul Verdu Aparicio DNI:20083618-H
 */
package entradasalida;

import entradasalida.excepciones.ExcepcionLectura;
import entradasalida.textoplano.ParserTablero1D;
import entradasalida.textoplano.ParserTablero2D;
import modelo.Tablero;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;

/**
 * The Class ParserTableros.
 */
public class ParserTableros {
	
	/**
	 * Instantiates a new parser tableros.
	 */
	public ParserTableros() {}
	
	/**
	 * Lee tablero.
	 *
	 * @param cadena the cadena
	 * @return the tablero
	 * @throws ExcepcionLectura the excepcion lectura
	 */
	public static Tablero leeTablero(String cadena)throws ExcepcionLectura{
		
		int tamaño = 1;
		
		if(cadena==null || cadena.length()==0) {
			throw new ExcepcionArgumentosIncorrectos();
		}
		
		for(int i=0; i<cadena.length(); i++) {
			if(cadena.charAt(i)=='\n') {
				tamaño=2;
			}
		}
		
		if(tamaño==1) {
			IParserTablero t = new ParserTablero1D();
			return t.leeTablero(cadena);
		}
		else {
			IParserTablero t = new ParserTablero2D();
			return t.leeTablero(cadena);
		}
		
	}

}

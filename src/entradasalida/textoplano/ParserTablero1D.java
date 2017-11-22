/**
 * @author Saul Verdu Aparicio DNI:20083618-H
 */
package entradasalida.textoplano;

import entradasalida.excepciones.ExcepcionLectura;
import modelo.Coordenada1D;
import modelo.Tablero;
import modelo.Tablero1D;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

import static modelo.EstadoCelda.*;


/**
 * The Class ParserTablero1D.
 */
public class ParserTablero1D {
	
	/**
	 * Instantiates a new parser tablero 1 D.
	 */
	public ParserTablero1D() {}
	
	/**
	 * Lee tablero.
	 *
	 * @param cadena the cadena
	 * @return the tablero
	 * @throws ExcepcionLectura the excepcion lectura
	 * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
	 */
	public Tablero leeTablero(String cadena) throws ExcepcionLectura, ExcepcionPosicionFueraTablero{
		
		boolean error=false;
		char c;
		
		try {
			if (cadena==null) {
				throw new ExcepcionArgumentosIncorrectos();
			}
			int tam = cadena.length();
			Tablero1D t = new Tablero1D(tam); 
			
			for(int i=0; i<tam; i++) {
				c=cadena.charAt(i);
				if(c!='*' && c!=' ') {
					error=true;
				}
			}
			
			if(error || tam==0) {
				throw new ExcepcionLectura();
			}
			else {
				for(int j=0; j< tam; j++) {
					c=cadena.charAt(j);
					switch(c) {
						case('*'):
							t.setCelda(new Coordenada1D(j), VIVA);
							break;
						case(' '):
							t.setCelda(new Coordenada1D(j), MUERTA);
							break;
					}
				}
			}
			
			return t;
		}
		catch(ExcepcionCoordenadaIncorrecta e) {
			throw new ExcepcionEjecucion(e);
		}
		
	}

}

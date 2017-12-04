/**
 * @author Saul Verdu Aparicio DNI:20083618-H
 */
package entradasalida.textoplano;

import modelo.Coordenada2D;
import modelo.Tablero;
import modelo.TableroCeldasCuadradas;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

import static modelo.EstadoCelda.*;

import entradasalida.IParserTablero;
import entradasalida.IParserTablero;
import entradasalida.excepciones.ExcepcionLectura;

/**
 * The Class ParserTablero2D.
 */
public class ParserTablero2D implements IParserTablero{

	/**
	 * Instantiates a new parser tablero 2 D.
	 */
	public ParserTablero2D() {}
	
	/**
	 * Lee tablero.
	 *
	 * @param cadena the cadena
	 * @return the tablero
	 * @throws ExcepcionLectura the excepcion lectura
	 */
	public Tablero leeTablero(String cadena) throws ExcepcionLectura{
		
		boolean error=false;
		char c;
		int alto=0, ancho=0;
		int k=0,p=0;
		
		try {
			if (cadena==null) {
				throw new ExcepcionArgumentosIncorrectos();
			}
			
			int tam = cadena.length();
			
			for(int i=0; i<tam; i++) {
				c=cadena.charAt(i);
				if(c!='*' && c!=' ' && c!='\n') {
					error=true;
				}
				if(c=='\n') {alto++;}
				if(alto==0) {ancho++;}
			}
			
			if(cadena.charAt(tam-1)!='\n'&& !error) {alto++;}
			
			TableroCeldasCuadradas t = new TableroCeldasCuadradas(ancho,alto);
			
			if(error || tam==0) {
				throw new ExcepcionLectura(cadena);
			}
			else {
				for(int j=0;j<tam;j++) {
					c=cadena.charAt(j);
					
					if(c!='\n') {
						switch(c) {
							case('*'):
								t.setCelda(new Coordenada2D(k,p), VIVA);
								break;
							case(' '):
								t.setCelda(new Coordenada2D(k,p), MUERTA);
								break;
						}
						k++;
					}
					else {
						k=0;
						p++;
					}
				}
			}
			return t;
		}
		catch(ExcepcionCoordenadaIncorrecta e) {
			throw new ExcepcionEjecucion(e);
		}
		catch(ExcepcionPosicionFueraTablero f) {
			throw new ExcepcionEjecucion(f);
		}
	}
}

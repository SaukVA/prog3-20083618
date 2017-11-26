package entradasalida.textoplano;

import modelo.Coordenada2D;
import modelo.Tablero;
import modelo.TableroCeldasCuadradas;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

import static modelo.EstadoCelda.*;

import entradasalida.excepciones.ExcepcionLectura;

public class ParserTablero2D {

	public ParserTablero2D() {}
	
	public Tablero leeTablero(String cadena) throws ExcepcionLectura, ExcepcionPosicionFueraTablero {
		
		boolean error=false;
		char c;
		int alto=0, ancho=0;
		
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
				throw new ExcepcionLectura();
			}
			else {
				for(int j=0;j<ancho;j++) {
					c=cadena.charAt(j);
					int k=0,p=0;
					
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
	}
}

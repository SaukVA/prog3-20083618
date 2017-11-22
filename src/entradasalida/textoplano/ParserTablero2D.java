package entradasalida.textoplano;

import modelo.Coordenada2D;
import modelo.Tablero;
import modelo.Tablero2D;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import static modelo.EstadoCelda.*;

public class ParserTablero2D {

	public ParserTablero2D() {}
	
	public Tablero leeTablero(String cadena) {
		
		boolean error=false;
		char c;
		
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
			}
			
		}
		catch(ExcepcionCoordenadaIncorrecta e) {
			throw new ExcepcionEjecucion(e);
		}
		return null;
	}
}

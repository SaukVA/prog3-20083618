package entradasalida;

import entradasalida.IGeneradorFichero;
import entradasalida.textoplano.GeneradorFicheroPlano;
import modelo.Tablero;

public class Factory {

	public Factory() {}
	
	public static IGeneradorFichero creaGeneradorFichero(Tablero tablero, String extension) {
		
		if(extension.equals("txt")) {
			return new GeneradorFicheroPlano();
		}
	}
	
}

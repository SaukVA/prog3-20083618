package modelo;

import modelo.excepciones.ExcepcionCoordenadaIncorrecta;

public class Tablero1D extends Tablero {

	protected Tablero1D(int x) throws ExcepcionCoordenadaIncorrecta{
		super(new Coordenada1D(x));
	}
	
}

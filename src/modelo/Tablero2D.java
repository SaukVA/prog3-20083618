package modelo;

import modelo.excepciones.ExcepcionCoordenadaIncorrecta;

public class Tablero2D extends Tablero{

	public Tablero2D(int ancho, int alto) throws ExcepcionCoordenadaIncorrecta {
        super(new Coordenada2D(ancho, alto));
	}
}

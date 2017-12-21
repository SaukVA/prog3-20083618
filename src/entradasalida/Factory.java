/**
 * @author Saul Verdu Aparicio DNI:20083618-H
 */
package entradasalida;

import entradasalida.IGeneradorFichero;
import entradasalida.excepciones.ExcepcionGeneracion;
import entradasalida.gif.GeneradorTableroCoordenada1D;
import entradasalida.gif.GeneradorTableroCoordenada2D;
import entradasalida.txt.GeneradorFicheroPlano;
import modelo.Coordenada;
import modelo.Regla;
import modelo.Tablero;
import modelo.d1.Coordenada1D;
import modelo.d1.Regla30;
import modelo.d1.Tablero1D;
import modelo.d2.Coordenada2D;
import modelo.d2.ReglaConway;
import modelo.d2.TableroCeldasCuadradas;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;

/**
 * The Class Factory.
 */
public class Factory {

	/**
	 * Instantiates a new factory.
	 */
	public Factory() {}
	
	/**
	 * Crea generador fichero.
	 *
	 * @param tablero the tablero
	 * @param extension the extension
	 * @return the i generador fichero
	 * @throws ExcepcionGeneracion the excepcion generacion
	 */
	public static IGeneradorFichero creaGeneradorFichero(Tablero tablero, String extension) throws ExcepcionGeneracion {
		
		/*if(tablero==null || extension==null) {
			throw new ExcepcionArgumentosIncorrectos();
		}
		
		if(extension.equals("txt") || extension.equals("gif")) {
			switch(extension) {
				case "txt":
					return new GeneradorFicheroPlano();
				default:
					if(tablero instanceof Tablero1D) {
						return new GeneradorTableroCoordenada1D();
					}
					else {
						return new GeneradorTableroCoordenada2D();
					}
			}
		}
		
		else {
			throw new ExcepcionGeneracion("La Extension "+ extension +" no es valida");
		}*/
		String nombreDeLaClase = "entradasalida."+ extension + ".GeneradorTablero" + tablero.getDimensiones().getClass().getSimpleName();
		
		try {
			Class<?> c = Class.forName(nombreDeLaClase);
			return (IGeneradorFichero) c.newInstance(); 
			
		} 
		catch (ClassNotFoundException e) {
			throw new ExcepcionGeneracion(nombreDeLaClase);
		}
		catch(InstantiationException | IllegalAccessException f) {
			throw new ExcepcionGeneracion();
		}
	}
	
	/**
	 * Crea tablero.
	 *
	 * @param dimensiones the dimensiones
	 * @return the tablero
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 */
	public static Tablero creaTablero(Coordenada dimensiones) throws ExcepcionCoordenadaIncorrecta {
		if(dimensiones instanceof Coordenada1D||dimensiones instanceof Coordenada2D) {
			if(dimensiones instanceof Coordenada1D) {
				Coordenada1D c = (Coordenada1D) dimensiones;
				return new Tablero1D(c.getX());
			}
			else {
				Coordenada2D c = (Coordenada2D) dimensiones;
				return new TableroCeldasCuadradas(c.getX(),c.getY());
			}
		}
		
		else {
			throw new ExcepcionEjecucion("La Coordenada no es correcta");
		}
	}
	
	
	/**
	 * Crea regla.
	 *
	 * @param tablero the tablero
	 * @return the regla
	 */
	public  static Regla creaRegla(Tablero tablero) {
		if(tablero instanceof Tablero1D) {
			return new Regla30();
		}
		else {
			return new ReglaConway();
		}
		
	}
	
}

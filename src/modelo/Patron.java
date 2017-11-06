package modelo;

/**En esta clase podemos guardar unos ciertos taberos como 
 * patrones para su posterior uso en un nuevo tablero. 
 * 
 * @author Saul Verdu Aparicio
 */

import java.util.Collection;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

public class Patron {
	
	private String nombre;
	private Tablero tablero;
	
	/**Constructor de la Clase Patron, se encarga de inicializar
	 * los valores del objeto con los introducidos por parametros
	 * 
	 * @param nombre Nombre que se le asigna a el patron para identificar lo
	 * @param tablero Forma que tiene el tablero del patron
	 */
	public Patron(String nombre, Tablero tablero){
		if(nombre!=null && tablero!=null) {
			this.nombre=nombre;
			this.tablero=tablero;
		}
		else{
			throw new ExcepcionArgumentosIncorrectos();
		}
	}
	
	/**Devuelve el nombre del patron
	 * 
	 * @return Nombre del patron en forma de string
	 */
	public String getNombre() {
		return this.nombre;
	}
	
	/**Llamada a la funcion .getCelda() del objeto Tablero
	 * 
	 * @param posicion Coordenada que se le pasa como parametro a la funcion .getCelda()
	 * @return resultados de la funcion
	 * @throws ExcepcionPosicionFueraTablero 
	 */
	public EstadoCelda getCelda(Coordenada posicion) throws ExcepcionPosicionFueraTablero{
		if(posicion!=null) {
			return tablero.getCelda(posicion);
		}
		else {
			throw new ExcepcionArgumentosIncorrectos();
		}
	}
	
	/**Llamada a la funcion .getPosiciones() del objeto Tablero
	 * 
	 * @return Collection de todas las coordenadaass que conforman el HashMap del tablero
	 */
	public Collection <Coordenada> getPosiciones(){
		return tablero.getPosiciones();
	}
	
	/** Tranformacion del Patron en un string el cual se pueda mostrar por consola
	 * 
	 * @return String que se utiliza para mostrar el patron
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(nombre);
		sb.append("\n");
		sb.append(tablero.toString());
		return sb.toString();
	}
}

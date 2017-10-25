package modelo;

/**Clase encargada de que el juego se pueda llevar a cabo.
 * Gracias a la clase Juego se pueden coordinan las demas clase
 * y asi poden realizr el juego de la vida de Conway
 * 
 * @author Saul verdu Aparicio
 */

import java.util.ArrayList;
import java.util.Collection;

public class Juego {
	
	private ReglaConway regla;
	private Tablero tablero;
	private ArrayList <Patron> patronesUsados = new ArrayList<Patron>();
	
	/**Contructor de la clase Juego, encargado de inicializar 
	 * los valores de regla y tablero
	 * 
	 * @param tablero Tablero donde se va a realizar el juego
	 * @param regla La regla que va a sergui el juego 
	 */
	public Juego(Tablero tablero, ReglaConway regla) {
		this.tablero=tablero;
		this.regla=regla;
	}
	
	/** Funcion encargada de cargar un patron dentro de un tablero, a parte 
	 * de esto la funcion emite un mensaje de error si no se puede cargar el 
	 * patron en la posicion indicada
	 * 
	 * @param p Patron a cargar dentro del tablero
	 * @param posicionInicial posicion desde la que se va a copiar el patron
	 */
	public void cargaPatron(Patron p, Coordenada posicionInicial) {
		if(tablero.cargaPatron(p,posicionInicial)) {
			patronesUsados.add(p);
		}
		else {
			System.out.println("Error cargando plantilla " + p.getNombre() + " en "+posicionInicial.toString());
		}
	}
	
	/**Funcion que se encarga de actualizar los estados de las celdas 
	 * 
	 */
	public void actualiza() {
		Collection <Coordenada> c = tablero.getPosiciones();
		ArrayList <EstadoCelda> estado = new ArrayList<EstadoCelda>();
		int i=0;
		for(Coordenada coor : c) {
			estado.add(regla.calculaSiguienteEstadoCelda(tablero, coor));
		}
		for(Coordenada coor : c) {
			tablero.setCelda(coor, estado.get(i));
			i++;
		}
	}
	
	/**Funcion encargada de devolver el tablero en el que se basa el 
	 * 
	 * @return Tablero donde se desarrolla el juego
	 */
	public Tablero getTablero() {return this.tablero;}
	
	/** Funion que nos da los patrones que ya han sido utilizados
	 * 
	 * @return ArrayList de todos los patrones que ya hemos utlizado
	 */
	public ArrayList<Patron> getPatrones(){return patronesUsados;}
}

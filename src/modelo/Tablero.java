package modelo;

/** Esta es la clase en la que se van a basar el resto de cases ya que es donde se van a poder 
 *  guardar los patrones que se hagan y es donde se va  arealizar el juego, a parte de esto
 *  la clase tablero es la unica que nos permite visualizar el tablero del juego.   
 *  @author Saul Verdu Aparicio
 */

import static modelo.EstadoCelda.*;
import modelo.Coordenada;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

//import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;


public class Tablero {
	
	private Coordenada dimensiones;
	private HashMap<Coordenada,EstadoCelda> celdas = new HashMap<Coordenada,EstadoCelda>();
	
	/**Constructor del tablero
	 * 
	 * @param dimensiones El parametro dimensiones nos ayuda a saber 
	 * el tamaño del que se deve contruir el tablero, como el Hashmap que
	 * nos ayuda a saber el estado de cada celda.
	 */
	public Tablero(Coordenada dimensiones) {
		
		this.dimensiones=new Coordenada(dimensiones);
		
		if(dimensiones.getX()>0 && dimensiones.getY()>0) {
			int i=0;
			while(i<this.dimensiones.getX()) {
				int j=0;
				while(j<this.dimensiones.getY()) {
					try {
						celdas.put(new Coordenada(i, j), EstadoCelda.MUERTA);
					} 
					catch (ExcepcionCoordenadaIncorrecta e) {
						throw new ExcepcionEjecucion(e); 
					} 
					j++;
				}
				i++;
			}
		}
	}//Cierre del contructor

	/**Metodo que devuelve el tamaño del tablero en forma de cooordenada
	 * 
	 *  @return Coordenada de la que esta compone el tablero
	 */
	public Coordenada getDimensiones() {
		return dimensiones;
	}
	
	/** Metodo para obtener todas las Claves del HashMap
	 * 
	 * @return Todas las coordenadas del tablero
	 */
	public Collection <Coordenada> getPosiciones(){
		Set<Coordenada> resp = celdas.keySet();
		return resp;
	}
	
	/** Metodo para mostrar que una celda no existe
	 * 
	 * @param c Coordenada de la queremos que queremos sacar el error 
	 */
	public void muestraErrorPosicionInvalida(Coordenada c) {
		System.out.printf("Error: La celda "+ c.toString() +" no existe\n");
	}
	
	/**Metodo para la obtencion del Estado de una Celda
	 * 
	 * @param posicion Celda de la queremos saber su estado
	 * @return El estado de la celda introducida como parametro
	 * @throws ExcepcionPosicionFueraTablero 
	 */
	public EstadoCelda getCelda(Coordenada posicion) throws ExcepcionPosicionFueraTablero {
		if(posicion!=null) {
			if(celdas.containsKey(new Coordenada(posicion))) {
				return celdas.get(new Coordenada(posicion));  
			}
			else {
				throw new ExcepcionPosicionFueraTablero(dimensiones, posicion);
			}
		}
		else {
			throw new ExcepcionArgumentosIncorrectos ();
		}
	}
	
	/** Setter que nos sirve para el cambio del estado de una celda
	 * 
	 * @param posicion celda de la que se quiere cambiar el estado
	 * @param e Estado al que se le cambiar a la celda
	 * @throws ExcepcionPosicionFueraTablero 
	 */
	public void setCelda(Coordenada posicion, EstadoCelda e) throws ExcepcionPosicionFueraTablero {
		if(celdas.containsKey(new Coordenada(posicion))) {
			celdas.put(new Coordenada(posicion),e);  
		}
		else {
			if(posicion==null) {
				throw new ExcepcionArgumentosIncorrectos (); 
			}
			else {
				throw new ExcepcionPosicionFueraTablero(dimensiones, posicion);
			}
		}
	}
	
	/**Nos saca un ArrayList de las posiciones cercanas a la posicion 
	 * introducida como parametro.
	 * 
	 * @param posicion posicion de la queremos saver las vecinas
	 * @return Todas las posiciones vecinas a la dada como parametro
	 * @throws ExcepcionCoordenadaIncorrecta 
	 */
	public ArrayList<Coordenada> getPosicionesVecinasCCW(Coordenada posicion) throws ExcepcionCoordenadaIncorrecta {
		
		ArrayList<Coordenada> resp =new ArrayList<Coordenada>();
		
		if(posicion.getX()>=0 && posicion.getY()>=0 && contiene(posicion)) {
			try {
				for(int i=0; i<=7;i++) {
					switch(i) {
						case 0: 
							if(contiene(new Coordenada(posicion.getX()-1,posicion.getY()-1)))
								resp.add(new Coordenada(posicion.getX()-1,posicion.getY()-1));
							break;
						case 1: 
							if(contiene(new Coordenada(posicion.getX()-1,posicion.getY())))
								resp.add(new Coordenada(posicion.getX()-1,posicion.getY()));
							break;
						case 2: 
							if(contiene(new Coordenada(posicion.getX()-1,posicion.getY()+1)))
								resp.add(new Coordenada(posicion.getX()-1,posicion.getY()+1));
							break;
						case 3: 
							if(contiene(new Coordenada(posicion.getX(),posicion.getY()+1)))
								resp.add(new Coordenada(posicion.getX(),posicion.getY()+1));
							break;
						case 4: 
							if(contiene(new Coordenada(posicion.getX()+1,posicion.getY()+1)))
								resp.add(new Coordenada(posicion.getX()+1,posicion.getY()+1));
							break;
						case 5: 
							if(contiene(new Coordenada(posicion.getX()+1,posicion.getY())))
								resp.add(new Coordenada(posicion.getX()+1,posicion.getY()));
							break;
						case 6:
							if(contiene(new Coordenada(posicion.getX()+1,posicion.getY()-1)))
								resp.add(new Coordenada(posicion.getX()+1,posicion.getY()-1));
							break;
						case 7: 
							if(contiene(new Coordenada(posicion.getX(),posicion.getY()-1)))
								resp.add(new Coordenada(posicion.getX(),posicion.getY()-1));
							break;
					}
				}
			}
			catch(ExcepcionCoordenadaIncorrecta e) {
				throw new ExcepcionEjecucion(e); 
			}
		}
		return resp;
	}
	
	/** Este metodo nos dice si se puede realizar o no la copia de un patron
	 * en el tablero. De n poder hacerse muestra un mensaje de error.
	 * 
	 * @param patron Patron que se quiere copiar en el tablero
	 * @param coordenadaInicial Coordenada desde la que empezara a copiar el patron
	 * @return nos dice si es posible o no copiar el patron dentro del tablero
	 * @throws ExcepcionCoordenadaIncorrecta 
	 * @throws ExcepcionPosicionFueraTablero 
	 */
	public void cargaPatron(Patron patron, Coordenada coordenadaInicial) throws ExcepcionCoordenadaIncorrecta, ExcepcionPosicionFueraTablero {
		 
		if(coordenadaInicial.getX()>=0 && coordenadaInicial.getY()>=0) {
			Collection <Coordenada> c = patron.getPosiciones();
			for( Coordenada coor : c) {
				Coordenada suma=coordenadaInicial.suma(coor);
				if(!this.celdas.containsKey(suma)) {
					throw new ExcepcionPosicionFueraTablero(dimensiones, coor);
				}
			}
			
			for(Coordenada coor: c) {
				try {
					EstadoCelda e = patron.getCelda(coor);
					Coordenada suma2 = coordenadaInicial.suma(coor);
					celdas.put(suma2, e);
				}
				catch (ExcepcionCoordenadaIncorrecta e) {
					throw new ExcepcionEjecucion(e);
				}
			}
		}
		else {
			throw new ExcepcionArgumentosIncorrectos ();
		}
	}
	
	/**Metodo para saber si la celda se encuentra dento de las celdas del tablero
	 * 
	 * @param posicion Posicion de la que se quiere saber si pertenece 
	 * @return Respuesta booleana
	 */
	public boolean contiene(Coordenada posicion) {
		if(posicion!=null) {
			return celdas.containsKey(posicion);
		}
		else {
			throw new ExcepcionArgumentosIncorrectos ();
		}
	}
	
	/**Transforma los valores de las coordenadas y los estados de las celdas 
	 * en un string para que se pueda imprimir por consola
	 * 
	 * @return Devuelve el string del tablero para que pueda ser impreso
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (int i=0;i<=this.dimensiones.getY()+1;i++) {
			for(int j=0;j<=this.dimensiones.getX()+1;j++) {
				
				if(j==0 || j==dimensiones.getX()+1) {
					if(i==0 || i==dimensiones.getY()+1) {sb.append("+");}
					else {sb.append("|");}
				}
				else {
					if(i==0 || i==dimensiones.getY()+1) {sb.append("-");}
					else {
						EstadoCelda es = null;
						try {
							es = celdas.get(new Coordenada(j-1,i-1));
						} catch (ExcepcionCoordenadaIncorrecta e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						switch(es) {
							case VIVA:
								sb.append("*");
								break;
							case MUERTA:
								sb.append(" ");
								break;
						}
					}
				}
				if(j==dimensiones.getX()+1) {sb.append("\n");}
			}
		}
		return sb.toString();
	}
}

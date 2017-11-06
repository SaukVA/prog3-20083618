package modelo;

/**La clase ReglaConway se utiliza para la saber si las celdas 
 * de un tablero cumplen la regla de tener 2 o 3 vecinas vivas
 *  y si su estado es vivo, y la regla de vivir si tiene 3 celdas
 *  vecinas vivas 
 * 
 * @author Saul Verdu Aparicio
 */

import java.util.ArrayList;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

import static modelo.EstadoCelda.*;

public class ReglaConway {

	/**Constructor de la Regla de Conway 
	 */
	public ReglaConway() {}
	
	/**Metodo que realiza la Regla de Conway a la celda de un tablero
	 * 
	 * @param tablero Tablero del cual  se van a estraer las coordenadas vecinas
	 * @param posicion Coordenada de la que se quiere saber el estado para la siguiete actualizacion
	 * @return Devuele el valor del estado de la celda en la proxima ejecucion
	 * @throws ExcepcionCoordenadaIncorrecta 
	 * @throws ExcepcionPosicionFueraTablero 
	 */
	public EstadoCelda calculaSiguienteEstadoCelda(Tablero tablero, Coordenada posicion) throws ExcepcionPosicionFueraTablero, ExcepcionCoordenadaIncorrecta {
		
		if (tablero==null || posicion==null) {
			throw new ExcepcionArgumentosIncorrectos();
		}
		
		EstadoCelda es = MUERTA;
		try {
			ArrayList<Coordenada> Ar = tablero.getPosicionesVecinasCCW(posicion);
			int vivas=0;
			for(int i=0; i<Ar.size();i++) {
				if(tablero.getCelda(Ar.get(i))==VIVA) {
					vivas++;
				}
			}
			
			if(vivas==3 && tablero.getCelda(posicion)==MUERTA) {es=VIVA;}
			if((vivas==3 || vivas==2) && tablero.getCelda(posicion)==VIVA) {es=VIVA;}
		}
		catch(ExcepcionPosicionFueraTablero e) {
			throw new ExcepcionPosicionFueraTablero(tablero.getDimensiones(),posicion);
		}
		
		return es;
	}
}

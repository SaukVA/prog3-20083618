/**
 * @author Saul Verdu Aparicio DNI:20083618-H
 */
package modelo;

import java.util.ArrayList;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

import static modelo.EstadoCelda.*;

/**
 * The Class ReglaConway.
 */
public class ReglaConway extends Regla {

	/**
	 * Instantiates a new regla conway.
	 */
	public ReglaConway() {}

	/**
	 * Calcula siguiente estado celda.
	 *
	 * @param tablero the tablero
	 * @param posicion the posicion
	 * @return the estado celda
	 * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 */
	@Override
	public EstadoCelda calculaSiguienteEstadoCelda(Tablero tablero, Coordenada posicion) throws ExcepcionPosicionFueraTablero {
		
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

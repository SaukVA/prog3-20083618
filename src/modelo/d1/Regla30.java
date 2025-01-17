/**
 * @author Saul Verdu Aparicio DNI:20083618-H
 */
package modelo.d1;

import static modelo.EstadoCelda.MUERTA;
import static modelo.EstadoCelda.VIVA;

import java.util.ArrayList;

import modelo.Coordenada;
import modelo.EstadoCelda;
import modelo.Regla;
import modelo.Tablero;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

/**
 * The Class Regla30.
 */
public class Regla30 extends Regla<Coordenada1D> {

	/**
	 * Instantiates a new regla 30.
	 */
	public Regla30() {}
	
	/**
	 * Calcula siguiente estado celda.
	 *
	 * @param tablero the tablero
	 * @param posicion the posicion
	 * @return the estado celda
	 * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
	 */
	@Override
	public EstadoCelda calculaSiguienteEstadoCelda(Tablero<Coordenada1D> tablero, Coordenada1D posicion)throws ExcepcionPosicionFueraTablero{
		if (tablero==null || posicion==null) {
			throw new ExcepcionArgumentosIncorrectos();
		}
		else {
			EstadoCelda es = MUERTA;
			try {
				ArrayList<Coordenada1D> Ar = tablero.getPosicionesVecinasCCW(posicion);
				EstadoCelda B =tablero.getCelda(posicion);

				if(Ar.size()==2) {
					EstadoCelda A =tablero.getCelda(Ar.get(0));
					EstadoCelda C =tablero.getCelda(Ar.get(1));
					
					switch(A) {
						case VIVA:
							if(B==MUERTA && C==MUERTA) {es=VIVA;}
						break;
						
						case MUERTA:
							if(B==MUERTA && C==MUERTA) {es=MUERTA;}
							else{es=VIVA;}
						break;
						 
					}
				} 
				 
				return es;
			}
			catch(ExcepcionPosicionFueraTablero e) {
				throw new ExcepcionPosicionFueraTablero(tablero.getDimensiones(),posicion);
			}
		}
	}
	
}

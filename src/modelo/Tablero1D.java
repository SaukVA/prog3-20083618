/**
 * @author Saul Verdu Aparicio DNI:20083618-H
 */
package modelo;

import java.util.ArrayList;

import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;
import static modelo.EstadoCelda.*;

/**
 * The Class Tablero1D.
 */
public class Tablero1D extends Tablero {

	/**
	 * Instantiates a new tablero 1 D.
	 *
	 * @param x the x
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 */
	public Tablero1D(int x) throws ExcepcionCoordenadaIncorrecta{
		super(new Coordenada1D(x));
		
		for(int i=0;i<x;i++) {
			try {
				celdas.put(new Coordenada1D(i), EstadoCelda.MUERTA);
			}
			catch(ExcepcionCoordenadaIncorrecta e) {
				throw new ExcepcionEjecucion(e);
			}
		}
	}

	/* (non-Javadoc)
	 * @see modelo.Tablero#getPosicionesVecinasCCW(modelo.Coordenada)
	 */
	@Override
	public ArrayList<Coordenada> getPosicionesVecinasCCW(Coordenada posicion)throws ExcepcionCoordenadaIncorrecta, ExcepcionPosicionFueraTablero {
			
		ArrayList<Coordenada> resp =new ArrayList<Coordenada>();
		
		try {
			if(contiene(posicion)) {	
				if(((Coordenada1D)posicion).getX()+1>=0 && ((Coordenada1D)posicion).getX()+1<((Coordenada1D)dimensiones).getX()) {
					resp.add(new Coordenada1D (((Coordenada1D)posicion).getX()+1));
				}
				
				if(((Coordenada1D)posicion).getX()-1>=0 && ((Coordenada1D)posicion).getX()-1<((Coordenada1D)dimensiones).getX()) {
					resp.add(new Coordenada1D (((Coordenada1D)posicion).getX()-1));
				}
			}
			else {
				throw new ExcepcionPosicionFueraTablero(dimensiones,posicion);
			}
		}
		catch(ExcepcionCoordenadaIncorrecta e) {
			throw new ExcepcionEjecucion(e);
		}
	 return resp;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() throws ExcepcionEjecucion {
		StringBuilder sb = new StringBuilder();
		
		sb.append("|");
		
		try {
			for(int i=0;i<((Coordenada1D)dimensiones).getX();i++) {
				if(celdas.get(new Coordenada1D(i))==MUERTA) {
					sb.append(" ");
				}
				else{
					sb.append("*");
				}
			}
			sb.append("|\n");
		}
		catch(ExcepcionCoordenadaIncorrecta e) {
			throw new ExcepcionEjecucion(e);
		}
		return sb.toString();
	}

}

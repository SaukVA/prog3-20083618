/**
 * @author Saul Verdu Aparicio DNI:20083618-H
 **/
package modelo;

import java.util.ArrayList;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

/**
 * The Class TableroCeldasCuadradas.
 */
public class TableroCeldasCuadradas extends Tablero2D {

	/**
	 * Instantiates a new tablero celdas cuadradas.
	 *
	 * @param ancho the ancho
	 * @param alto the alto
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 */
	public TableroCeldasCuadradas(int ancho, int alto) throws ExcepcionCoordenadaIncorrecta {
		super(ancho, alto);
		
		if(((Coordenada2D)dimensiones).getX()>0 && ((Coordenada2D)dimensiones).getY()>0) {
			int i=0;
			while(i<((Coordenada2D)dimensiones).getX()) {
				int j=0;
				while(j<((Coordenada2D)dimensiones).getY()) {
					try {
						celdas.put(new Coordenada2D(i, j), EstadoCelda.MUERTA);
					} 
					catch (ExcepcionCoordenadaIncorrecta e) {
						throw new ExcepcionEjecucion(e); 
					} 
					j++;
				}
				i++;
			}
		}
	}
	
	/**
	 * devuelve el TableroCEldasCuadradas en formato de String.
	 *
	 * @return the string
	 */
	public String toString() {
			
		try {
			StringBuilder sb = new StringBuilder();
			for (int i=0;i<=((Coordenada2D)dimensiones).getY()+1;i++) {
				for(int j=0;j<=((Coordenada2D)dimensiones).getX()+1;j++) {
					
					if(j==0 || j==((Coordenada2D)dimensiones).getX()+1) {
						if(i==0 || i==((Coordenada2D)dimensiones).getY()+1) {sb.append("+");}
						else {sb.append("|");}
					}
					else {
						if(i==0 || i==((Coordenada2D)dimensiones).getY()+1) {sb.append("-");}
						else {
							EstadoCelda es = celdas.get(new Coordenada2D(j-1,i-1));
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
					if(j==((Coordenada2D)dimensiones).getX()+1) {sb.append("\n");}
				}
			}
			return sb.toString();
		}
		catch(ExcepcionCoordenadaIncorrecta e) {
			throw new ExcepcionEjecucion(e);
		}
	}

	/**
	 * Gets the posiciones vecinas CCW.
	 *
	 * @param posicion the posicion
	 * @return the posiciones vecinas CCW
	 * @throws ExcepcionCoordenadaIncorrecta the excepcion coordenada incorrecta
	 * @throws ExcepcionPosicionFueraTablero the excepcion posicion fuera tablero
	 * @throws ExcepcionEjecucion the excepcion ejecucion
	 */
	@Override
	public ArrayList<Coordenada> getPosicionesVecinasCCW(Coordenada posicion) throws ExcepcionCoordenadaIncorrecta, ExcepcionPosicionFueraTablero,ExcepcionPosicionFueraTablero {
		
		ArrayList<Coordenada> resp =new ArrayList<Coordenada>();
		if(posicion==null) {
			throw new ExcepcionArgumentosIncorrectos ();
		}
		
		if(contiene(posicion)) {
			try {
				int maxX=((Coordenada2D)dimensiones).getX();
				int maxY=((Coordenada2D)dimensiones).getY();
				int X=((Coordenada2D)posicion).getX();
				int Y=((Coordenada2D)posicion).getY();
				for(int i=0; i<=7;i++) {
					switch(i) {
						case 0: 
							if(X-1>=0 && Y-1>=0 && X-1< maxX && Y-1< maxY)
								resp.add(new Coordenada2D(X-1,Y-1));
							break;
						case 1: 
							if(X-1>=0 && Y>=0 && X-1< maxX && Y< maxY)
								resp.add(new Coordenada2D(X-1,Y));
							break;
						case 2: 
							if(X-1>=0 && Y+1>=0 && X-1< maxX && Y+1< maxY)
								resp.add(new Coordenada2D(X-1,Y+1));
							break;
						case 3: 
							if(X>=0 && Y+1>=0 && X< maxX && Y+1< maxY)
								resp.add(new Coordenada2D(X,Y+1));
							break;
						case 4: 
							if(X+1>=0 && Y+1>=0 && X+1< maxX && Y+1< maxY)
								resp.add(new Coordenada2D(X+1,Y+1));
							break;
						case 5: 
							if(X+1>=0 && Y>=0 && X+1< maxX && Y< maxY)
								resp.add(new Coordenada2D(X+1,Y));
							break;
						case 6:
							if(X+1>=0 && Y-1>=0 && X+1< maxX && Y-1< maxY)
								resp.add(new Coordenada2D(X+1,Y-1));
							break;
						case 7: 
							if(X>=0 && Y-1>=0 && X< maxX && Y-1< maxY)
								resp.add(new Coordenada2D(X,Y-1));
							break;
					}
				}
			}
			catch(ExcepcionArgumentosIncorrectos e) {
				throw new ExcepcionEjecucion(e);
			}
		}
		else {
			throw new ExcepcionPosicionFueraTablero(dimensiones,posicion);
		}
		return resp;
	}
}

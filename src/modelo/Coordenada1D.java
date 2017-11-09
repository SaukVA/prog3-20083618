/**
 * @author Saul Verdu Aparicio DNI:20083618-H
 */
package modelo;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenada1DIncorrecta;


/**
 * The Class Coordenada1D.
 */
public class Coordenada1D extends Coordenada{
	
	/** The x. */
	private int x;
	
	/**
	 * Instantiates a new coordenada 1 D.
	 *
	 * @param x the x
	 * @throws ExcepcionCoordenada1DIncorrecta the excepcion coordenada 1 D incorrecta
	 */
	public Coordenada1D(int x) throws ExcepcionCoordenada1DIncorrecta {
		if(x>=0)
			this.x=x;
		else
			throw new ExcepcionCoordenada1DIncorrecta(x);
	}
	
	/**
	 * Instantiates a new coordenada 1 D.
	 *
	 * @param otra the otra
	 * @throws ExcepcionCoordenada1DIncorrecta the excepcion coordenada 1 D incorrecta
	 */
	public Coordenada1D(Coordenada1D otra) throws ExcepcionCoordenada1DIncorrecta {
		if(otra.x>0)
			x=otra.x;
		else
			throw new ExcepcionCoordenada1DIncorrecta(x);
	}
	
	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public int getX() {return x;}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "(" + x + ")";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordenada1D other = (Coordenada1D) obj;
		if (x != other.x)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see modelo.Coordenada#suma(modelo.Coordenada)
	 */
	@Override
	public Coordenada1D suma(Coordenada otra) throws ExcepcionCoordenada1DIncorrecta{
		if(otra!=null) {
			Coordenada1D res=new Coordenada1D (x+((Coordenada1D) otra).getX());
			return res;
		}
		else
			throw new ExcepcionArgumentosIncorrectos();
		
	}
	
}

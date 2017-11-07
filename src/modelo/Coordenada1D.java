package modelo;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenada1DIncorrecta;

public class Coordenada1D extends Coordenada{
	private int x;
	
	public Coordenada1D(int x) throws ExcepcionCoordenada1DIncorrecta {
		if(x>=0)
			this.x=x;
		else
			throw new ExcepcionCoordenada1DIncorrecta(x);
	}
	
	public Coordenada1D(Coordenada1D otra) throws ExcepcionCoordenada1DIncorrecta {
		if(otra.x>0)
			x=otra.x;
		else
			throw new ExcepcionCoordenada1DIncorrecta(x);
	}
	
	public int getX() {return x;}

	public String toString() {
		return "(" + x + ")";
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		return result;
	}

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

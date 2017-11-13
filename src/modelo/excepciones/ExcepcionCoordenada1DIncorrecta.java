package modelo.excepciones;

public class ExcepcionCoordenada1DIncorrecta extends ExcepcionCoordenadaIncorrecta {
	
	private int x;
	
	public ExcepcionCoordenada1DIncorrecta(int x) {
		this.x=x;
	}
	
	//Reparar.
	public String getMessage() {
		return "Coordenada 1D Incorrecta";
	} 
	
	public int getX() {return x;}
}

package modelo.excepciones;

public class ExcepcionCoordenada1DIncorrecta extends ExcepcionCoordenadaIncorrecta {
	
	private int x;
	
	public ExcepcionCoordenada1DIncorrecta(int x) {
		super();
		this.x=x;
	}
	
	//Reparar.
	public String getMensage() {
		return "Coordenada 1D Incorrecta";
	} 
	
	public int getX() {return x;}
}

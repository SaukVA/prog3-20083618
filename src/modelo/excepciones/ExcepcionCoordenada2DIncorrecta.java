package modelo.excepciones;

public class ExcepcionCoordenada2DIncorrecta extends ExcepcionCoordenadaIncorrecta {
	
	private int x;
	private int y;
	
	public ExcepcionCoordenada2DIncorrecta(int x, int y) {
		super();
		this.x=x;
		this.y=y;
	}
	
	public String getMensaje() {
		return"Coordenada 2D Incorrecta";
	}
	
	public int getX() {return x;}
	
	public int getY() {return y;}

}

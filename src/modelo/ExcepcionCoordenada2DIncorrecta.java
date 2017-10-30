package modelo;

public class ExcepcionCoordenada2DIncorrecta extends ExcepcionCoordenadaIncorrecta {
	
	private int x;
	private int y;
	
	public ExcepcionCoordenada2DIncorrecta(int x, int y) {
		super();
		this.x=x;
		this.y=y;
	}
	
	public String getMensaje() {
		return"Hola";
	}
	
	public int getX() {return x;}
	
	public int getY() {return y;}

}

package modelo;

public class ExcepcionCoordenada1DIncorrecta extends Exception {
	private int x;
	
	public ExcepcionCoordenada1DIncorrecta() {
		
	}
	//public String getMensage() {} 
	
	public int getX() {return x;}
}

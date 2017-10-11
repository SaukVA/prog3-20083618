package modelo;

public class Juego {
	
	private ReglaConway regla;
	private Tablero tablero;
	//private List....(patron)
	
	public Juego(Tablero tablero, ReglaConway regla) {
		this.tablero=tablero;
		this.regla=regla;
	}
	
	void cargaPatron(Patron p, Coordenada posicionInicial) {}
}

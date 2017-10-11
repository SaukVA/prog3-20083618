package mains;


import modelo.Tablero;
import modelo.Coordenada;


public class MainPrueba {

	public static void main(String[] args) {
		Tablero c1 = new Tablero(new Coordenada(3,3));
		
		System.out.print(c1.toString());
	}
}

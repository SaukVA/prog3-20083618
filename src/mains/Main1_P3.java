package mains;

import java.util.ArrayList;

import modelo.Coordenada;
import modelo.d1.Coordenada1D;
import modelo.d2.Coordenada2D;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;

/**
@author drizo
 **/
public class Main1_P3 {

	/**
	 * Clase principal de la P1
	 * @param args
	 * @throws ExcepcionCoordenadaIncorrecta 
	 */
	public static void main(String[] args)  {
		try {
			Coordenada c0; // no se instancia porque no se ha hecho new
			Coordenada c1 = new Coordenada1D(0);
			Coordenada c2 = new Coordenada1D(10);
			Coordenada c3 = new Coordenada1D(4);
			Coordenada c4 = new Coordenada1D(5);
			//Coordenada c5 = new Coordenada2D(c4);
			Coordenada c6 = new Coordenada1D(25);
			System.out.println(c1.toString());
			System.out.println();
			
			System.out.println(c2.toString());
			System.out.println();
	
			System.out.println(c3.toString());
			System.out.println();
			
			System.out.println(c4.toString());
			System.out.println();
	
			//System.out.println(c5.toString());
			System.out.println();
			
			Coordenada sumada = c3.suma(c6);
			System.out.println("Suma de " + c3.toString() + "+" + c6.toString() + "= " + sumada.toString());
			System.out.println();
			
			Coordenada2D [] v = new Coordenada2D[5];
			for (int i=0; i<5; i++) {
				v[i] = new Coordenada2D(i,4-i);
			}
			
			for (int i=0; i<5; i++) {
				System.out.println(v[i].getX() + ", " + v[i].getY());
			}
	
			ArrayList<Coordenada> v2 = new ArrayList<Coordenada>();
			for (int i=0; i<8; i++) {
				v2.add(new Coordenada1D(i));
				System.out.println(v2.get(i).toString());
			}
			
			Coordenada c7 = c1.suma(c3);
			if (c7.equals(c3)) {
				System.out.println("c7 y c3 son iguales");
			}
			
			// System.out.println("Num.total de coordenadas: " + Coordenada.getNumeroCoordenadas());
		} catch (Exception e) {
			e.printStackTrace(); // NO DEBE SALTAR NUNCA, EL UNICO ERROR YA SE HA CAPTURADO
		}
		
	}

}
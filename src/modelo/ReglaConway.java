package modelo;

import java.util.ArrayList;
import static modelo.EstadoCelda.*;

public class ReglaConway {


	public ReglaConway() {}
	
	public EstadoCelda calculaSiguienteEstadoCelda(Tablero tablero, Coordenada posicion) {
		
		EstadoCelda es = MUERTA;
		ArrayList<Coordenada> Ar = tablero.getPosicionesVecinasCCW(posicion);
		int vivas=0;
		for(int i=0; i<=Ar.size();i++) {
			if(tablero.getCelda(Ar.get(i))==VIVA) {
				vivas++;
			}
		}
		
		if(vivas==2 || vivas==3) {es=VIVA;}
		
		return es;
	}
}

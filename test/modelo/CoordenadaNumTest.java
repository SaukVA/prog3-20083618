package modelo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import modelo.Coordenada;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;

/**
@author jgonzalo
 **/
public class CoordenadaNumTest {
	Coordenada2D c;
	
	@Before
	public void setUp() throws Exception {
		c = new Coordenada2D(3, 5);
				
	}

	
	@Test
	public final void testNumCoordenada() throws ExcepcionCoordenadaIncorrecta {
		Coordenada2D c3 = new Coordenada2D(100,25);
		Coordenada2D c2 = new Coordenada2D(c);
		assertEquals("c.suma(c7)","(103,30)",c.suma(c3).toString());
		//assertEquals("Num. Coords. ", 4, Coordenada.getNumeroCoordenadas());
	}
	

}

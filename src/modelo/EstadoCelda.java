package modelo;

public class EstadoCelda {
	  public static EstadoCelda MUERTA = new EstadoCelda(1);
	  public static EstadoCelda VIVA = new EstadoCelda(2);

	  private int valor;
	  private EstadoCelda(int a) { valor = a; }
}

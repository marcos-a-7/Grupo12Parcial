package modelo;

public class DecoradorCelular extends DecoradorServicio {
	
	private static int generadorNum = 5000000;
	private int numeroCelular;
	
	
	
	
	public DecoradorCelular() {
		this.numeroCelular = generadorNum++;
	}



	public double getCosto() {
		return 300;
	}
	
	

	@Override
	public String detalle() {
		return super.detalle() + " Linea Movil +54-9-223-"+ this.getNumeroCelular() + this.getCosto();
	}



	private int getNumeroCelular() {
		return this.numeroCelular;
	}

	
	
}

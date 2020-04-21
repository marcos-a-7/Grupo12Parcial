package modelo;

public class DecoradorCelular extends DecoradorServicio {

	public DecoradorCelular(IServicio servicioEncapsulado) {
		super(servicioEncapsulado);
		this.numeroCelular = generadorNum++;
	}

	private static int generadorNum = 5000000;
	private int numeroCelular;

	public double getCosto() {
		return 300;
	}

	@Override
	public String detalle() {
		return super.detalle() + " Linea Movil +54-9-223-" + this.getNumeroCelular() + " " + this.getCosto() + "\n";
	}

	public int getNumeroCelular() {
		return this.numeroCelular;
	}

}

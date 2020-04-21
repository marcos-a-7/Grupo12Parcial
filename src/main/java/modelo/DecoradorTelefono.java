package modelo;

public class DecoradorTelefono extends DecoradorServicio {

	public DecoradorTelefono(IServicio servicioEncapsulado) {
		super(servicioEncapsulado);
		this.numeroTelefono = generadorNum++;
	}

	private static int generadorNum = 4000000;
	private int numeroTelefono;

	public double getCosto() {
		return 200;
	}

	@Override
	public String detalle() {
		return super.detalle() + " Linea Fija +54-9-223-" + this.getNumeroTelefono() + " " + this.getCosto() + "\n";
	}

	public int getNumeroTelefono() {
		return this.numeroTelefono;
	}

}

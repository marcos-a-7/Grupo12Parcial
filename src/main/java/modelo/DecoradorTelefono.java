package modelo;

public class DecoradorTelefono extends DecoradorServicio {

	private static int generadorNum = 4000000;
	private int numeroTelefono;

	public DecoradorTelefono() {
		this.numeroTelefono = generadorNum++;
	}

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

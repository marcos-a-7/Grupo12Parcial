package modelo;

public class Telefono implements IServicio{
	
	public Telefono() {
		this.numeroTelefono = generadorNum++;
	}

	private static int generadorNum = 4000000;
	private int numeroTelefono;

	public double getCosto() {
		return 200;
	}

	public String detalle() {
		return "Linea Fija +54-9-223-" + this.getNumeroTelefono() + " $" + this.getCosto() + "\n";
	}

	public int getNumeroTelefono() {
		return this.numeroTelefono;
	}
}

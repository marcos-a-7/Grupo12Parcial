package servicios;

import java.io.Serializable;

/**
 * @author grupo12<br>
 *         <b>El servicio telefono Genera un numero, devuelve costo y un detalle
 *         del mismo</b>
 */
public class Telefono implements IServicio, Cloneable, Serializable {
	private static int generadorNum = 4000000;
	private int numeroTelefono;

	public Telefono() {
		this.numeroTelefono = generadorNum++;
	}
	
	public double getCosto() {
		return 200;
	}

	public String detalle() {
		return "Linea Fija +54-9-223-" + this.getNumeroTelefono() + " $" + this.getCosto() + "\n";
	}

	public int getNumeroTelefono() {
		return this.numeroTelefono;
	}

	@Override
	public String toString() {
		return "Telefono [numero=" + numeroTelefono + "]";
	}
	
}

package servicios;

import java.io.Serializable;

/**
 * @author grupo12 <br>
 *         <b>El servicio celular Genera un numero, devuelve costo y un detalle
 *         del mismo</b>
 */
public class Celular implements IServicio, Cloneable, Serializable {

	private static int generadorNum = 5000000;
	private int numeroCelular;

	public Celular() {
		this.numeroCelular = generadorNum++;
	}

	public double getCosto() {
		return 300;
	}

	public String detalle() {
		return "Linea Movil +54-9-223-" + this.getNumeroCelular() + " $" + this.getCosto() + "\n";
	}

	public int getNumeroCelular() {
		return this.numeroCelular;
	}
	@Override
	protected Celular clone() throws CloneNotSupportedException {
		return (Celular) super.clone();
	}

	@Override
	public String toString() {
		return "Celular [numero=" + numeroCelular + "]";
	}
	
}

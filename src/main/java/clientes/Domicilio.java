package clientes;

/**
 * @author Grupo12<br>
 *         <b>se guarda la calle y el numero, implementa la interfase cloneable
 *         y el metodo clone, sobreescribe el metodo tostring el cual devuelve
 *         los datos del domicilio</b>
 */
public class Domicilio implements Cloneable {
	private String calle;
	private int numero;

	public Domicilio(String calle, int numero) {
		this.calle = calle;
		this.numero = numero;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Domicilio: " + this.calle + " " + this.numero;
	}

	@Override
	public Domicilio clone() throws CloneNotSupportedException {
		return (Domicilio) super.clone();
	}
}

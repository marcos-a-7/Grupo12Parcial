package clientes;

/**
 * @author Grupo12 La clase abstracta persona guarda el nombre, el medio con el
 *         que va a pagar y el DNI correspondiente al titular, implementa la
 *         interfase cloneable y obliga a la clases hijas a implementar el
 *         metodo clone()<br>
 */
public abstract class Persona implements Cloneable {
	protected String nombre;
	protected MedioPago medioPago;
	protected int dni;

	public Persona(String nombre, int dni, MedioPago medioPago) {
		this.nombre = nombre;
		this.dni = dni;
		this.medioPago = medioPago;
	}

	public String getNombre() {
		return nombre;
	}

	public int getDni() {
		return dni;
	}

	public MedioPago getMedioPago() {
		return medioPago;
	}

	private void setMedioPago(MedioPago medioPago) {
		this.medioPago = medioPago;
	}

	@Override
	public String toString() {
		return "Persona ";
	}

	@Override
	public Persona clone() throws CloneNotSupportedException {
		return (Persona) super.clone();
	}

	public abstract double getTasa();

	
	/**
	 * Cambia el medio de pago de la persona<br>
	 * <b>Pre:</b>no tiene<br>
	 * <b>Post:</b>Se cambiara el medio de pago por el ingresado y si no existe no hara nada<br>
	 * @param medioPago: El medio de pago por el cual se cambiara
	 */
	public void cambiaMedioPago(String medioPago) {
		if (medioPago.equals("Tarjeta"))
			this.setMedioPago(new Tarjeta());
		else if (medioPago.equals("Cheque"))
			this.setMedioPago(new Cheque());
		else if (medioPago.equals("Efectivo"))
			this.setMedioPago(new Efectivo());
	}
}

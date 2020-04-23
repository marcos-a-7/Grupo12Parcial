package clientes;

/**
 * @author Grupo12
 *La clase abstracta persona guarda el nombre, el medio con el que va a pagar y el DNI correspondiente al titular, implementa la interfase cloneable y obliga a la clases hijas a implementar el metodo clone()<br>
 */
public abstract class Persona implements Cloneable {
	protected String nombre;
	protected MedioPago medioPago;
	protected int dni;
	
	public Persona(String nombre, int dni, MedioPago medioPago) {
		this.nombre = nombre;
		this.dni = dni;
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
	public void setMedioPago(MedioPago medioPago) {
		this.medioPago = medioPago;
	}
	@Override
	public String toString() {
		return "Persona ";
	}
	@Override
	public Persona clone() throws CloneNotSupportedException {
		return (Persona)super.clone();
	}
	public abstract double getTasa();
}

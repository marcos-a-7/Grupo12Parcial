package modelo;

public abstract class Persona implements Cloneable {
	protected String nombre, medioPago;
	protected int dni;
	
	public Persona(String nombre, int dni, String medioPago) {
		this.nombre = nombre;
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}
	public int getDni() {
		return dni;
	}
	public String getMedioPago() {
		return medioPago;
	}
	public void setMedioPago(String medioPago) {
		this.medioPago = medioPago;
	}
	@Override
	public String toString() {
		return "Persona ";
	}
	@Override
	protected Persona clone() throws CloneNotSupportedException {
		return (Persona)super.clone();
	}
	
}

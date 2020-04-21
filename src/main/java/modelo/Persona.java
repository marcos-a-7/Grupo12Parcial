package modelo;

public abstract class Persona implements Cloneable {
	protected String nombre;
	protected int dni;
	
	public Persona(String nombre, int dni) {
		this.nombre = nombre;
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}
	public int getDni() {
		return dni;
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

package modelo;

public class PersonaFisica extends Persona {

	public PersonaFisica(String nombre, int dni) {
		super(nombre, dni);
	}
	@Override
	public String toString() {
		return super.toString() + " Fisica - Nombre: " + this.nombre + " DNI: " + this.dni + "\n" ;
	}
}

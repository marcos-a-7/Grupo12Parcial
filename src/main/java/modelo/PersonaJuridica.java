package modelo;

public class PersonaJuridica extends Persona {

	public PersonaJuridica(String nombre, int dni) {
		super(nombre, dni);
	}

	@Override
	public String toString() {
		return super.toString() + " Juridica - Nombre: " + this.nombre + " DNI: " + this.dni + "\n" ;
	}
	@Override
	protected PersonaJuridica clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}

package clientes;

/**
 * @author Grupo12
 *La persona fisica es siempre es clonable<br>
 */
public class PersonaFisica extends Persona {

	public PersonaFisica(String nombre, int dni, MedioPago medioPago) {
		super(nombre, dni, medioPago);
	}

	@Override
	public double getTasa() {
		return this.medioPago.getTasaFisica();
	}

	@Override
	public String toString() {
		return super.toString() + " Fisica - Nombre: " + this.nombre + " DNI: " + this.dni + "\n";
	}

	@Override
	public PersonaFisica clone() throws CloneNotSupportedException {
		return (PersonaFisica) super.clone();
	}
}

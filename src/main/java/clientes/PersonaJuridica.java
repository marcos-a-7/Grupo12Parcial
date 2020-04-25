package clientes;

/**
 * @author Grupo12 <br>
 *         <b>La persona Juridica no puede ser clonada</b><br>
 */
public class PersonaJuridica extends Persona {

	public PersonaJuridica(String nombre, int dni, MedioPago medioPago) {
		super(nombre, dni, medioPago);
	}

	@Override
	public double getTasa() {
		return this.medioPago.getTasaJuridica();
	}

	@Override
	public String toString() {
		return super.toString() + " Juridica - Nombre: " + this.nombre + " DNI: " + this.dni + "\n";
	}

	@Override
	public PersonaJuridica clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}
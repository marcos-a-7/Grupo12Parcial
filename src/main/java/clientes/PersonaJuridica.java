package clientes;

/**
 * @author Grupo12 <br>
 *         <b>La persona Juridica no puede ser clonada</b><br>
 */
public class PersonaJuridica extends Persona {

	int id;

	public PersonaJuridica(String nombre, int id, MedioPago medioPago) {
		super(nombre, medioPago);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	@Override
	public double getTasa() {
		return this.medioPago.getTasaJuridica();
	}

	@Override
	public String toString() {
		return super.toString() + " Juridica - Nombre: " + this.nombre + " ID: " + this.id + "\n";
	}

	@Override
	public PersonaJuridica clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}

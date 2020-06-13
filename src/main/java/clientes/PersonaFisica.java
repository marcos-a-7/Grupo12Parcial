package clientes;

/**
 * @author Grupo12 <br>
 *         <b>La persona fisica es siempre es clonable</b><br>
 */
public class PersonaFisica extends Persona {

	protected int dni;
	String estado = "Sin contrataciones";

	public PersonaFisica(String nombre, int dni, MedioPago medioPago) {
		super(nombre, medioPago);
		this.dni = dni;
	}

	public String getEstado() {
		return estado;
	}

	public int getDni() {
		return dni;
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

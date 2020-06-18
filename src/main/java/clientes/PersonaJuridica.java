package clientes;

import modelo.Contrato;

/**
 * @author Grupo12 <br>
 *         <b>La persona Juridica no puede ser clonada</b><br>
 */
public class PersonaJuridica extends Persona {

	int id;

	public PersonaJuridica(String nombre, int id, MedioPago medioPago) {
		super(nombre);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	@Override
	public double getTasa(Contrato contrato) {
		return contrato.getMedioPago().getTasaJuridica();
	}

	@Override
	public String toString() {
		return super.toString() + " Juridica - Nombre: " + this.nombre + " ID: " + this.id + "\n";
	}

	@Override
	public PersonaJuridica clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	@Override
	public void actualizaEstado() {
		State estado;
		if (!this.contratos.isEmpty()) {
			estado = new ConContratacionesState(this);
		} else {
			estado = new SinContratacionesState(this);
		}

		this.estado = estado;

	}

	@Override
	public int getIdentificador() {
		return id;
	}
}

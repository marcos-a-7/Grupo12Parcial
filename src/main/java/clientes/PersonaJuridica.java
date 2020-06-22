package clientes;

import modelo.Contrato;

/**
 * @author Grupo12 <br>
 *         <b>La persona Juridica no puede ser clonada</b><br>
 */
public class PersonaJuridica extends Persona {

	

	public PersonaJuridica(String nombre, int id, MedioPago medioPago) {
		super(nombre,id);
	}


	@Override
	public double getTasa(Contrato contrato) {
		return contrato.getMedioPago().getTasaJuridica();
	}

	@Override
	public String toString() {
		return super.toString() + " Juridica - Nombre: " + this.nombre + " ID: " + this.getIdentificador() + "\n";
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


}

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
	public double getTasa(int idContrato) {
		Contrato contrato;
		contrato = this.buscaContrato(idContrato);
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

		String estado = "Sin contrataciones";
		if (!this.contratos.isEmpty()) {
			estado = "Con contrataciones";
		}
		this.estado = estado;

	}

	@Override
	public int getIdentificador() {
		return id;
	}
}

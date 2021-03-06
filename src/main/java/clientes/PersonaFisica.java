package clientes;

import java.util.Iterator;

import modelo.Contrato;
import modelo.Factura;

/**
 * @author Grupo12 <br>
 *         <b>La persona fisica es siempre es clonable</b><br>
 */
public class PersonaFisica extends Persona {

	public PersonaFisica(String nombre, int dni, MedioPago medioPago) {
		super(nombre, dni);
	}

	/**
	 * actualizaEstado<br>
	 * actualiza el estado de la persona<br>
	 */
	public void actualizaEstado() {
		State estado;
		if (this.isMoroso()) {
			estado = new MorosoState(this);
		} else {
			if (!this.contratos.isEmpty()) {
				estado = new ConContratacionesState(this);
			} else {
				estado = new SinContratacionesState(this);
			}
		}
		this.estado = estado;
	}

	/**
	 * isMoroso<br>
	 * calcula si una persona se volvio morosa y retorna un boolaean<br>
	 * 
	 * @return retorna true si la persona se volvio morosa
	 */
	private boolean isMoroso() {
		int cantidad = 0;
		Iterator<Factura> it = facturas.iterator();
		while (it.hasNext() && cantidad < 3) {
			if (!it.next().isPagada())
				cantidad++;
		}
		return cantidad > 2;
	}

	@Override
	public double getTasa(Contrato contrato) {
		return contrato.getMedioPago().getTasaFisica();
	}

	@Override
	public String toString() {
		return super.toString() + " Fisica - Nombre: " + this.nombre + " DNI: " + this.getIdentificador() + "\n";
	}

	@Override
	public PersonaFisica clone() throws CloneNotSupportedException {
		return (PersonaFisica) super.clone();
	}

}

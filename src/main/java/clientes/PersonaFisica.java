package clientes;

import java.util.Iterator;

import modelo.Contrato;
import modelo.Factura;

/**
 * @author Grupo12 <br>
 *         <b>La persona fisica es siempre es clonable</b><br>
 */
public class PersonaFisica extends Persona {

	protected int dni;

	public PersonaFisica(String nombre, int dni, MedioPago medioPago) {
		super(nombre);
		this.dni = dni;
	}

	public int getDni() {
		return dni;
	}

	public void actualizaEstado() {
		State estado;
		if (this.isMoroso()) {
			estado = new MorosoState(this);
		} else {
			if (!this.contratos.isEmpty()) {
				estado = new ConContratacionesState(this);
			}
			else {
				estado = new SinContratacionesState(this);
			}
		}
		this.estado = estado;
	}

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
		return super.toString() + " Fisica - Nombre: " + this.nombre + " DNI: " + this.dni + "\n";
	}

	@Override
	public PersonaFisica clone() throws CloneNotSupportedException {
		return (PersonaFisica) super.clone();
	}

	@Override
	public int getIdentificador() {
		return dni;
	}

}

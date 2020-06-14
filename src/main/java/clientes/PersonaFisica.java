package clientes;

import java.util.Observable;

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
	public void actualizaEstado() {
		String estado = "Sin contrataciones";
		if(!this.contratos.isEmpty()) {
			estado = "Con contrataciones";
		}
		if(this.facturas.size()>2) {
			estado = "Moroso";
		}
		this.estado = estado;
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
	@Override
	public void update(Observable o, Object arg) {
		super.update(o, arg);
		this.actualizaEstado();
	}
}

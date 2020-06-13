package clientes;

import java.util.ArrayList;
import java.util.Iterator;

import modelo.Contrato;
import modelo.ContratoFactory;
import modelo.Factura;
import servicios.PaqueteServicios;

/**
 * @author Grupo12<br>
 *         <b> La clase abstracta persona guarda el nombre, el medio con el que
 *         va a pagar y el DNI correspondiente al titular, implementa la
 *         interfase cloneable y obliga a la clases hijas a implementar el
 *         metodo clone()</b><br>
 */
public abstract class Persona implements Cloneable {
	protected String nombre;
	protected MedioPago medioPago;
	ArrayList<Contrato> contratos = new ArrayList<Contrato>();
	ArrayList<Factura> facturas = new ArrayList<Factura>();

	public Persona(String nombre, MedioPago medioPago) {
		this.nombre = nombre;
		this.medioPago = medioPago;
	}

	public String getNombre() {
		return nombre;
	}

	public MedioPago getMedioPago() {
		return medioPago;
	}

	private void setMedioPago(MedioPago medioPago) {
		this.medioPago = medioPago;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void agregaContrato(Domicilio domicilio, PaqueteServicios paqueteServicios) {
		contratos.add(ContratoFactory.getContrato(domicilio, paqueteServicios));

	}
	
	/* hacer funciones por domicilio y por id de contrato
	public Contrato buscaContrato() {
		//hacer
		return null;
	}
	
	public void borraContrato() {
		//hacer
	}
	 */
	
	//esta funcion pasa una referencia a la persona para que la factura pueda cambiar en caso de que cambien los datos de la persona (ejemplo medio de pago)
	public void facturar() {
		Iterator<Contrato> it = contratos.iterator();
		while(it.hasNext()) {
			facturas.add(it.next().getFactura(this));
		}
		
	}
	
	@Override
	public String toString() {
		return "Persona ";
	}

	@Override
	public Persona clone() throws CloneNotSupportedException {
		return (Persona) super.clone();
	}

	public abstract double getTasa();

	/**
	 * Cambia el medio de pago de la persona<br>
	 * <b>Pre:</b>no tiene<br>
	 * <b>Post:</b>Se cambiara el medio de pago por el ingresado y si no existe no
	 * hara nada<br>
	 * 
	 * @param medioPago: El medio de pago por el cual se cambiara
	 */
	public void cambiaMedioPago(String medioPago) {
		if (medioPago.equals("Tarjeta"))
			this.setMedioPago(new Tarjeta());
		else if (medioPago.equals("Cheque"))
			this.setMedioPago(new Cheque());
		else if (medioPago.equals("Efectivo"))
			this.setMedioPago(new Efectivo());
	}
}

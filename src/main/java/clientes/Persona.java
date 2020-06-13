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
	
	/**
	 * Busca un contrato a traves de un id<br>
	 * <b>Pre: </b> no tiene<br>
	 * <b>Post: </b> devolvera el contrato de dicho id ingresado, si no lo encuentra
	 * devolvera null<br>
	 * 
	 * @param id : es el id el cual esta asociado a un contrato<br>
	 * @return retorna un contrato o null <br>
	 */
	public Contrato buscaContrato(int id) {
		boolean encontre = false;
		Contrato contrato = null;
		Iterator<Contrato> it = contratos.iterator();
		while (it.hasNext() && !encontre) {
			contrato = it.next();
			if (id == contrato.getIdContrato())
				encontre = true;
		}
		if (!encontre)
			contrato = null;
		return contrato;
	}

	/**
	 * Busca un contrato a traves de una calle y el numero de direccion<br>
	 * <b>Pre: </b> Debe ingresar una calle no nula<br>
	 * <b>Post: </b> devolvera el contrato correspondiente a la calle y numero
	 * ingresado, si no lo encuentra devolvera null<br>
	 * 
	 * @param calle  : La calle del domicilio de la persona
	 * @param numero : El numero de la calle del domicilio de la persona
	 * @return retorna un contrato o null<br>
	 */
	public Contrato buscaContrato(String calle, int numero) {
		boolean encontre = false;
		Domicilio domicilio = null;
		Contrato contrato = null;
		Iterator<Contrato> it = contratos.iterator();
		while (it.hasNext() && !encontre) {
			contrato = it.next();
			domicilio = contrato.getDomicilio();
			if (domicilio.getCalle().equals(calle) && (domicilio.getNumero() == numero))
				encontre = true;
		}
		if (!encontre)
			contrato = null;
		return contrato;
	}
	
	/**
	 * Elimina un contrato segun el id <b>Pre: </b> no tiene<br>
	 * <b>Post: </b> remueve el contrato si el id corresponde a uno existente, de lo
	 * contrario no realiza ninguna accion<br>
	 * 
	 * @param id el id del contrato a eliminar
	 */
	public void eliminaContrato(int id) {
		Contrato contrato = this.buscaContrato(id);
		if (contrato != null)
			this.contratos.remove(contrato);
	}

	/**
	 * Elimina un contrato segun la calle y el numero de domicilio <b>Pre: </b> no
	 * tiene<br>
	 * <b>Post: </b> remueve el contrato si la calle y el numero de la calle
	 * corresponden a uno existente, de lo contrario no realiza ninguna accion<br>
	 * 
	 * @param calle  : la calle del domicilio del titular<br>
	 * @param numero : el numero del domicilio del titular <br>
	 */
	public void eliminaContrato(String calle, int numero) {
		Contrato contrato = this.buscaContrato(calle, numero);
		if (contrato != null)
			this.contratos.remove(contrato);
	}
	
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

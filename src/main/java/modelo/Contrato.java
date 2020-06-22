package modelo;

import java.io.Serializable;

import clientes.Cheque;
import clientes.Domicilio;
import clientes.Efectivo;
import clientes.MedioPago;
import clientes.Persona;
import clientes.Tarjeta;
import servicios.Cable;
import servicios.Celular;
import servicios.Internet100;
import servicios.Internet500;
import servicios.PaqueteServicios;
import servicios.Telefono;

/**
 * @author grupo12<br>
 *         <b> la clase contrato guarda los datos de la persona y del paquete de
 *         servicio, tambien puede generar una factura</b>
 */
public class Contrato implements Cloneable, Serializable {
	private static int generadorIdContrato = 1;
	private int idContrato;
	private Domicilio domicilio;
	private PaqueteServicios paqueteServicios;
	private MedioPago medioPago;

	public Contrato(Domicilio domicilio, PaqueteServicios paqueteServicios, MedioPago medioPago) {
		this.idContrato = generadorIdContrato++;
		this.domicilio = domicilio;
		this.paqueteServicios = paqueteServicios;
		this.medioPago = medioPago;
	}

	public MedioPago getMedioPago() {
		return medioPago;
	}

	private void setMedioPago(MedioPago medioPago) {
		this.medioPago = medioPago;
	}

	public int getIdContrato() {
		return idContrato;
	}

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	public PaqueteServicios getPaqueteServicios() {
		return paqueteServicios;
	}

	public void setPaqueteServicios(PaqueteServicios paqueteServicios) {
		this.paqueteServicios = paqueteServicios;
	}

	/**
	 * * GetFactura<br>
	 * <b>Pre:</b> no tiene<br>
	 * <b>Post:</b> devolvera una factura<br>
	 * <b>Crea una factura y la devuelve</b>
	 *
	 * @return retorna una factura<br>
	 */
	public Factura getFactura(Persona titular, int mes) {
		Factura factura = null;
		try {
			factura = new Factura(this.idContrato, titular.getNombre(),titular.getIdentificador(),titular.getTasa(this), this.domicilio.clone(), this.paqueteServicios.clone(), mes);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return factura;
	}

	public void addCelulares(int cantCelu) {
		int i;
		for (i = 0; i < cantCelu; i++)
			this.paqueteServicios.addCelular(new Celular());
	}

	public void addTelefonos(int cantTel) {
		int i;
		for (i = 0; i < cantTel; i++)
			this.paqueteServicios.addTelefono(new Telefono());
	}

	public void addCables(int cantCables) {
		int i;
		for (i = 0; i < cantCables; i++)
			this.paqueteServicios.addCable(new Cable());
	}

	public void eliminaCelular(int numeroCelular) {
		this.paqueteServicios.eliminaCelular(numeroCelular);
	}

	public void eliminaTelefono(int numeroTelefono) {
		this.paqueteServicios.eliminaTelefono(numeroTelefono);
	}

	public void eliminaCables(int cantCables) {
		this.paqueteServicios.eliminaCables( cantCables);
	}

	/**
	 * <b>Pre:</b> no tiene<br>
	 * <b>Post:</b> cambiara el tipo de internet establecido al ingresado y si no
	 * existe no hara nada<br>
	 * 
	 * @param tipoInternet : El tipo de internet al cual se quiere cambiar<br>
	 */
	public void cambiaInternet(String tipoInternet) {
		if (tipoInternet.equals("100")) {
			paqueteServicios.setInternet(new Internet100());
		} else if (tipoInternet.equals("500")) {
			paqueteServicios.setInternet(new Internet500());
		}
	}

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

	@Override
	protected Contrato clone() throws CloneNotSupportedException {
		Contrato aux = (Contrato) super.clone();
		aux.paqueteServicios = this.paqueteServicios.clone();
		aux.medioPago = this.medioPago.clone();
		aux.domicilio = this.domicilio.clone();
		return aux;
	}

	@Override
	public String toString() {
		return "ID: " + this.idContrato +" "+ this.domicilio.toString();
	}
	
	
}

package modelo;

import clientes.Domicilio;
import clientes.Persona;
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
public class Contrato {
	private static int generadorIdContrato = 1;
	private int idContrato;
	private Domicilio domicilio;
	private PaqueteServicios paqueteServicios;

	public Contrato(Domicilio domicilio, PaqueteServicios paqueteServicios) {
		this.idContrato = generadorIdContrato++;
		this.domicilio = domicilio;
		this.paqueteServicios = paqueteServicios;
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
	public Factura getFactura(Persona titular) {
		Factura factura = null;
		factura = new Factura(idContrato, titular, domicilio, paqueteServicios);
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
		this.paqueteServicios.eliminaCable();
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
			paqueteServicios.setInternet(Internet100.getInstance());
		} else if (tipoInternet.equals("500")) {
			paqueteServicios.setInternet(Internet500.getInstance());
		}
	}
}

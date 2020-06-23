package clientes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import excepciones.ImposibleCrearContratoException;
import excepciones.ImposibleCrearPaqueteException;

import excepciones.MorosoException;
import excepciones.SinContratacionesException;

import modelo.Contrato;

import modelo.Factura;

/**
 * @author Grupo12<br>
 *         <b> La clase abstracta persona guarda el nombre, el medio con el que
 *         va a pagar y el DNI correspondiente al titular, implementa la
 *         interfase cloneable y obliga a la clases hijas a implementar el
 *         metodo clone()</b><br>
 */
public abstract class Persona implements Cloneable, Serializable {
	protected String nombre;
	protected int identificador;
	ArrayList<Contrato> contratos = new ArrayList<Contrato>();
	ArrayList<Factura> facturas = new ArrayList<Factura>();
	protected State estado = new SinContratacionesState(this);

	public Persona(String nombre, int identificador) {
		this.nombre = nombre;
		this.identificador = identificador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * actualizaEstado <br>
	 * esta funcion debe encargarse de actualizar el estado de la persona <br>
	 */
	public abstract void actualizaEstado();

	public State getEstado() {
		return estado;
	}

	public ArrayList<Contrato> getContratos() {
		return contratos;
	}

	public ArrayList<Factura> getFacturas() {
		return facturas;
	}

	/**
	 * agregaContrato<br>
	 * esta funcion delega el agregado de contrato de la persona al estado de la
	 * misma<br>
	 * <b>Pre: </b> la calle y el numero de calle deben ser validos<br>
	 * <b>Post: </b> delega al estado el agregado del contrato, puede lanzar
	 * excepciones<br>
	 * 
	 * @param calle:        calle del domicilio
	 * @param numeroCalle:  numero del domicilio
	 * @param tipoInternet: tipo de internet 500 o 100
	 * @param cantCelu:     cantidad de celulares a contratar
	 * @param cantTel:      cantidad de telefonos a contratar
	 * @param cantCable:    cantidad de cables a contratar
	 * @param medioPago:    por que medio va a pagar si por cheque efectivo o
	 *                      tarjeta
	 * @throws ImposibleCrearContratoException
	 * @throws ImposibleCrearPaqueteException
	 */
	public void agregaContrato(String calle, int numeroCalle, String tipoInternet, int cantCelu, int cantTel,
			int cantCable, String medioPago) throws ImposibleCrearContratoException, ImposibleCrearPaqueteException {
		estado.agregaContrato(calle, numeroCalle, tipoInternet, cantCelu, cantTel, cantCable, medioPago);
	}

	/**
	 * modificaContrato<br>
	 * delega al estado la pregunta de si puede modificar contrato<br>
	 * <b>pre:</b> no tiene<br>
	 * <b>post:</b> si el estado permite modificar contrato devuelve true, puede
	 * lanzar excepciones<br>
	 * 
	 * @return devuelve true si se pueden realizar modificaciones de contrato o
	 *         false si no
	 * @throws MorosoException
	 * @throws SinContratacionesException
	 */
	public boolean modificaContrato() throws MorosoException, SinContratacionesException {
		return this.estado.modificaContrato();
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
	 * @throws SinContratacionesException
	 * @throws MorosoException
	 */
	public void eliminaContrato(int id) throws MorosoException, SinContratacionesException {
		Contrato contrato = this.buscaContrato(id);
		if (contrato != null)
			estado.eliminaContrato(contrato);
	}

	/**
	 * Elimina un contrato segun la calle y el numero de domicilio <b>Pre: </b> no
	 * tiene<br>
	 * <b>Post: </b> remueve el contrato si la calle y el numero de la calle
	 * corresponden a uno existente, de lo contrario no realiza ninguna accion<br>
	 * 
	 * @param calle  : la calle del domicilio del titular<br>
	 * @param numero : el numero del domicilio del titular <br>
	 * @throws SinContratacionesException
	 * @throws MorosoException
	 */
	public void eliminaContrato(String calle, int numero) throws MorosoException, SinContratacionesException {
		Contrato contrato = this.buscaContrato(calle, numero);
		if (contrato != null)
			estado.eliminaContrato(contrato);
	}

	public void eliminaContrato(Contrato contrato) throws MorosoException, SinContratacionesException {
		estado.eliminaContrato(contrato);
	}

	/**
	 * facturar<br>
	 * emite las facturas correspondientes al mes para la persona<br>
	 * 
	 * @param mes : mes a facturar
	 */
	public void facturar(int mes) {
		Iterator<Contrato> it = contratos.iterator();
		while (it.hasNext()) {
			facturas.add(it.next().getFactura(this, mes));
		}
	}

	/**
	 * pagar<br>
	 * funcion que permite pagar una factura<br>
	 * pre: no tiene<br>
	 * post: puede lanzar excepciones, devuelve el monto abonado<br>
	 * 
	 * @param factura : factura a pagar
	 * @return devuelve el monto abonado
	 * @throws SinContratacionesException
	 */
	public double pagar(Factura factura) throws SinContratacionesException {
		double monto = estado.pagar(factura);
		this.actualizaEstado();
		return monto;
	}

	/**
	 * cantFacturasDebidas<br>
	 * funcion que calcula la cantidad de facturas no abonadas que tiene la
	 * persona<br>
	 * 
	 * @return devuelve la cantidad de facturas debidas
	 */
	public int cantidadFacturasDebidas() {
		int cantidad = 0;
		Iterator<Factura> it = facturas.iterator();
		while (it.hasNext()) {
			if (!it.next().isPagada())
				cantidad++;
		}
		return cantidad;
	}

	@Override
	public String toString() {
		return "Persona ";
	}

	@Override ////// No se esta realizando clonacion profunda al estado porque por
				////// implementacion de patron state hay doble referencia con persona
	public Persona clone() throws CloneNotSupportedException {
		Persona aux = (Persona) super.clone();
		aux.facturas = (ArrayList<Factura>) this.facturas.clone();
		aux.contratos = (ArrayList<Contrato>) this.contratos.clone();
		return aux;
	}

	public abstract double getTasa(Contrato contrato);

	public int getIdentificador() {
		return identificador;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + identificador;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Persona))
			return false;
		Persona other = (Persona) obj;
		if (identificador != other.identificador)
			return false;
		return true;
	}

}

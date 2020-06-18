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
	ArrayList<Contrato> contratos = new ArrayList<Contrato>();
	ArrayList<Factura> facturas = new ArrayList<Factura>();
	protected State estado = new SinContratacionesState(this);

	public Persona(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

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

	public void agregaContrato(String calle, int numeroCalle, String tipoInternet, int cantCelu, int cantTel,
			int cantCable, String medioPago) throws ImposibleCrearContratoException, ImposibleCrearPaqueteException {
		estado.agregaContrato(calle, numeroCalle, tipoInternet, cantCelu, cantTel, cantCable, medioPago);
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

	// esta funcion pasa una referencia a la persona para que la factura pueda
	// cambiar en caso de que cambien los datos de la persona (ejemplo medio de
	// pago)
	public void facturar(int mes) {
		Iterator<Contrato> it = contratos.iterator();
		while (it.hasNext()) {
			facturas.add(it.next().getFactura(this, mes));
		}
	}

	public double pagar(Factura factura) throws SinContratacionesException {
		return estado.pagar(factura);
	}

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

	public abstract int getIdentificador();

}

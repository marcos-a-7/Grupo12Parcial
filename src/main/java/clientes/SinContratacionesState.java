package clientes;

import java.io.Serializable;

import excepciones.DomicilioDuplicadoException;
import excepciones.ImposibleCrearContratoException;
import excepciones.ImposibleCrearPaqueteException;
import excepciones.MorosoException;
import excepciones.SinContratacionesException;
import modelo.Contrato;
import modelo.ContratoFactory;
import modelo.Factura;
import servicios.PaqueteServicios;
import servicios.PaqueteServiciosFactory;

/**
 * @author Grupo12<br>
 *         guarda una referencia a la persona que posee dicho estado
 *
 */
public class SinContratacionesState implements State, Serializable {
	Persona persona;

	public SinContratacionesState(Persona persona) {
		this.persona = persona;
	}

	/**
	 * pagar<br>
	 * funcion que paga una factura<br>
	 * pre: no tiene <br>
	 * post: siempre lanza una excepcion SinContratacionesException<br>
	 *
	 *
	 * @param factura : factura a pagar
	 * @throws SinContratacionesException
	 */
	public double pagar(Factura factura) throws SinContratacionesException {
		throw new SinContratacionesException(persona.getNombre() + " no tiene facturas para pagar");
	}

	/**
	 * eliminaContrato<br>
	 * elimina el contrato de la persona<br>
	 * <b>Pre: </b> no tiene<br>
	 * <b>Post: </b> siempre lanza una excepcion SinContratacionesException<br>
	 * 
	 * @param contrato:sin condiciones <br>
	 * @throws SinContratacionesException<br>
	 */
	public void eliminaContrato(Contrato contrato) throws SinContratacionesException {
		throw new SinContratacionesException(persona.getNombre() + " no tiene contrataciones para eliminar");
	}

	/**
	 * agregaContrato<br>
	 * crea un contrato y lo agrega al array list<br>
	 * <b>Pre: </b> la calle y el numero de calle deben ser validos<br>
	 * <b>Post: </b> crea un domicilio, un paquete de servicios para crear contrato,
	 * luego si no existe un contrato para dicho domicilio crea un nuevoo contrato y
	 * lo guarda en el arraylis de la persona<br>
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

		Contrato auxContrato;
		Domicilio domicilio = new Domicilio(calle, numeroCalle);
		PaqueteServicios paqueteServicios;
		paqueteServicios = PaqueteServiciosFactory.getPaqueteServicios(tipoInternet, cantCelu, cantTel, cantCable);
		auxContrato = persona.buscaContrato(calle, numeroCalle);
		if (auxContrato == null) {
			persona.getContratos().add(ContratoFactory.getContrato(domicilio, paqueteServicios, medioPago));
			persona.actualizaEstado();
		} else
			throw new DomicilioDuplicadoException(domicilio.toString() + " no se pudo agregar, esta duplicado");
	}

	/**
	 * modificaContrato<br>
	 * devuelve true si el estado permite modificar el contrato<br>
	 * <b>Pre: </b> no tiene<br>
	 * <b>Post: </b> siempre lanza una excepcion SinContratacionesException debido a
	 * que este estado no puede modificar contratos<br>
	 */
	public boolean modificaContrato() throws SinContratacionesException {
		throw new SinContratacionesException(persona.getNombre() + " no tiene contrataciones para modificar");
	}

}

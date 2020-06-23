package clientes;

import java.io.Serializable;

import excepciones.DomicilioDuplicadoException;
import excepciones.ImposibleCrearContratoException;
import excepciones.ImposibleCrearPaqueteException;
import excepciones.MorosoException;
import modelo.Contrato;
import modelo.ContratoFactory;
import modelo.Factura;
import servicios.PaqueteServicios;
import servicios.PaqueteServiciosFactory;

/**
 * @author Grupo12 <br>
 *         <b>se guarda una referencia a la persona que posee dicho estado</b>
 *
 */
/**
 * @author marco
 *
 */
public class ConContratacionesState implements State, Serializable {
	Persona persona;

	public ConContratacionesState(Persona persona) {
		this.persona = persona;
	}

	/**
	 * pagar<br>
	 * paga una factura y devuelve la cantidad abonada<br>
	 * <b>Pre: </b> la factura no debe ser null<br>
	 * <b>Post: </b> devuelve la cantidad abonada si la factura no estaba pagada, si
	 * estaba pagada devuelve 0<br>
	 * 
	 * @param factura: no debe ser null <br>
	 */
	public double pagar(Factura factura) {
		double monto = 0;
		if (!factura.isPagada()) {
			monto = factura.getCostoFinal();
			factura.pagar();
		}
		return monto;
	}

	/**
	 * eliminaContrato<br>
	 * elimina el contrato de la persona<br>
	 * <b>Pre: </b> no tiene<br>
	 * <b>Post: </b> elimina el contrato recibido por parametro si este existe en la
	 * persona<br>
	 * 
	 * @param contrato:sin condiciones <br>
	 */
	public void eliminaContrato(Contrato contrato) {
		persona.getContratos().remove(contrato);
	}

	/**
	 * agregaContrato<br>
	 * crea un contrato y lo agrega al array list<br>
	 * <b>Pre: </b> la calle y el numero de calle deben ser validos<br>
	 * <b>Post: </b> crea un domicilio, un paquete de servicios para crear contrato,
	 * luego si no existe un contrato para dicho domicilio crea un nuevoo contrato y
	 * lo guarda en el arraylis de la persona<br>
	 * 
	 * @param calle: calle del domicilio
	 * @param numeroCalle: numero del domicilio
	 * @param tipoInternet: tipo de internet 500 o 100
	 * @param cantCelu: cantidad de celulares a contratar
	 * @param cantTel: cantidad de telefonos a contratar
	 * @param cantCable: cantidad de cables a contratar
	 * @param medioPago: por que medio va a pagar si por cheque efectivo o tarjeta
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
		if (auxContrato == null)
			persona.getContratos().add(ContratoFactory.getContrato(domicilio, paqueteServicios, medioPago));
		else
			throw new DomicilioDuplicadoException(domicilio.toString() + " no se pudo agregar, esta duplicado");
	}

	/**
	 * modificaContrato<br>
	 * devuelve true si el estado permite modificar el contrato<br>
	 * <b>Pre: </b> no tiene<br>
	 * <b>Post: </b> devuelve siempre true, por ser estado con contrataciones<br>
	 */
	public boolean modificaContrato() {
		return true;
	}

}

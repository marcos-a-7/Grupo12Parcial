package clientes;

import java.io.Serializable;

import excepciones.DomicilioDuplicadoException;
import excepciones.ImposibleCrearContratoException;
import excepciones.ImposibleCrearPaqueteException;
import excepciones.SinContratacionesException;
import modelo.Contrato;
import modelo.ContratoFactory;
import modelo.Factura;
import servicios.PaqueteServicios;
import servicios.PaqueteServiciosFactory;

public class SinContratacionesState implements State, Serializable {
	Persona persona;

	public SinContratacionesState(Persona persona) {
		this.persona = persona;
	}

	public double pagar(Factura factura) throws SinContratacionesException {
		throw new SinContratacionesException(persona.getNombre() + " no tiene facturas para pagar");
	}

	public void eliminaContrato(Contrato contrato) throws SinContratacionesException {
		throw new SinContratacionesException(persona.getNombre() + " no tiene contrataciones para eliminar");
	}

	/**
	 * Add contrato<br>
	 * crea un contrato y lo agrega al array list<br>
	 * <b>Pre: </b> la calle y el numero de calle deben ser validos<br>
	 * <b>Post: </b> crea una persona, un domicilio, un paquete de servicios para
	 * crear contrato y luego lo guarda en el arraylist, en caso de que el tipo de
	 * persona, el nombre o el medio de pago sean invalidos captara la excepcion
	 * correspondiente y la resolvera. Si se ingreso una cantidad de Celulares,
	 * Telefonos o Lineas de cable negativas se consideraran como 0 <br>
	 * 
	 * @param tipoPersona : puede ser juridica o fisica en la poscondicion aclara
	 *                    que pasa si no se ingresa una correcta @param nombre : el
	 *                    nombre de la persona @param dni : el dni de la
	 *                    persona @param medioPago : por que medio va a pagar si por
	 *                    cheque efectivo o tarjeta @param calle : nombre de la
	 *                    calle del domicilio @param numeroCalle : numero del
	 *                    domicilio @param tipoInternet : el tipo de internet a
	 *                    contratar 100 o 500 @param cantCelu : La cantidad de
	 *                    celulares a contratar @param cantTel : La cantidad de
	 *                    telefonos a contratar @param cantCable : La cantidad de
	 *                    cable a contratar @throws
	 *                    ImposibleCrearPaqueteException @throws
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

	public void modificaContrato(Contrato contrato) throws SinContratacionesException {
		throw new SinContratacionesException(persona.getNombre() + " no tiene contrataciones para modificar");
	}

}

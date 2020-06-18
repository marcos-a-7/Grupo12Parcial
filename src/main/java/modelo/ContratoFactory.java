package modelo;

import clientes.Cheque;
import clientes.Domicilio;
import clientes.Efectivo;
import clientes.MedioPago;
import clientes.Tarjeta;
import excepciones.MedioPagoInvalidoException;
import servicios.PaqueteServicios;

/**
 * @author Grupo12 <br>
 *         <b>Crea un contrato nuevo</b>
 */
public class ContratoFactory {

	public static Contrato getContrato(Domicilio domicilio, PaqueteServicios paqueteServicios, String medioPago) throws MedioPagoInvalidoException {
		MedioPago auxMedioPago;
		
		if (medioPago == null)
			throw new MedioPagoInvalidoException("No se ingreso ningun medio de pago");
		else if (medioPago.equals("Tarjeta"))
			auxMedioPago = new Tarjeta();
		else if (medioPago.equals("Cheque"))
			auxMedioPago = new Cheque();
		else if (medioPago.equals("Efectivo"))
			auxMedioPago = new Efectivo();
		else
			throw new MedioPagoInvalidoException("Medio de pago ingresado no valido");
		
		return new Contrato(domicilio, paqueteServicios, auxMedioPago );

	}

}

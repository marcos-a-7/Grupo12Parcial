package modelo;

import clientes.Domicilio;
import clientes.Persona;
import servicios.PaqueteServicios;

/**
 * @author Grupo12 <br>
 *         <b>Crea un contrato nuevo</b>
 */
public class ContratoFactory {

	public static Contrato getContrato(Domicilio domicilio, PaqueteServicios paqueteServicios) {

		return new Contrato(domicilio, paqueteServicios);

	}

}

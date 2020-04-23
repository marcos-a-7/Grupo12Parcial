package modelo;

import clientes.Domicilio;
import clientes.Persona;
import servicios.PaqueteServicios;

/**
 * @author Grupo12
 *<b>Crea un contrato nuevo</b>
 */
public class ContratoFactory {



	protected static Contrato getContrato(Persona titular, Domicilio domicilio, PaqueteServicios paqueteServicios) {
		if (titular!=null)
				return new Contrato(titular,domicilio,paqueteServicios);
		return null;
	}

}

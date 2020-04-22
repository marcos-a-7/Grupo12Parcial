package modelo;

public class ContratoFactory {



	protected static Contrato getContrato(Persona titular, Domicilio domicilio, PaqueteServicios paqueteServicios) {
		if (titular!=null)
				return new Contrato(titular,domicilio,paqueteServicios);
		return null;
	}

}

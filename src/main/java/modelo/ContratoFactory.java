package modelo;

public class ContratoFactory {


	public ContratoFactory() {
		// TODO Auto-generated constructor stub
	}

	public Contrato getContrato(Persona titular, Domicilio domicilio, PaqueteServicios paqueteServicios) {
		if (titular!=null)
				return new Contrato(titular,domicilio,paqueteServicios);
		return null;
	}

}

package modelo;

public class ContratoFactory {


	public ContratoFactory() {
		// TODO Auto-generated constructor stub
	}

	public Contrato getContrato(Persona titular, Domicilio domicilio, IServicio paqueteServicios) {
		if (titular!=null)
				return new Contrato(titular,domicilio,paqueteServicios);
		return null;
	}

}

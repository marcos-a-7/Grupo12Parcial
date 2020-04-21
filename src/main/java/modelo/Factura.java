package modelo;

public class Factura {
	private IServicio paqueteServicios;
	private Persona persona;
	private Domicilio domicilio;
	
	public Factura(Persona persona, Domicilio domicilio, IServicio paqueteServicios) {
		this.persona = persona;
		this.domicilio = domicilio;
		this.paqueteServicios = paqueteServicios;
	}
	
}

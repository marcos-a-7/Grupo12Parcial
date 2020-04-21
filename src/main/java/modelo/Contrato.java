package modelo;

public class Contrato {
	private static int generadorIdContrato = 1;
	private int idContrato;
	private Persona titular;
	private Domicilio domicilio;
	private IServicio paqueteServicios;
	
	public Contrato() {
		this.idContrato = generadorIdContrato++;
	}
	
	public int getIdContrato() {
		return idContrato;
	}
	public void setIdContrato(int idContrato) {
		this.idContrato = idContrato;
	}
	public Persona getTitular() {
		return titular;
	}
	public void setTitular(Persona titular) {
		this.titular = titular;
	}
	public Domicilio getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}
	public IServicio getPaqueteServicios() {
		return paqueteServicios;
	}
	public void setPaqueteServicios(IServicio paqueteServicios) {
		this.paqueteServicios = paqueteServicios;
	}
}

package modelo;

/**
 * @author grupo12
 *<b> la clase contrato guarda los datos de la persona y del paquete de servicio, tambien puede generar una factura</b>
 */
public class Contrato {
	private static int generadorIdContrato = 1;
	private int idContrato;
	private Persona titular;
	private Domicilio domicilio;
	private PaqueteServicios paqueteServicios;
	
	
	
	public Contrato(Persona titular, Domicilio domicilio, PaqueteServicios paqueteServicios) {
		this.idContrato = generadorIdContrato++;
		this.titular = titular;
		this.domicilio = domicilio;
		this.paqueteServicios = paqueteServicios;
	}
	public int getIdContrato() {
		return idContrato;
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
	public PaqueteServicios getPaqueteServicios() {
		return paqueteServicios;
	}
	public void setPaqueteServicios(PaqueteServicios paqueteServicios) {
		this.paqueteServicios = paqueteServicios;
	}
	/**
	 * GetFactura<br>
	 * <b>Crea una factura y la devuelve</b>
	 *
	 */
	public Factura getFactura() {
		Factura factura = null;
		factura = new Factura(idContrato,titular,domicilio,paqueteServicios);
		return factura;
	}
	

}

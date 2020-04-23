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
	public void addCelulares(int cantCelu) {
		int i;
		for (i = 0; i < cantCelu; i++)
			this.paqueteServicios.addCelular(new Celular());
	}
	public void addTelefonos(int cantTel) {
		int i;
		for (i = 0; i < cantTel; i++)
			this.paqueteServicios.addTelefono(new Telefono());
	}
	public void addCables(int cantCables) {
		int i;
		for (i = 0; i < cantCables; i++)
			this.paqueteServicios.addCable(new Cable());
	}
	public void eliminaCelulare(int numeroCelular) {
		this.paqueteServicios.eliminaCelular(numeroCelular);
	}
	public void eliminaTelefonos(int numeroTelefono) {
		this.paqueteServicios.eliminaTelefono(numeroTelefono);
	}
	public void eliminaCables(int cantCables) {
		this.paqueteServicios.eliminaCable();
	}
	//recibe un tipo de internet valido
	public void cambiaInternet(String tipoInternet) {
		if (tipoInternet.equals("100")) {
			paqueteServicios.setInternet(Internet100.getInstance());
		} else if (tipoInternet.equals("500")) {
			paqueteServicios.setInternet(Internet500.getInstance());
		}
	}
}

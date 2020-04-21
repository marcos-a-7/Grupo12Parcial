package modelo;

public class Factura implements Cloneable {
	private int idContrato;
	private IServicio paqueteServicios;
	private Persona persona;
	private Domicilio domicilio;

	public Factura(int idContrato, Persona persona, Domicilio domicilio, IServicio paqueteServicios) {
		this.idContrato = idContrato;
		this.persona = persona;
		this.domicilio = domicilio;
		this.paqueteServicios = paqueteServicios;
	}

	public String imprimeFactura() {
		StringBuilder sb = new StringBuilder();
		sb.append("Numero de contrato: " + this.idContrato + "\n");
		sb.append(persona.toString());
		sb.append(this.paqueteServicios.detalle());
		sb.append("Costo total: " + this.paqueteServicios.getCostoTotal());
		return sb.toString();
	}

	@Override
	protected Factura clone() {
		Factura aux = null;
		try {
			aux = (Factura) super.clone();
			aux.domicilio = this.domicilio.clone();
			aux.persona = this.persona.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("No se pudo duplicar factura, debido a que es persona juridica");
		}
		return aux;

	}
}

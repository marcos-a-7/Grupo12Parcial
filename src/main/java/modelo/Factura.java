package modelo;

import clientes.Domicilio;
import clientes.Persona;
import servicios.PaqueteServicios;

/**
 * @author Grupo12
 *La clase factura implementa la interfase cloneable, se encarga de generar los datos de la factura e implementa el motodo clone()<br>
 */
public class Factura implements Cloneable {
	private int idContrato;
	private PaqueteServicios paqueteServicios;
	private Persona persona;
	private Domicilio domicilio;

	public Factura(int idContrato, Persona persona, Domicilio domicilio, PaqueteServicios paqueteServicios) {
		this.idContrato = idContrato;
		this.persona = persona;
		this.domicilio = domicilio;
		this.paqueteServicios = paqueteServicios;
	}

	public int getIdContrato() {
		return idContrato;
	}
	public PaqueteServicios getPaqueteServicios() {
		return paqueteServicios;
	}
	public Persona getPersona() {
		return persona;
	}
	public Domicilio getDomicilio() {
		return domicilio;
	}
	public double getCostoFinal() {
		return this.paqueteServicios.getCostoBase()*this.persona.getTasa();
	}
	/**
	 * Imprime la factura de un contrato<br>
	 * @return retorna un string con la factura del contrato<br>
	 */
	public String imprimeFactura() {
		StringBuilder sb = new StringBuilder();
		sb.append("Numero de contrato: " + this.idContrato + "\n");
		sb.append(persona.toString());
		sb.append(this.paqueteServicios.detalle());
		sb.append("Costo basico: " + this.paqueteServicios.getCostoBase());
		sb.append("Aplicando tasas (descuentos/impuestos) Costo Final: "+this.getCostoFinal());
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
			System.out.println("No se pudo duplicar factura, debido a que es persona juridica\n");
		}
		return aux;
	}
}

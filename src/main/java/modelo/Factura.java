package modelo;

import clientes.Domicilio;
import clientes.Persona;
import servicios.PaqueteServicios;

/**
 * @author Grupo12<br>
 *         <b> La clase factura implementa la interfase cloneable, se encarga de
 *         generar los datos de la factura e implementa el motodo
 *         clone()</b><br>
 */
public class Factura implements Cloneable {
	private int idContrato, mes;
	private PaqueteServicios paqueteServicios;
	private Persona persona;
	private Domicilio domicilio;
	private boolean pagada = false;

	public Factura(int idContrato, Persona persona, Domicilio domicilio, PaqueteServicios paqueteServicios, int mes) {
		this.idContrato = idContrato;
		this.persona = persona;
		this.domicilio = domicilio;
		this.paqueteServicios = paqueteServicios;
		this.mes = mes;
	}

	public int getIdContrato() {
		return idContrato;
	}

	public int getMes() {
		return mes;
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
		return this.paqueteServicios.getCostoBase() * this.persona.getTasa(this.idContrato);
		// MODIFICAR TASA DEPENDE DEL ESTADO
	}

	public boolean isPagada() {
		return pagada;
	}
	
	public void pagar() {
		this.pagada = true;
	}

	/**
	 * Imprime la factura de un contrato<br>
	 * 
	 * @return retorna un string con la factura del contrato<br>
	 */
	public String imprimeFactura() {
		StringBuilder sb = new StringBuilder();
		sb.append("Numero de contrato: " + this.idContrato + " Mes: " + this.mes + "\n");
		sb.append(persona.toString());
		sb.append(this.paqueteServicios.detalle());
		sb.append("Costo basico: " + this.paqueteServicios.getCostoBase() + "\n");
		sb.append("Aplicando tasas (descuentos/impuestos) Costo Final: " + this.getCostoFinal() + "\n");
		// MODIFICAR TASA DEPENDE DEL ESTADO
		return sb.toString();
	}

	@Override
	public Factura clone() {
		Factura aux = null;
		try {
			aux = (Factura) super.clone();
			aux.domicilio = this.domicilio.clone();
			aux.persona = this.persona.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("No se pudo duplicar factura, debido a que es persona juridica\n");
			aux = null;
		}
		return aux;
	}
}

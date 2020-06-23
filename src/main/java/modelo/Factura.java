package modelo;

import java.io.Serializable;

import clientes.Domicilio;
import servicios.PaqueteServicios;

/**
 * @author Grupo12<br>
 *         <b> La clase factura implementa la interfase cloneable, se encarga de
 *         generar los datos de la factura e implementa el motodo
 *         clone()</b><br>
 */
public class Factura implements Cloneable, Serializable {
	private int idContrato, mes;
	private PaqueteServicios paqueteServicios;
	private String nombrePersona;
	private int identificador;
	private double tasa;
	private Domicilio domicilio;
	private boolean pagada = false;

	public Factura(int idContrato, String nombrePersona, int identificador, double tasa, Domicilio domicilio,
			PaqueteServicios paqueteServicios, int mes) {
		this.idContrato = idContrato;
		this.nombrePersona = nombrePersona;
		this.identificador = identificador;
		this.tasa = tasa;
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

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public double getCostoFinal() {
		return this.paqueteServicios.getCostoBase() * tasa;
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
		sb.append("Titular: " + this.nombrePersona + " DNI/Identifcador: " + this.identificador + "\n");
		sb.append(this.paqueteServicios.detalle());
		sb.append("Costo basico: " + this.paqueteServicios.getCostoBase() + "\n");
		sb.append("Aplicando tasas (descuentos/impuestos) Costo Final: " + this.getCostoFinal() + "\n");
		return sb.toString();
	}

	@Override // NO se que pasa cuando clonas un string si requiere llamada a clone
	public Factura clone() throws CloneNotSupportedException {
		Factura aux = null;

		aux = (Factura) super.clone();
		aux.domicilio = this.domicilio.clone();
		aux.paqueteServicios = (PaqueteServicios) this.paqueteServicios.clone();

		return aux;
	}

	@Override
	public String toString() {
		if (isPagada()) {
			return domicilio.toString() + " mes: " + mes + " pagada";
		} else {
			return domicilio.toString() + " mes: " + mes + " debida";
		}
	}

}

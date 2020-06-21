package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

import util.Util;

public class AFIP extends Observable implements Serializable, Runnable {
	Empresa empresa;
	ArrayList<Factura> facturas;
	
	public AFIP(Empresa empresa) {
		this.empresa = empresa;
	}
	
	
	public ArrayList<Factura> getFacturas() {
		return facturas;
	}
	public void setFacturas(ArrayList<Factura> facturas) {
		this.facturas = facturas;
	}
	/**
	 * Genera un reporte
	 * 
	 * @return retorna un string con la cantidad de facturas pagadas y las ganancias de la empresa hasta la visita<br>
	 */
	public String reporte() {
		int pagadas = 0, ganancias = 0;
		Factura factura = null;
		StringBuilder sb = null;
		if (facturas.isEmpty()) {
			sb = new StringBuilder();
			Iterator<Factura> it = this.facturas.iterator();
			while (it.hasNext()) {
				factura = it.next();
				if(factura.isPagada()) {
					pagadas++;
					ganancias += factura.getCostoFinal();
				}
			}
		}
		sb.append("REPORTE\n");
		sb.append("Cantidad de facturas emitidas: " + this.facturas.size() + "\n");
		sb.append("Cantidad de facturas pagadas: " + pagadas + "\n");
		sb.append("Ganancias: " + ganancias + "\n");
		return sb.toString();
	}
	
	public void run() {
		//CONDICION DE LA VENTANA
		Util.espera(60000); //1 minuto
		
	}
}

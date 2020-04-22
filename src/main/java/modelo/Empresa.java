package modelo;


import java.util.ArrayList;
import java.util.Iterator;

public class Empresa {
	String nombre;
	ArrayList<Contrato> contratos = new ArrayList<Contrato>();
	
	public Empresa(String nombre) {
		this.nombre = nombre;
	}
	
	public void addContrato(Contrato contrato) {
		contratos.add(contrato);
	}
	
	public Contrato buscaContrato(int id) {
		Contrato contrato = null;
		
		Iterator<Contrato> it = contratos.iterator();
		
		
		return contrato;
	}
	
	public String reporte() {
		Contrato aux = null;
		StringBuilder sb = null;
		if(contratos!=null) {
			sb = new StringBuilder();
			Iterator<Contrato> it = this.contratos.iterator();
			while(it.hasNext()) {
				aux = it.next();
				sb.append(aux.getFactura().imprimeFactura());
			}
		}
		return sb.toString();
	}
	
	public String enlistarFacturas() {
		Contrato aux = null;
		Factura factura = null;
		StringBuilder sb = null;
		if(contratos!=null) {
			sb = new StringBuilder();
			Iterator<Contrato> it = this.contratos.iterator();
			while(it.hasNext()) {
				aux = it.next();
				factura = aux.getFactura();
				sb.append("Contrato: " + factura.getIdContrato() + "Costo total: " + factura.getPaqueteServicios().getCostoBase() + "\n");
			}
		}
		return sb.toString();
	}

	
}

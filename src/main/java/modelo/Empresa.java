package modelo;


import java.util.ArrayList;
import java.util.Iterator;

public class Empresa {
	String nombre;
	ArrayList<Contrato> contratos = new ArrayList<Contrato>();
	
	public Empresa(String nombre) {
		this.nombre = nombre;
	}
	
	//MAL
	public void addContrato(Contrato contrato) {
		contratos.add(contrato);
	}
	//
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public ArrayList<Contrato> getContratos() {
		return contratos;
	}

	public Contrato buscaContrato(int id) {
		boolean encontre = false;
		Contrato contrato = null;
		Iterator<Contrato> it = contratos.iterator();
		while(it.hasNext() && encontre) {
			contrato = it.next();
			if(id==contrato.getIdContrato())
				encontre = true;
		}
		if(!encontre)
			contrato = null;
		return contrato;
	}
	
	public Contrato buscaContrato(String calle, int numero) {
		boolean encontre = false;
		Domicilio domicilio = new Domicilio(calle,numero);
		Contrato contrato = null;
		Iterator<Contrato> it = contratos.iterator();
		while(it.hasNext() && encontre) {
			contrato = it.next();
			if(contrato.getDomicilio().equals(domicilio))
				encontre = true;
		}
		if(!encontre)
			contrato = null;
		return contrato;
	}
	
	public ArrayList<Contrato> buscaContratosTitular(String nombre, int dni) {
		ArrayList<Contrato> contratosTitular = new ArrayList<Contrato>();
		Contrato contrato = null;
		Persona titular = null;
		Iterator<Contrato> it = contratos.iterator();
		while(it.hasNext()) {
			contrato = it.next();
			titular = contrato.getTitular();
			if(titular.getNombre().equals(nombre) && (titular.getDni()==dni))
				contratosTitular.add(contrato);
		}
		if(contratosTitular.isEmpty())
			contratosTitular = null;
		return contratosTitular;
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

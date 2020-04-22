package modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class PaqueteServicios {
	Internet internet;
	ArrayList<Celular> celulares = new ArrayList<Celular>();
	ArrayList<Telefono> telefonos = new ArrayList<Telefono>();
	ArrayList<Cable> cables = new ArrayList<Cable>();

	public PaqueteServicios(Internet internet) {
		this.internet = internet;
	}

	public PaqueteServicios() {

	}

	public void setInternet(Internet internet) {
		this.internet = internet;
	}

	public Internet getInternet() {
		return internet;
	}

	public ArrayList<Celular> getCelulares() {
		return celulares;
	}

	public ArrayList<Telefono> getTelefonos() {
		return telefonos;
	}

	public ArrayList<Cable> getCables() {
		return cables;
	}

	public void addCelular(Celular celular) {
		celulares.add(celular);
	}

	public void addTelefono(Telefono telefono) {
		telefonos.add(telefono);
	}

	public void addCable(Cable cable) {
		cables.add(cable);
	}

	public int cantidadCables() {
		return cables.size();
	}

	public int cantidadTelefonos() {
		return telefonos.size();
	}

	public int cantidadCelulares() {
		return celulares.size();
	}

	public Celular buscaCelular(int num) {
		Celular aux = null;
		Iterator<Celular> it = celulares.iterator();
		aux = it.next();
		while (it.hasNext() && aux.getNumeroCelular() != num) {
			aux = it.next();
		}
		return aux;
	}

	public void eliminaCelular(int num) {
		Celular aux;
		aux = this.buscaCelular(num);
		if (aux != null)
			celulares.remove(aux);
	}

	public Telefono buscaTelefono(int num) {
		Telefono aux = null;
		Iterator<Telefono> it = telefonos.iterator();
		aux = it.next();
		while (it.hasNext() && aux.getNumeroTelefono() != num) {
			aux = it.next();
		}
		return aux;
	}

	public void eliminaTelefono(int num) {
		Telefono aux;
		aux = this.buscaTelefono(num);
		if (aux != null)
			telefonos.remove(aux);
	}

	public void eliminaCable() {
		if (cables.size() > 0)
			cables.remove(cables.size() - 1);
	}

	public double getCostoBase() {
		double costoBase = 0;
		Iterator<Cable> it1 = cables.iterator();
		Iterator<Telefono> it2 = telefonos.iterator();
		Iterator<Celular> it3 = celulares.iterator();

		while (it1.hasNext()) {
			costoBase += it1.next().getCosto();
		}

		while (it2.hasNext()) {
			costoBase += it2.next().getCosto();
		}

		while (it3.hasNext()) {
			costoBase += it3.next().getCosto();
		}

		return costoBase;
	}

	public String detalle() {

		StringBuilder sb = new StringBuilder();
		Iterator<Cable> it1 = cables.iterator();
		Iterator<Telefono> it2 = telefonos.iterator();
		Iterator<Celular> it3 = celulares.iterator();

		sb.append(internet.detalle());

		while (it1.hasNext()) {
			sb.append(it1.next().detalle());
		}

		while (it2.hasNext()) {
			sb.append(it2.next().detalle());
		}

		while (it3.hasNext()) {
			sb.append(it3.next().detalle());
		}

		return sb.toString();
	}

}

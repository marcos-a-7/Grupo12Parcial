package servicios;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Grupo12<br>
 *         <b> Se encarga de manejar todas las combinaciones de servicios en un
 *         conjunto</b><br>
 */
public class PaqueteServicios implements Cloneable, Serializable {
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

	/**
	 * Busca un celular segun un numero de celular<br>
	 * <b>Pre:</b>No tiene<br>
	 * <b>Post:</b>Devolvera un celular el cual tenga el numero ingresado en caso de
	 * no encontrarlo devolvera null<br>
	 * 
	 * @param num : Numero de celular<br>
	 * @return retorna celular o null<br>
	 */
	public Celular buscaCelular(int num) {
		Celular aux = null;
		boolean encontre = false;
		Iterator<Celular> it = celulares.iterator();
		while (it.hasNext() && !encontre) {
			aux = it.next();
			if (aux.getNumeroCelular() == num) {
				encontre = true;
			}
		}
		if (!encontre) {
			aux = null;
		}
		return aux;
	}

	/**
	 * Busca un celular segun un numero de celular y lo elimina<br>
	 * <b>Pre:</b>No tiene<br>
	 * <b>Post:</b>Eliminara un celular el cual tenga el numero ingresado en caso de
	 * no encontrarlo no realizara ninguna accion<br>
	 * 
	 * @param num : numero de celular<br>
	 */
	public void eliminaCelular(int num) {
		Celular aux;
		aux = this.buscaCelular(num);
		if (aux != null)
			celulares.remove(aux);
	}

	/**
	 * Busca un telefono segun un numero de telefono <br>
	 * <b>Pre:</b>No tiene<br>
	 * <b>Post:</b>Devolvera un telofno el cual tenga el numero ingresado en caso de
	 * no encontrarlo devolvera null<br>
	 * 
	 * @param num : Numero de telefono<br>
	 * @return retorna Telefono o null<br>
	 */
	public Telefono buscaTelefono(int num) {
		Telefono aux = null;
		boolean encontre = false;
		Iterator<Telefono> it = telefonos.iterator();

		while (it.hasNext() && !encontre) {
			aux = it.next();
			if (aux.getNumeroTelefono() == num) {
				encontre = true;
			}
		}
		if (!encontre) {
			aux = null;
		}
		return aux;
	}

	/**
	 * Busca un celular segun un numero de telefono y lo elimina<br>
	 * <b>Pre:</b>No tiene<br>
	 * <b>Post:</b>Eliminara un telefono el cual tenga el numero ingresado en caso
	 * de no encontrarlo no realizara ninguna accion<br>
	 * 
	 * @param num : numero de telefono<br>
	 */
	public void eliminaTelefono(int num) {
		Telefono aux;
		aux = this.buscaTelefono(num);
		if (aux != null)
			telefonos.remove(aux);
	}

	/**
	 * Elimina un cable en caso que tenga al menos uno<br>
	 */
	public void eliminaCable() {
		if (cables.size() > 0)
			cables.remove(cables.size() - 1);
	}

	/**
	 * @return retorna la suma de todos los costos incluidos en el paquete<br>
	 */
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

		return costoBase + internet.getCosto();
	}

	/**
	 * @return retorna un string con el detalle de cada servicio<br>
	 */
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

	@Override
	public PaqueteServicios clone() throws CloneNotSupportedException {
		PaqueteServicios aux = (PaqueteServicios) super.clone();
		aux.cables = (ArrayList<Cable>) this.cables.clone();
		aux.celulares = (ArrayList<Celular>) this.celulares.clone();
		aux.telefonos = (ArrayList<Telefono>) this.telefonos.clone();
		aux.internet = this.internet.clone();
		return aux;
	}

}

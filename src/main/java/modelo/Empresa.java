package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Observer;
import java.util.Map.Entry;
import java.util.Set;

import clientes.Domicilio;
import clientes.Persona;
import clientes.PersonaFactory;
import excepciones.ImposibleCrearPaqueteException;
import excepciones.MedioPagoInvalidoException;
import excepciones.NumeroInvalidoException;
import excepciones.TipoNoEncontradoException;
import excepciones.TipoPersonaInvalidoException;
import servicios.PaqueteServicios;
import servicios.PaqueteServiciosFactory;

/**
 * @author Grupo12 <br>
 *         <b>Se encarga de realizar los contratos y los guarda en el atributo
 *         contratos de tipo ArrayList, tambien guarda el nombre de la
 *         empresa</b><br>
 */

public class Empresa {
	String nombre;
	// ArrayList<Persona> = new ArrayList<Persona>();
	HashMap<Integer, Persona> personas = new HashMap<Integer, Persona>();

	public Empresa(String nombre) {
		this.nombre = nombre;
	}

	public HashMap<Integer, Persona> getPersonas() {
		return personas;
	}

	public void addPersona(String tipoPersona, String nombre, int identificador) {
		try {
			Persona persona = PersonaFactory.getPersona(tipoPersona, nombre, identificador);

			this.personas.put(identificador, persona);
		} catch (NumeroInvalidoException e) {
			// RESOLVER
		} catch (TipoPersonaInvalidoException e) {
			// RESOLVER
		}
	}

	public void removePersona(int identificador) {
		this.personas.remove(identificador);
	}

	public void removePersona(int identificador, Persona persona) {
		this.personas.remove(identificador, persona);
	}

	public Persona buscaPersona(int identificador) {
		return this.personas.get(identificador);
	}



	private Contrato buscaContrato(String calle, int numero) {
		boolean encontre = false;
		Contrato contrato = null;
		Set<Entry<Integer, Persona>> entrySet = personas.entrySet();
		Iterator<Entry<Integer, Persona>> it = entrySet.iterator();
		while (it.hasNext() && !encontre) {
			contrato = it.next().getValue().buscaContrato(calle, numero);
		}
		if (!encontre)
			contrato = null;
		return contrato;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	/**
	 * Genera un reporte con todos los contratos
	 * 
	 * @return retorna un string con la impresion correspondiente a cada factura<br>
	 */
	// DELEGAR
	public String enlistarFacturas() {
		Contrato aux = null;
		StringBuilder sb = null;
		if (contratos != null) {
			sb = new StringBuilder();
			Iterator<Contrato> it = this.contratos.iterator();
			while (it.hasNext()) {
				aux = it.next();
				sb.append(aux.getFactura().imprimeFactura() + "\n");
			}
		}
		return sb.toString();
	}

	/**
	 * Genera una lista de las facturas
	 * 
	 * @return retorna un string con el id de contrato y el costo total final de
	 *         cada uno de ellos<br>
	 */
	// DELEGAR
	public String reporte() {
		Contrato aux = null;
		Factura factura = null;
		StringBuilder sb = null;
		if (contratos != null) {
			sb = new StringBuilder();
			while (it.hasNext()) {
				aux = it.next();
				factura = aux.getFactura();
				sb.append("Contrato: " + factura.getIdContrato() + "   Costo total: " + factura.getCostoFinal() + "\n");
			}
		}
		return sb.toString();
	}

	public void facturacion(int mes) {

		Persona persona;

		Set<Entry<Integer, Persona>> entrySet = personas.entrySet();
		Iterator<Entry<Integer, Persona>> it = entrySet.iterator();
		while (it.hasNext()) {
			persona = it.next().getValue();
			persona.facturar(mes);
			persona.actualizaEstado();
		}

	}

}

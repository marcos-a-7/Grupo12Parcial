package modelo;

import java.util.ArrayList;
import java.util.Iterator;

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
 * @author Grupo12
 *<b>Se encarga de realizar los contratos y los guarda en el atributo contratos de tipo ArrayList, tambien guarda el nombre de la empresa</b><br>
 */


public class Empresa {
	String nombre;
	ArrayList<Contrato> contratos = new ArrayList<Contrato>();

	public Empresa(String nombre) {
		this.nombre = nombre;
	}


	/**
	 * Add contrato<br>
	 * crea un contrato y lo agrega al array list<br>
	 * <b>Pre: </b> el dni debe ser numero positivo<br>
	 * <b>Post: </b> crea una persona, un domicilio, un paquete de servicios y un contrato y luego lo guarda en el arraylist, en caso de que el tipo de persona, el nombre, el medio de pago, la calle o el numero de calle sea invalido, lanzara una excepcion correspondiente con su mensaje correspondiente en cada caso especificando el error y lo mostrara por pantalla <br>
	 * @param tipoPersona : puede ser juridica o fisica en la poscondicion aclara que pasa si no se ingresa una correcta
	 * @param nombre : el nombre de la persona
	 * @param dni : el dni de la persona
	 * @param medioPago : por que medio va a pagar si por cheque efectivo o tarjeta
	 * @param calle : nombre de la calle del domicilio
	 * @param numeroCalle : numero del domicilio
	 * @param tipoInternet : el tipo de internet a contratar 100 o 500
	 * @param cantCelu : La cantidad de celulares a contratar
	 * @param cantTel : La cantidad de telefonos a contratar
	 * @param cantCable : La cantidad de cable a contratar
	 */
	public void addContrato(String tipoPersona, String nombre, int dni, String medioPago, String calle, int numeroCalle,
			String tipoInternet, int cantCelu, int cantTel, int cantCable) {
		Contrato auxContrato;
		try {
			Persona persona = PersonaFactory.getPersona(tipoPersona, nombre, dni, medioPago);
			Domicilio domicilio = new Domicilio(calle, numeroCalle);
			PaqueteServicios paqueteServicios = PaqueteServiciosFactory.getPaqueteServicios(tipoInternet, cantCelu,
					cantTel, cantCable);
			auxContrato = this.buscaContrato(calle, numeroCalle);
			if(auxContrato == null)
				this.contratos.add(ContratoFactory.getContrato(persona, domicilio, paqueteServicios));
		} catch (TipoNoEncontradoException e) {
			System.out.println(e.getMessage() +", tipo solicitado: " + e.getTipo());
		} catch (ImposibleCrearPaqueteException e) {
			System.out.println(e.getMessage());
		} catch (MedioPagoInvalidoException e) {
			this.addContrato(tipoPersona, nombre, dni, "Efectivo", calle, numeroCalle, tipoInternet, cantCelu, cantTel,
					cantCable);
			System.out.println(e.getMessage() + " se dejara por defecto en efectivo");
		} catch (NumeroInvalidoException e) {
			System.out.println(e.getMessage());
		} catch (TipoPersonaInvalidoException e) {
			System.out.println(e.getMessage());
		}
	}

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
		while (it.hasNext() && !encontre) {
			contrato = it.next();
			if (id == contrato.getIdContrato())
				encontre = true;
		}
		if (!encontre)
			contrato = null;
		return contrato;
	}

	public Contrato buscaContrato(String calle, int numero) {
		boolean encontre = false;
		Domicilio domicilio = null;
		Contrato contrato = null;
		Iterator<Contrato> it = contratos.iterator();
		while (it.hasNext() && !encontre) {
			contrato = it.next();
			domicilio = contrato.getDomicilio();
			if (domicilio.getCalle().equals(calle) && (domicilio.getNumero()==numero))
				encontre = true;
		}
		if (!encontre)
			contrato = null;
		return contrato;
	}

	public ArrayList<Contrato> buscaContratosTitular(int dni) {
		ArrayList<Contrato> contratosTitular = new ArrayList<Contrato>();
		Contrato contrato = null;
		Iterator<Contrato> it = contratos.iterator();
		while (it.hasNext()) {
			contrato = it.next();
			if (contrato.getTitular().getDni() == dni)
				contratosTitular.add(contrato);
		}
		if (contratosTitular.isEmpty())
			contratosTitular = null;
		return contratosTitular;
	}

	public void eliminaContrato(int id) {
		Contrato contrato = this.buscaContrato(id);
		if (contrato != null)
			this.contratos.remove(contrato);
	}
	
	public void eliminaContrato(String calle, int numero) {
		Contrato contrato = this.buscaContrato(calle, numero);
		if (contrato != null)
			this.contratos.remove(contrato);
	}
	
	public void eliminaContratosTitular(int dni) {
		Contrato contrato;
		ArrayList<Contrato> contratosTitular = this.buscaContratosTitular(dni);
		if (contratosTitular != null) {
			Iterator<Contrato> it = contratosTitular.iterator();
			while(it.hasNext()) {
				contrato = it.next();
				this.contratos.remove(contrato);
			}
		}
	}
	
	public String reporte() {
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

	public String enlistarFacturas() {
		Contrato aux = null;
		Factura factura = null;
		StringBuilder sb = null;
		if (contratos != null) {
			sb = new StringBuilder();
			Iterator<Contrato> it = this.contratos.iterator();
			while (it.hasNext()) {
				aux = it.next();
				factura = aux.getFactura();
				sb.append("Contrato: " + factura.getIdContrato() + "   Costo total: "
						+ factura.getCostoFinal() + "\n");
			}
		}
		return sb.toString();
	}
}

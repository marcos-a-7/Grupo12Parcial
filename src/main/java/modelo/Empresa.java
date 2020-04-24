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
 * @author Grupo12 <br>
 *         <b>Se encarga de realizar los contratos y los guarda en el atributo
 *         contratos de tipo ArrayList, tambien guarda el nombre de la
 *         empresa</b><br>
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
	 * <b>Pre: </b> la calle y el numero de calle deben ser validos<br>
	 * <b>Post: </b> crea una persona, un domicilio, un paquete de servicios para
	 * crear contrato y luego lo guarda en el arraylist, en caso de que el tipo de
	 * persona, el nombre o el medio de pago sean invalidos captara la excepcion
	 * correspondiente y la resolvera. Si se ingreso una cantidad de Celulares,
	 * Telefonos o Lineas de cable negativas se consideraran como 0 <br>
	 * 
	 * @param tipoPersona  : puede ser juridica o fisica en la poscondicion aclara
	 *                     que pasa si no se ingresa una correcta
	 * @param nombre       : el nombre de la persona
	 * @param dni          : el dni de la persona
	 * @param medioPago    : por que medio va a pagar si por cheque efectivo o
	 *                     tarjeta
	 * @param calle        : nombre de la calle del domicilio
	 * @param numeroCalle  : numero del domicilio
	 * @param tipoInternet : el tipo de internet a contratar 100 o 500
	 * @param cantCelu     : La cantidad de celulares a contratar
	 * @param cantTel      : La cantidad de telefonos a contratar
	 * @param cantCable    : La cantidad de cable a contratar
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
			if (auxContrato == null)
				this.contratos.add(ContratoFactory.getContrato(persona, domicilio, paqueteServicios));
		} catch (TipoNoEncontradoException e) {
			System.out.println(e.getMessage() + ", tipo solicitado: " + e.getTipo());
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

	/**
	 * Busca un contrato a traves de un id<br>
	 * <b>Pre: </b> no tiene<br>
	 * <b>Post: </b> devolvera el contrato de dicho id ingresado, si no lo encuentra
	 * devolvera null<br>
	 * 
	 * @param id : es el id el cual esta asociado a un contrato<br>
	 * @return retorna un contrato o null <br>
	 */
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

	/**
	 * Busca un contrato a traves de una calle y el numero de direccion<br>
	 * <b>Pre: </b> Debe ingresar una calle no nula<br>
	 * <b>Post: </b> devolvera el contrato correspondiente a la calle y numero
	 * ingresado, si no lo encuentra devolvera null<br>
	 * 
	 * @param calle  : La calle del domicilio de la persona
	 * @param numero : El numero de la calle del domicilio de la persona
	 * @return retorna un contrato o null<br>
	 */
	public Contrato buscaContrato(String calle, int numero) {
		boolean encontre = false;
		Domicilio domicilio = null;
		Contrato contrato = null;
		Iterator<Contrato> it = contratos.iterator();
		while (it.hasNext() && !encontre) {
			contrato = it.next();
			domicilio = contrato.getDomicilio();
			if (domicilio.getCalle().equals(calle) && (domicilio.getNumero() == numero))
				encontre = true;
		}
		if (!encontre)
			contrato = null;
		return contrato;
	}

	/**
	 * Busca un contrato a partir de un dni<br>
	 * <b>Pre: </b> no tiene<br>
	 * <b>Post: </b> Devolvera el contrato correspondiente al dni ingresado, si no
	 * devolvera null<br>
	 * 
	 * @param dni : el dni del titular del contrato buscado
	 * @return retorna un contrato o null
	 */

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

	/**
	 * Elimina un contrato segun el id <b>Pre: </b> no tiene<br>
	 * <b>Post: </b> remueve el contrato si el id corresponde a uno existente, de lo
	 * contrario no realiza ninguna accion<br>
	 * 
	 * @param id el id del contrato a eliminar
	 */
	public void eliminaContrato(int id) {
		Contrato contrato = this.buscaContrato(id);
		if (contrato != null)
			this.contratos.remove(contrato);
	}

	/**
	 * Elimina un contrato segun la calle y el numero de domicilio <b>Pre: </b> no
	 * tiene<br>
	 * <b>Post: </b> remueve el contrato si la calle y el numero de la calle
	 * corresponden a uno existente, de lo contrario no realiza ninguna accion<br>
	 * 
	 * @param calle  : la calle del domicilio del titular<br>
	 * @param numero : el numero del domicilio del titular <br>
	 */
	public void eliminaContrato(String calle, int numero) {
		Contrato contrato = this.buscaContrato(calle, numero);
		if (contrato != null)
			this.contratos.remove(contrato);
	}

	/**
	 * Elimina un contrato segun el id del titular <b>Pre: </b> no tiene<br>
	 * <b>Post: </b> remueve todos los contratos si el DNI corresponde a uno
	 * existente, de lo contrario no realiza ninguna accion<br>
	 * 
	 * @param dni : DNI del titular correspondiente
	 */
	public void eliminaContratosTitular(int dni) {
		Contrato contrato;
		ArrayList<Contrato> contratosTitular = this.buscaContratosTitular(dni);
		if (contratosTitular != null) {
			Iterator<Contrato> it = contratosTitular.iterator();
			while (it.hasNext()) {
				contrato = it.next();
				this.contratos.remove(contrato);
			}
		}
	}

	/**
	 * Genera un reporte con todos los contratos
	 * 
	 * @return retorna un string con la impresion correspondiente a cada factura<br>
	 */
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
	public String reporte() {
		Contrato aux = null;
		Factura factura = null;
		StringBuilder sb = null;
		if (contratos != null) {
			sb = new StringBuilder();
			Iterator<Contrato> it = this.contratos.iterator();
			while (it.hasNext()) {
				aux = it.next();
				factura = aux.getFactura();
				sb.append("Contrato: " + factura.getIdContrato() + "   Costo total: " + factura.getCostoFinal() + "\n");
			}
		}
		return sb.toString();
	}
}

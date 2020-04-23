package modelo;

import java.util.ArrayList;
import java.util.Iterator;

import excepciones.ImposibleCrearPaqueteException;
import excepciones.MedioPagoInvalidoException;
import excepciones.NumeroInvalidoException;
import excepciones.TipoNoEncontradoException;
import excepciones.TipoPersonaInvalidoException;
/**
 * @author Grupo12
 *<b>Se encarga de realizar los contratos y los guarda en el atributo contratos de tipo ArrayList, tambien guarda el nombre de la empresa</b>
 */
public class Empresa {
	String nombre;
	ArrayList<Contrato> contratos = new ArrayList<Contrato>();

	public Empresa(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Add contrato<br>
	 * crea un contrato y lo agrega al array list
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
		try {
			Persona persona = PersonaFactory.getPersona(tipoPersona, nombre, dni, medioPago);
			Domicilio domicilio = new Domicilio(calle, numeroCalle);
			PaqueteServicios paqueteServicios = PaqueteServiciosFactory.getPaqueteServicios(tipoInternet, cantCelu,
					cantTel, cantCable);
			this.contratos.add(ContratoFactory.getContrato(persona, domicilio, paqueteServicios));
		} catch (TipoNoEncontradoException e) {
			System.out.println(e.getMessage() + e.getTipo());
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
	 * <b>Post: </b> devolvera el contrato de dicho id ingresado, si no lo encuentra devolvera null<br>
	 * @param id : es el id el cual esta asociado a un contrato<br>
	 * @return retorna un contrato o null <br>
	 */
	public Contrato buscaContrato(int id) {
		boolean encontre = false;
		Contrato contrato = null;
		Iterator<Contrato> it = contratos.iterator();
		while (it.hasNext() && encontre) {
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
	 * <b>Post: </b> devolvera el contrato correspondiente a la calle y numero ingresado, si no lo encuentra devolvera null<br>
	 * @param calle : La calle del domicilio de la persona 
	 * @param numero : El numero de la calle del domicilio de la persona
	 * @return retorna un contrato o null<br>
	 */
	public Contrato buscaContrato(String calle, int numero) {
		boolean encontre = false;
		Domicilio domicilio = new Domicilio(calle, numero);
		Contrato contrato = null;
		Iterator<Contrato> it = contratos.iterator();
		while (it.hasNext() && encontre) {
			contrato = it.next();
			if (contrato.getDomicilio().equals(domicilio))
				encontre = true;
		}
		if (!encontre)
			contrato = null;
		return contrato;
	}

	/**
	 * Busca un contrato a partir de un nombre y un dni<br>
	 * <b>Pre: </b> Debe ingresar un nombre no nulo y un dni no nulo positivo<br>
	 * <b>Post: </b> Devolvera el contrato correspondiente al nombre y el dni ingresado, si no devolvera null<br>
	 * @param nombre : el nombre del titular del contrato buscado
	 * @param dni : el deni del titular del contrato buscado
	 * @return retorna un contrato o null
	 */
	public ArrayList<Contrato> buscaContratosTitular(String nombre, int dni) {
		ArrayList<Contrato> contratosTitular = new ArrayList<Contrato>();
		Contrato contrato = null;
		Persona titular = null;
		Iterator<Contrato> it = contratos.iterator();
		while (it.hasNext()) {
			contrato = it.next();
			titular = contrato.getTitular();
			if (titular.getNombre().equals(nombre) && (titular.getDni() == dni))
				contratosTitular.add(contrato);
		}
		if (contratosTitular.isEmpty())
			contratosTitular = null;
		return contratosTitular;
	}

	/**
	 * Genera un reporte con todos los contratos
	 * @return retorna un string con cada impresion correspondiente a cada factura<br>
     */
	public String reporte() {
		Contrato aux = null;
		StringBuilder sb = null;
		if (contratos != null) {
			sb = new StringBuilder();
			Iterator<Contrato> it = this.contratos.iterator();
			while (it.hasNext()) {
				aux = it.next();
				sb.append(aux.getFactura().imprimeFactura());
			}
		}
		return sb.toString();
	}

	
	/**
	 * Genera una lista de las facturas
	 * @return retorna un string con toda la descripcion de cada contrato<br>
	 */
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
				sb.append("Contrato: " + factura.getIdContrato() + "Costo total: "
						+ factura.getPaqueteServicios().getCostoBase() + "\n");
			}
		}
		return sb.toString();
	}

}

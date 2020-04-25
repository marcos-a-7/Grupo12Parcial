package clientes;

import excepciones.MedioPagoInvalidoException;
import excepciones.NumeroInvalidoException;
import excepciones.TipoPersonaInvalidoException;

/**
 * @author Grupo12 <br>
 *         <b>Se encarga de crear una persona segun su tipo</b><br>
 *
 */
public class PersonaFactory {

	/**
	 * <b>Pre</b> No tiene<br>
	 * <b>Post</b> Devolvera una persona en caso de no poder lanzara una excepcion
	 * correspondiente a cada error <br>
	 * 
	 * @param tipo      : El tipo de la persona (juridica o Fisica) <br>
	 * @param nombre    : El nombre del titular <br>
	 * @param dni       : El DNI del titular<br>
	 * @param medioPago : El medio por el cual va a pagar el titular <br>
	 * @return Retorna una persona o arrojara una excepcion<br>
	 * @throws MedioPagoInvalidoException   : en caso de que el medio de pago sea
	 *                                      invalido<br>
	 * @throws NumeroInvalidoException      : en casi de que el numero de DNI sea
	 *                                      invalido<br>
	 * @throws TipoPersonaInvalidoException : En caso que el tipo de persona sea
	 *                                      invalido <br>
	 */
	public static Persona getPersona(String tipo, String nombre, int dni, String medioPago)
			throws MedioPagoInvalidoException, NumeroInvalidoException, TipoPersonaInvalidoException {
		Persona persona = null;
		MedioPago auxMedioPago = null;

		if (dni <= 0)
			throw new NumeroInvalidoException("El numero de dni es invalido, no puede ser negativo");

		if (medioPago == null)
			throw new MedioPagoInvalidoException("No se ingreso ningun medio de pago");
		else if (medioPago.equals("Tarjeta"))
			auxMedioPago = new Tarjeta();
		else if (medioPago.equals("Cheque"))
			auxMedioPago = new Cheque();
		else if (medioPago.equals("Efectivo"))
			auxMedioPago = new Efectivo();
		else
			throw new MedioPagoInvalidoException("Medio de pago ingresado no valido");

		if (tipo == null)
			throw new TipoPersonaInvalidoException("No se ingreso ningun tipo de persona");
		else if (tipo.equals("Fisica"))
			persona = new PersonaFisica(nombre, dni, auxMedioPago);
		else if (tipo.equals("Juridica"))
			persona = new PersonaJuridica(nombre, dni, auxMedioPago);
		else
			throw new TipoPersonaInvalidoException("Tipo de persona ingresado no valido");

		return persona;
	}

}
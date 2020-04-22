package modelo;

import Excepciones.MedioPagoInvalidoException;
import Excepciones.NumeroInvalidoException;
import Excepciones.TipoPersonaInvalidoException;

public class PersonaFactory {

	protected static Persona getPersona(String tipo, String nombre, int dni, String medioPago)
			throws MedioPagoInvalidoException, NumeroInvalidoException, TipoPersonaInvalidoException {
		Persona persona = null;
		MedioPago auxMedioPago = null;
		
		if (dni<=0)
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

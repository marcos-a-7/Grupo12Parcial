package clientes;

import java.io.Serializable;

import excepciones.ImposibleCrearContratoException;
import excepciones.ImposibleCrearPaqueteException;
import excepciones.MorosoException;
import modelo.Contrato;
import modelo.Factura;

public class MorosoState implements State, Serializable {
	Persona persona;

	public MorosoState(Persona persona) {
		this.persona = persona;
	}

	public double pagar(Factura factura) {
		double monto = 0;
		if (!factura.isPagada()) {
			monto = factura.getCostoFinal() * 1.3;
			factura.pagar();
		}
		return monto;
	}

	public void eliminaContrato(Contrato contrato) throws MorosoException {
		throw new MorosoException(persona.getNombre() + " es morosa y no se puede eliminar el contrato");

	}

	public void modificaContrato(Contrato contrato) throws MorosoException {
		throw new MorosoException(persona.getNombre() + " es morosa y no se puede modificar el contrato");

	}

	public void agregaContrato(String calle, int numeroCalle, String tipoInternet, int cantCelu, int cantTel,
			int cantCable, String medioPago) throws ImposibleCrearContratoException, ImposibleCrearPaqueteException {
		throw new MorosoException(persona.getNombre() + " es morosa y no se puede agregar el contrato");

	}

}

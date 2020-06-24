package clientes;

import java.io.Serializable;

import excepciones.ImposibleCrearContratoException;
import excepciones.ImposibleCrearPaqueteException;
import excepciones.MorosoException;
import modelo.Contrato;
import modelo.Factura;

/**
 * @author Grupo12 <br>
 *         <b>se guarda una referencia a la persona que posee dicho estado</b>
 *
 */
public class MorosoState implements State, Serializable {
	Persona persona;

	public MorosoState(Persona persona) {
		this.persona = persona;
	}

	/**
	 * pagar<br>
	 * paga una factura y devuelve la cantidad abonada<br>
	 * <b>Pre: </b> la factura no debe ser null<br>
	 * <b>Post: </b> devuelve la cantidad abonada si la factura no estaba pagada, si
	 * estaba pagada devuelve 0<br>
	 * 
	 * @param factura: no debe ser null <br>
	 */
	public double pagar(Factura factura) {
		double monto = 0;
		if (!factura.isPagada()) {
			monto = factura.getCostoFinal() * 1.3;
			factura.pagar();
		}
		return monto;
	}

	/**
	 * eliminaContrato<br>
	 * elimina el contrato de la persona<br>
	 * <b>Pre: </b> no tiene<br>
	 * <b>Post: </b> siempre lanza una excepcion MorosoException<br>
	 * 
	 * @param contrato : sin condiciones 
	 * @throws MorosoException 
	 */
	public void eliminaContrato(Contrato contrato) throws MorosoException {
		throw new MorosoException(persona.getNombre() + " es morosa y no se puede eliminar el contrato");

	}

	/**
	 * modificaContrato<br>
	 * devuelve true si el estado permite modificar el contrato<br>
	 * <b>Pre: </b> no tiene<br>
	 * <b>Post: </b> siempre lanza una excepcion MorosoException debido a que este
	 * estado no puede modificar contratos<br>
	 */
	public boolean modificaContrato() throws MorosoException {
		throw new MorosoException(persona.getNombre() + " es morosa y no se puede modificar el contrato");
	}

	/**
	 * modificaContrato<br>
	 * funcion para crear un contrato para la persona, siempre lanza la excepcion
	 * MorosoException dado que este estado no puede agregar contratos<br>
	 * <b>Pre: </b> no tiene<br>
	 * <b>Post: </b> siempre lanza una excepcion MorosoException<br>
	 * 
	 * @throws MorosoException
	 */
	public void agregaContrato(String calle, int numeroCalle, String tipoInternet, int cantCelu, int cantTel,
			int cantCable, String medioPago) throws ImposibleCrearContratoException, ImposibleCrearPaqueteException {
		throw new MorosoException(persona.getNombre() + " es morosa y no se puede agregar el contrato");

	}

}

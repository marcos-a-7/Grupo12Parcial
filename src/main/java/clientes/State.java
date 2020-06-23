package clientes;

import excepciones.ImposibleCrearContratoException;
import excepciones.ImposibleCrearPaqueteException;
import excepciones.MorosoException;
import excepciones.SinContratacionesException;
import modelo.Contrato;
import modelo.Factura;

public interface State {

	public double pagar(Factura factura) throws SinContratacionesException;

	public void eliminaContrato(Contrato contrato) throws MorosoException, SinContratacionesException;

	public void agregaContrato(String calle, int numeroCalle, String tipoInternet, int cantCelu, int cantTel,
			int cantCable, String medioPago) throws ImposibleCrearContratoException, ImposibleCrearPaqueteException;

	public boolean modificaContrato() throws MorosoException, SinContratacionesException;

}

package clientes;

/**
 * @author grupo12
 *Devuelve el incremento correspondiente al pagar por cheque
 */
public class Cheque extends MedioPago {
	@Override
	public double getTasaFisica() {
		return 1.1;
	}
	@Override
	public double getTasaJuridica() {
		return 1.15;
	}
}

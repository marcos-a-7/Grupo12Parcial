package clientes;

/**
 * @author Grupo12 el medio de pago tarjeta devuelve la tasa correspondiente
 *         para todos los tipos de persona<br>
 */
public class Tarjeta extends MedioPago {
	@Override
	public double getTasaFisica() {
		return 1;
	}

	@Override
	public double getTasaJuridica() {
		return 1.2;
	}
}

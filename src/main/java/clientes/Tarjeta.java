package clientes;

/**
 * @author Grupo12
 *el medio de pago tarjeta devuelve la tasa correspondiente para todos los tipos de persona<br>
 */
public class Tarjeta extends MedioPago {
	public double getTasaFisica() {
		return 1;
	}
	public double getTasaJuridica() {
		return 1.2;
	}
}

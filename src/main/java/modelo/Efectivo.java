package modelo;

/**
 * @author Grupo12
 *<b>Devuelve el descuento correspondiente</b>
 */
public class Efectivo extends MedioPago {
	@Override
	public double getTasaFisica() {
		return 0.8;
	}
	@Override
	public double getTasaJuridica() {
		return 0.9;
	}
}

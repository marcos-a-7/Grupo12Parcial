package modelo;

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

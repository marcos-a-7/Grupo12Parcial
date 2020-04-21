package modelo;

public class DecoradorCable extends DecoradorServicio {

	

	public DecoradorCable(IServicio servicioEncapsulado) {
		super(servicioEncapsulado);
	}

	public double getCosto() {
		return 250;
	}

	@Override
	public String detalle() {
		return super.detalle() + " Tv Cable: $" + this.getCosto() + "\n";
	}

}

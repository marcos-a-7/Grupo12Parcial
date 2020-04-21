package modelo;

public class DecoradorCable extends DecoradorServicio {

	public DecoradorCable() {
		// TODO Auto-generated constructor stub
	}

	public double getCosto() {
		// TODO Auto-generated method stub
		return 250;
	}

	@Override
	public String detalle() {
		// TODO Auto-generated method stub
		return super.detalle() + " Tv Cable: $" + this.getCosto() + "\n";
	}
	
}

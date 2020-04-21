package modelo;

public class Internet500 extends Internet {

	@Override
	public double getCosto() {
		return 1000;
	}

	@Override
	public String toString() {
		return "Internet100: " + this.getCosto();
	}

	public String detalle() {
		return super.detalle() + " 500: " + this.getCosto()
	}

}

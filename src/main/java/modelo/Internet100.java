package modelo;

public class Internet100 extends Internet {

	public double getCosto() {
		return 850;
	}

	public String detalle() {
		return super.detalle() + " 100: " + this.getCosto() + "\n" ;
	}

}

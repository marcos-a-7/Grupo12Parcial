package modelo;

public class Cable implements IServicio {

	public Cable() {
	}

	public double getCosto() {
		return 250;
	}

	public String detalle() {
		return "Tv Cable: $" + this.getCosto() + "\n";
	}

}

package servicios;

public abstract class Internet implements IServicio {

	public String detalle() {
		return "Internet ";
	}
	public double getCostoTotal() {
		return this.getCosto();
	}
}

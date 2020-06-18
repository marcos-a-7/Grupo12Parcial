package servicios;

/**
 * @author grupo12 <br>
 *         <b> devuelve el costo del cable y tambien puede devolver una
 *         descripcion</b>
 */
public class Cable implements IServicio, Cloneable {

	public Cable() {
	}

	public double getCosto() {
		return 250;
	}

	public String detalle() {
		return "Tv Cable: $" + this.getCosto() + "\n";
	}

}

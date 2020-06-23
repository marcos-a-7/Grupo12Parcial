package servicios;

/**
 * @author Grupo12<br>
 *         <b>La calse internet500 extiende de internet e implementa una
 *         devolucion de su costo y del detalle del mismo</b><br>
 */
public class Internet500 extends Internet {

	public Internet500() {

	}

	public double getCosto() {
		return 1000;
	}

	public String detalle() {
		return super.detalle() + " 500: $" + this.getCosto() + "\n";
	}
}

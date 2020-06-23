package servicios;

/**
 * @author Grupo12<br>
 *         <b>La calse internet100 extiende de internet e implementa una
 *         devolucion de su costo y del detalle del mismo</b><br>
 */
public class Internet100 extends Internet {

	public Internet100() {

	}

	public double getCosto() {
		return 850;
	}

	public String detalle() {
		return super.detalle() + " 100: $" + this.getCosto() + "\n";
	}
}

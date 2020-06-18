package servicios;

/**
 * @author Grupo12<br>
 *         <b>La clase internet100 implementa el patron singleton y devuelve el
 *         costo de dicho internet</b><br>
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

package servicios;

/**
 * @author Grupo12<br>
 *         <b> La clase internet500 implementa el patron singleton y devuelve el
 *         costo de dicho internet</b><br>
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

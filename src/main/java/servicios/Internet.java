package servicios;

/**
 * @author Grupo12<br>
 * <b>clase de la que se extienden los tipos de internet</b><br>
 */
public abstract class Internet implements IServicio {

	public String detalle() {
		return "Internet ";
	}

	public double getCostoTotal() {
		return this.getCosto();
	}
}

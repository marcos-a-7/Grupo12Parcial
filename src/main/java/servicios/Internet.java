package servicios;

import java.io.Serializable;

/**
 * @author Grupo12<br>
 * <b>clase de la que se extienden los tipos de internet</b><br>
 */
public abstract class Internet implements IServicio, Cloneable, Serializable {

	public String detalle() {
		return "Internet ";
	}

	public double getCostoTotal() {
		return this.getCosto();
	}

	@Override
	public Internet clone() throws CloneNotSupportedException {
		
		return (Internet) super.clone();
	}
	
	
}

package clientes;

import java.io.Serializable;

/**
 * @author Grupo12<br>
 *         <b>clase de la que se extienden los medios de pago</b><br>
 */
public abstract class MedioPago implements Cloneable, Serializable {
	public abstract double getTasaFisica();

	public abstract double getTasaJuridica();

	@Override
	public MedioPago clone() throws CloneNotSupportedException {
		return (MedioPago) super.clone();
	}
	
	
}

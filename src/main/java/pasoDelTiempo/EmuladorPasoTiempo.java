package pasoDelTiempo;

import java.io.Serializable;
import java.util.Observable;

/**
 * @author Grupo12 la clase EmuladorPasoTiempo extiende de observable y se
 *         encarga de emular el paso de los meses, contiene el mes actual<br>
 *
 */
public class EmuladorPasoTiempo extends Observable implements Serializable {
	private int mes = 0;

	public EmuladorPasoTiempo() {

	}

	public int getMes() {
		return this.mes;
	}

	/**
	 * avanzaMes<br>
	 * este metodo incrementa el mes actual en 1<br>
	 */
	public void avanzarMes() {
		this.mes++;
		setChanged();
		notifyObservers(mes);
	}
}

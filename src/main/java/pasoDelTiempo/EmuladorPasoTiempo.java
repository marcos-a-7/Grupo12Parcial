package pasoDelTiempo;

import java.io.Serializable;
import java.util.Observable;

public class EmuladorPasoTiempo extends Observable implements Serializable {
	private int mes = 0;

	public EmuladorPasoTiempo() {

	}

	public int getMes() {
		return this.mes;
	}
	public void avanzarMes() {
		this.mes++;
		setChanged();
		notifyObservers(mes);
	}
}

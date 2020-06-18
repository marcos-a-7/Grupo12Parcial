package pasoDelTiempo;

import java.util.Observable;

public class EmuladorPasoTiempo extends Observable {
	private int mes = 0;
	private static EmuladorPasoTiempo emuladorPasoTiempo;

	private EmuladorPasoTiempo() {

	}

	public static EmuladorPasoTiempo getInstance() {
		if (emuladorPasoTiempo == null)
			emuladorPasoTiempo = new EmuladorPasoTiempo();
		return emuladorPasoTiempo;
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

package pasoDelTiempo;

import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

import modelo.Empresa;

/**
 * @author Grupo12 esta clase implementa la interface observer y contiene un
 *         emulador del paso del tiempo que sera el objeto observado por la
 *         misma, ademas de una empresa de la que ejecutara metodos cuando
 *         observe cambios en el emulador del paso del tiempo<br>
 *
 */
public class Observador implements Observer, Serializable {
	private Empresa empresa;
	private EmuladorPasoTiempo observado;

	public Observador(Empresa empresa) {
		super();
		this.empresa = empresa;
	}

	public Observador(Empresa empresa, EmuladorPasoTiempo observado) {
		super();
		this.empresa = empresa;
		observado.addObserver(this);
		this.observado = observado;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setObservable(EmuladorPasoTiempo observado) {
		observado.addObserver(this);
		this.observado = observado;
	}

	public void borrarObservable(EmuladorPasoTiempo observado) {
		observado.deleteObserver(this);
		this.observado = null;
	}

	/**
	 * update<br>
	 * este metodo update ejecuta la facturacion de la empresa cuando observa un
	 * cambio en el objeto obsrvado<br>
	 *
	 */
	public void update(Observable arg0, Object arg1) {
		if (this.observado.equals(arg0)) {
			this.empresa.facturacion((Integer) arg1);
		} else
			throw new IllegalArgumentException();
	}

}

package pasoDelTiempo;

import java.util.Observable;
import java.util.Observer;

import modelo.Empresa;

public class Observador implements Observer {
	private Empresa empresa;
	private EmuladorPasoTiempo observado;

	public Observador(Empresa empresa) {
		super();
		this.empresa = empresa;
	}

	public Observador(Empresa empresa, EmuladorPasoTiempo observado) {
		super();
		this.empresa = empresa;
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

	public void update(Observable arg0, Object arg1) {

		if (this.observado.equals(arg0)) {
			this.empresa.facturacion((Integer) arg1);
		} else
			throw new IllegalArgumentException();
	}

}

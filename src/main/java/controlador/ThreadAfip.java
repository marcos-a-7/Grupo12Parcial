package controlador;

import modelo.AFIP;
import modelo.Empresa;

public class ThreadAfip extends Thread {
	Empresa empresa;
	ControladorPrincipal controladorPrincipal;
	RecursoCompartido recursoCompartido;
	
	
	public ThreadAfip(Empresa empresa, ControladorPrincipal controladorPrincipal, RecursoCompartido recursoCompartido) {
		super();
		this.empresa = empresa;
		this.controladorPrincipal = controladorPrincipal;
		this.recursoCompartido = recursoCompartido;
	}



	@Override
	public synchronized void run() {
		AFIP afip = new AFIP(empresa);
		recursoCompartido.ejecutarAfip(afip, controladorPrincipal);
	}

}

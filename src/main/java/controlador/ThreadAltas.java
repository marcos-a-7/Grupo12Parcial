package controlador;

import modelo.Empresa;

public class ThreadAltas extends Thread{
	Empresa empresa;
	ControladorPrincipal controladorPrincipal;
	RecursoCompartido recursoCompartido;
	
	
	public ThreadAltas(Empresa empresa, ControladorPrincipal controladorPrincipal, RecursoCompartido recursoCompartido) {
		super();
		this.empresa = empresa;
		this.controladorPrincipal = controladorPrincipal;
		this.recursoCompartido = recursoCompartido;
	}



	@Override
	public synchronized void run() {
		recursoCompartido.ejecutarAlta(empresa, controladorPrincipal);
	}

}

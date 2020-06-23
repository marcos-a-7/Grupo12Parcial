package controlador;

import modelo.AFIP;
import modelo.Empresa;

/**
 * @author Grupo12 <br>
 *         hilo para ejecutar la afip, tiene una empresa un controlador
 *         principal que sera quien lanze el hilo y un recurso compartido que
 *         sincroniza este hilo<br>
 *
 */
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

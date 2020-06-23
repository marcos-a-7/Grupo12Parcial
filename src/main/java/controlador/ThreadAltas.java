package controlador;

import modelo.Empresa;

/**
 * @author Grupo12 <br>
 *         hilo para ejecutar alta, tiene una empresa un controlador
 *         principal que sera quien lanze el hilo y un recurso compartido que
 *         sincroniza este hilo<br>
 *
 */
public class ThreadAltas extends Thread {
	Empresa empresa;
	ControladorPrincipal controladorPrincipal;
	RecursoCompartido recursoCompartido;

	public ThreadAltas(Empresa empresa, ControladorPrincipal controladorPrincipal,
			RecursoCompartido recursoCompartido) {
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

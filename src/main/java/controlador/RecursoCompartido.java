package controlador;

import java.util.ArrayList;

import modelo.AFIP;
import modelo.Empresa;

public class RecursoCompartido {
	ArrayList<ControladorAltas> controladoresAltas = new ArrayList<ControladorAltas>();
	boolean afip = false;

	public RecursoCompartido() {
	}

	public synchronized void ejecutarAlta(Empresa empresa, ControladorPrincipal controladorPrincipal) {
		while (this.afip == true) {
			try {
				controladorPrincipal.imprimeMensaje("La ventana de alta se ejecutar al terminar la visita de la AFIP");
				wait();
			} catch (InterruptedException e) {
			}
		}
		controladoresAltas.add(new ControladorAltas(empresa, controladorPrincipal, this));
	}

	public synchronized void terminarAlta(ControladorAltas controladorAltas) {
		controladoresAltas.remove(controladorAltas);
		this.notifyAll();
	}

	public synchronized void ejecutarAfip(AFIP afip, ControladorPrincipal controladorPrincipal) {
		if (this.afip == false) {
			this.afip = true;
			if (!controladoresAltas.isEmpty())
				controladorPrincipal.imprimeMensaje("La AFIP va a interrumpir al concluir las altas en ejecucion");
			while (!controladoresAltas.isEmpty()) {
				try {
					wait();
				} catch (InterruptedException e) {
					this.afip = false;
				}
			}
			new ControladorAfip(afip, controladorPrincipal, this);
		}
	}

	public synchronized void terminarAfip() {
		this.afip = false;
		this.notifyAll();
	}
}

package controlador;

import java.util.ArrayList;

import modelo.AFIP;
import modelo.Empresa;

/**
 * @author Grupo12<br>
 *         se encarga de controlar el acceso a la creacion de nuevas ventanas de
 *         alta y de afip para cumplir con el bloqueo entre las mismas<br>
 *
 */
public class RecursoCompartido {
	ArrayList<ControladorAltas> controladoresAltas = new ArrayList<ControladorAltas>();
	boolean afip = false;

	public RecursoCompartido() {
	}

	/**
	 * ejecutarAlta<br>
	 * este metodo esta syncronizado y controla si se puede ejecutar un alta o si la
	 * afip esta en ejecucion, de no poderse ejecutar un alta pone al hilo que la
	 * ejecutara a dormir<br>
	 * 
	 * @param empresa              : empresa para la cual se requiere un alta
	 * @param controladorPrincipal : controlador principal que quiere ejecutar el
	 *                             alta
	 */
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

	/**
	 * terminarAlta<br>
	 * este metodo esta sincronizado, termina la ejecucion de un alta pasada por
	 * parametro, notifica a todos los hilos para que se despierten<br>
	 * 
	 * @param controladorAltas : controlador altas a finalizar
	 */
	public synchronized void terminarAlta(ControladorAltas controladorAltas) {
		controladoresAltas.remove(controladorAltas);
		this.notifyAll();
	}

	/**
	 * ejecutarAfip<br>
	 * este metodo esta sincronizado y controla si se puede ejecutar una afip o si
	 * esta en proceso de ejecucion un alta, en caso de no poderse ejecutar la afip
	 * pone al hilo que la iniciara a dormir hasta que terminen todas las altas en
	 * proceso<br>
	 * 
	 * @param afip                 : una afip que se utilizara para crear el
	 *                             controlador afip
	 * @param controladorPrincipal : controlador principal que quiere ejecutar la
	 *                             afip
	 */
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

	/**
	 * terminarAfip<br>
	 * este metodo esta sincronizado, termina la ejecucion de la afip y noficica a
	 * todos los hilos para que se despierten<br>
	 * 
	 */
	public synchronized void terminarAfip() {
		this.afip = false;
		this.notifyAll();
	}
}

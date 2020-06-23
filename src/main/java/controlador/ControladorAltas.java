package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import excepciones.NumeroInvalidoException;
import excepciones.PersonaRepetidaException;
import excepciones.TipoPersonaInvalidoException;
import modelo.Empresa;
import vista.VistaAltas;

/**
 * @author Grupo12<br>
 *         controlador de la interfaz grafica Altas, posee una referencia a la
 *         ventana que controla asi como una refenrecia al controlador
 *         principal, a un objeto empresa y al recurso compartido necesario para
 *         bloquear la afip al estarse ejecutando la ventana altas
 *
 */
public class ControladorAltas implements ActionListener, WindowListener {
	VistaAltas ventana;
	ControladorPrincipal controladorPrincipal;
	Empresa empresa;
	RecursoCompartido recursoCompartido;

	public ControladorAltas(Empresa empresa, ControladorPrincipal controladorPrincipal,
			RecursoCompartido recursoCompartido) {
		super();
		this.empresa = empresa;
		this.controladorPrincipal = controladorPrincipal;
		ventana = new VistaAltas();
		ventana.setActionListener(this);
		ventana.setWindowListener(this);
		this.recursoCompartido = recursoCompartido;
	}

	/**
	 * actionPerformed<br>
	 * este metodo controla la pulsacion de los botones de la ventana y realiza
	 * diversas operaciones depeniendo de cual fue pulsado<br>
	 */
	public void actionPerformed(ActionEvent arg0) {
		String comando = arg0.getActionCommand();
		if (comando.equals("CONFIRMAR")) {
			String nombre = ventana.getNombre();
			String tipo = ventana.getTipo();
			int id = ventana.getIdentificador();
			try {
				empresa.addPersona(tipo, nombre, id);
				controladorPrincipal.actualizaListaPersonas();
				ventana.cerrar();
				controladorPrincipal.imprimeEvento(nombre + " | " + id + " se agrego corectamente al sistema");
			} catch (NumeroInvalidoException e) {
				e.printStackTrace();
			} catch (TipoPersonaInvalidoException e) {
				e.printStackTrace();
			} catch (PersonaRepetidaException e) {
				ventana.imprimeMensaje(e.getMessage());
			}
		} else if (comando.equals("ATRAS")) {
			ventana.cerrar();
		}

	}

	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * windowClosing<br>
	 * metodo que se ejecutara al cerrar la ventana, delega al recurso compartido el
	 * terminar la ejecucion del alta y cierra la ventana<br>
	 *
	 */
	public void windowClosing(WindowEvent arg0) {
		recursoCompartido.terminarAlta(this);
		ventana.dispose();
	}

	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

}

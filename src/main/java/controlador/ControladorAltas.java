package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import excepciones.NumeroInvalidoException;
import excepciones.PersonaRepetidaException;
import excepciones.TipoPersonaInvalidoException;
import modelo.Empresa;
import vista.VistaAltas;

public class ControladorAltas implements ActionListener {
	VistaAltas ventana;
	ControladorPrincipal controladorPrincipal;
	Empresa empresa;

	public ControladorAltas(Empresa empresa, ControladorPrincipal controladorPrincipal) {
		super();
		this.empresa = empresa;
		this.controladorPrincipal = controladorPrincipal;
		ventana = new VistaAltas();
		ventana.setActionListener(this);
	}

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

}

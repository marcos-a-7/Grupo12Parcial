package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import clientes.Persona;
import vista.VistaContrato;

public class ControladorContrato implements ActionListener {
	VistaContrato ventana;
	ControladorPrincipal controladorPrincipal;
	Persona persona;
	
	public ControladorContrato(Persona persona,ControladorPrincipal controladorPrincipal) {
		super();
		this.persona = persona;
		this.controladorPrincipal = controladorPrincipal;
		ventana = new VistaContrato();
		ventana.setActionListener(this);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		String comando = arg0.getActionCommand();
		
		if (comando.equals("ELIMCELULAR")) {
			
		} else if (comando.equals("ELIMTELEFONO")) {
			
		} else if (comando.equals("ELIMCONTRATO")) {

		} else if (comando.equals("ELIMCABLE")) {

		} else if (comando.equals("CREARCONTRATO")) {

		} else if (comando.equals("MODIFICAR")) {

		} else if (comando.equals("AGREGAR")) {

		} else if (comando.equals("ATRAS")) {
			ventana.cerrar();
		}

	}

}

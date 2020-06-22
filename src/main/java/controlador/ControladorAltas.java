package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
			
			
			ventana.cerrar();
		} else if (comando.equals("ATRAS")) {
			ventana.cerrar();
		}

	}

}

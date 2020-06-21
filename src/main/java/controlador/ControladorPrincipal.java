package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Empresa;
import pasoDelTiempo.EmuladorPasoTiempo;
import vista.VistaPrincipal;

public class ControladorPrincipal implements ActionListener {
	Empresa empresa;
	EmuladorPasoTiempo ept;
	VistaPrincipal ventana;
	
	
	
	public ControladorPrincipal(Empresa empresa) {
		super();
		this.empresa = empresa;
		ept = EmuladorPasoTiempo.getInstance();
		ventana = new VistaPrincipal();
		ventana.setActionListener(this);
		this.actualizaListaPersonas();
	}




	public void actualizaListaPersonas() {
		this.ventana.actualizaListaPersonas(empresa.getPersonas());
	}



	public void actionPerformed(ActionEvent arg0) {
		String comando = arg0.getActionCommand();
		if (comando.equals("ACTUALIZARMES")) {
			ept.avanzarMes();
		} else if (comando.equals("DARALTA")) {
			new ControladorAltas(empresa,this);
		} else if (comando.equals("MODIFICACONTRATO")) {
			new ControladorContrato(ventana.getPersona(),this);
		} else if (comando.equals("DARBAJA")) {
			
		}
		
	}
	
	
	
	
	
	
}
package controlador;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.Contrato;
import vista.VistaContrato;

public class ControladorListaContratos implements ListSelectionListener {
	ControladorContrato controladorContrato;
	VistaContrato ventana;
	
	public ControladorListaContratos(controlador.ControladorContrato controladorContrato, VistaContrato ventana) {
		this.controladorContrato = controladorContrato;
		this.ventana = ventana;
	}

	public void valueChanged(ListSelectionEvent arg0) {
		Contrato contrato = ventana.getContrato();
		if (contrato != null) {
			controladorContrato.actualizaListaCelulares(contrato.getPaqueteServicios().getCelulares());
			controladorContrato.actualizaListaTelefonos(contrato.getPaqueteServicios().getTelefonos());
			controladorContrato.actualizaCantCables(contrato.getPaqueteServicios().cantidadCables());
			controladorContrato.actualizaDomicilio(contrato.getDomicilio());
			controladorContrato.actualizaMedioPago();
			controladorContrato.actualizaTipoInternet();
			
		}
	}

}

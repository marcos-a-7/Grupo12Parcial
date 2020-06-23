package controlador;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.Contrato;
import vista.VistaContrato;

/**
 * @author Grupo12<br>
 *         controlador de la lista de contratos de una interfaz grafica de
 *         contratos, posee una referencia al controlador de la interfaz grafico
 *         contrato y una referencia a la ventana con la lista
 *
 */
public class ControladorListaContratos implements ListSelectionListener {
	ControladorContrato controladorContrato;
	VistaContrato ventana;

	public ControladorListaContratos(controlador.ControladorContrato controladorContrato, VistaContrato ventana) {
		this.controladorContrato = controladorContrato;
		this.ventana = ventana;
	}

	/**
	 * valueChanged<br>
	 * este metodo se ejecuta cuando se realiza una nueva seleccion en la lista de
	 * contratos de la ventana, al realizarce la misma delega al controlador de la
	 * interfaz contrato la actualizacion de todos los componentes graficos de la
	 * ventana correspondientes al contrato seleccionado<br>
	 */
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

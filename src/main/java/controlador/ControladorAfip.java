package controlador;

import java.awt.event.ActionEvent;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.AFIP;
import modelo.Factura;
import vista.VistaAfip;

/**
 * @author Grupo12<br>
 *         controlador de la interfaz grafica afip, posee una referencia a la
 *         ventana que controla asi como una refenrecia al controlador
 *         principal, a un objeto afip y al recurso compartido necesario para
 *         bloquear el alta al estarse ejecutando la ventana afip
 *
 */
public class ControladorAfip implements ListSelectionListener, WindowListener {
	VistaAfip ventana;
	ControladorPrincipal controladorPrincipal;
	RecursoCompartido recursoCompartido;
	AFIP afip;

	public ControladorAfip(AFIP afip, ControladorPrincipal controladorPrincipal, RecursoCompartido recursoCompartido) {
		this.controladorPrincipal = controladorPrincipal;
		this.recursoCompartido = recursoCompartido;
		this.afip = afip;
		ventana = new VistaAfip("AFIP");
		ventana.setWindowListener(this);
		ventana.setListSelectionListener(this);
		this.imprimeReporte();
		this.actualizaListaFacturas();

	}

	/**
	 * imprime reporte<br>
	 * funcion que le dice a la ventana que imprima un reporte solicitado
	 * previamente a la afip<br>
	 */
	public void imprimeReporte() {
		String reporte = afip.reporte();
		ventana.setReporte(reporte);
	}

	/**
	 * actualizaFacturas<br>
	 * funcion que delega a la ventana la actualizacion de la lista de facturas<br>
	 */
	public void actualizaListaFacturas() {
		ventana.actualizaListaFacturas(afip.getFacturas());

	}

	/**
	 * imprimeFactura<br>
	 * funcion que delega la impresion de una factura a la ventana, mediante un
	 * string<br>
	 * 
	 * @param factura : factura a imprimir
	 */
	public void imprimeFactura(Factura factura) {
		ventana.imprimeFactura(factura.imprimeFactura());
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
	 * terminar la ejecucion de la afip y cierra la ventana<br>
	 *
	 */
	public void windowClosing(WindowEvent arg0) {
		recursoCompartido.terminarAfip();
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

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * valueChanged<br>
	 * controla la factura seleccionada en la ventana y al cambiar la misma ejecuta
	 * su impresion<br>
	 */
	public void valueChanged(ListSelectionEvent arg0) {
		Factura factura = ventana.getFactura();
		if (factura != null) {
			this.imprimeFactura(factura);
		}

	}

}

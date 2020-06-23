package controlador;

import java.awt.event.ActionEvent;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.AFIP;
import modelo.Factura;
import vista.VistaAfip;


public class ControladorAfip implements ListSelectionListener, WindowListener {
	VistaAfip ventana;
	ControladorPrincipal controladorPrincipal;
	RecursoCompartido recursoCompartido;
	AFIP afip;

	public ControladorAfip(AFIP afip, ControladorPrincipal controladorPrincipal,
			RecursoCompartido recursoCompartido) {
		this.controladorPrincipal = controladorPrincipal;
		this.recursoCompartido = recursoCompartido;
		this.afip = afip;
		ventana = new VistaAfip("AFIP");
		ventana.setWindowListener(this);
		ventana.setListSelectionListener(this);
		this.imprimeReporte();
		this.actualizaListaFacturas();
		

	}

	public void imprimeReporte() {
		String reporte = afip.reporte();
		ventana.setReporte(reporte);
	}
	
	public void actualizaListaFacturas() {
		ventana.actualizaListaFacturas(afip.getFacturas());

	}
	
	public void imprimeFactura(Factura factura) {
		ventana.imprimeFactura(factura.imprimeFactura());
	}
	
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

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

	public void valueChanged(ListSelectionEvent arg0) {
		Factura factura = ventana.getFactura();
		if (factura!= null) {
			this.imprimeFactura(factura);
		}
		
	}
	
	

}

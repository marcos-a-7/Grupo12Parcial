package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import clientes.Persona;
import excepciones.DomicilioDuplicadoException;
import excepciones.ImposibleCrearContratoException;
import excepciones.ImposibleCrearPaqueteException;
import modelo.Contrato;
import vista.VistaContrato;

public class ControladorContrato implements ActionListener, ListSelectionListener {
	VistaContrato ventana;
	ControladorPrincipal controladorPrincipal;
	Persona persona;
	
	public ControladorContrato(Persona persona,ControladorPrincipal controladorPrincipal) {
		super();
		this.persona = persona;
		this.controladorPrincipal = controladorPrincipal;
		ventana = new VistaContrato(persona.getNombre()+ " | " + persona.getIdentificador());
		ventana.setActionListener(this);
		ventana.setListSelectionListener(this);
		ventana.actualizaListaContratos(persona.getContratos());
	}
	
	public void actionPerformed(ActionEvent arg0) {
		String comando = arg0.getActionCommand();
		
		if (comando.equals("ELIMCELULAR")) {
			
		} else if (comando.equals("ELIMTELEFONO")) {
			
		} else if (comando.equals("ELIMCONTRATO")) {

		} else if (comando.equals("ELIMCABLE")) {

		} else if (comando.equals("CREARCONTRATO")) {
			String calle = ventana.getCalle();
			int numeroCalle = ventana.getNumero();
			String tipoInternet = ventana.getTipoInternet();
			int cantCelu = ventana.getCantCelulares();
			int cantTel = ventana.getCantTelefonos();
			int cantCable = ventana.getCantCables();
			String medioPago = ventana.getMedioPago();
			try {
				persona.agregaContrato(calle, numeroCalle, tipoInternet, cantCelu, cantTel, cantCable, medioPago);
				ventana.actualizaListaContratos(persona.getContratos());
			} catch (DomicilioDuplicadoException e) {
				ventana.imprimeMensaje("No se pudo crear contrato, el domicilio ingresado ya se encuentra registrado");
			} catch (ImposibleCrearContratoException e) {
				e.printStackTrace();
			} catch (ImposibleCrearPaqueteException e) {
				e.printStackTrace();
			}
		} else if (comando.equals("MODIFICAR")) {

		} else if (comando.equals("AGREGAR")) {
			
		} else if (comando.equals("ATRAS")) {
			ventana.cerrar();
		}

	}

	public void valueChanged(ListSelectionEvent arg0) {
		Contrato contrato = ventana.getContrato();
		if (contrato!=null) {
			ventana.actualizaListaCelulares(contrato.getPaqueteServicios().getCelulares());
			ventana.actualizaListaTelefonos(contrato.getPaqueteServicios().getTelefonos());
		}
		
		
	}

}

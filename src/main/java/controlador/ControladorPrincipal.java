package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import clientes.Persona;
import excepciones.MorosoException;
import excepciones.SinContratacionesException;
import modelo.Empresa;
import modelo.Factura;
import pasoDelTiempo.EmuladorPasoTiempo;
import persistencia.IPersistencia;
import persistencia.PersistenciaBIN;
import vista.VistaPrincipal;

public class ControladorPrincipal implements ActionListener, ListSelectionListener, WindowListener {
	Empresa empresa;
	EmuladorPasoTiempo ept;
	VistaPrincipal ventana;
	RecursoCompartido recursoCompartido = new RecursoCompartido();

	public ControladorPrincipal(Empresa empresa, EmuladorPasoTiempo ept) {
		super();
		this.empresa = empresa;
		this.ept = ept;
		ventana = new VistaPrincipal(empresa.getNombre());
		ventana.setActionListener(this);
		ventana.setListSelectionListener(this);
		ventana.setWindowListener(this);
		this.actualizaListaPersonas();
		
	}

	public void actualizaListaPersonas() {
		this.ventana.actualizaListaPersonas(empresa.getPersonas());
	}

	public void actualizaListaFacturas(ArrayList<Factura> facturas) {
		this.ventana.actualizaListaFacturas(facturas);
	}

	public void actionPerformed(ActionEvent arg0) {
		String comando = arg0.getActionCommand();
		if (comando.equals("ACTUALIZARMES")) {
			ept.avanzarMes();
			Persona persona = ventana.getPersona();
			if (persona != null) {
				this.actualizaListaFacturas(persona.getFacturas());
			}
			this.imprimeEvento("Paso un mes, el mes actual es: " + ept.getMes());
		} else if (comando.equals("DARALTA")) {
			new ThreadAltas(empresa, this, recursoCompartido).start();
		} else if (comando.equals("MODIFICACONTRATO")) {
			try {
				if (ventana.getPersona() != null && ventana.getPersona().modificaContrato()) {
					new ControladorContrato(ventana.getPersona(), this);
				}
			} catch (MorosoException e) {
				ventana.imprimeMensaje("Persona Morosa debe abonar facturas para poder modificar sus contratos");
			} catch (SinContratacionesException e) {
				new ControladorContrato(ventana.getPersona(), this);
			}
		} else if (comando.equals("DARBAJA")) {
			Persona persona = ventana.getPersona();
			if (persona.cantidadFacturasDebidas() == 0) {
				empresa.removePersona(persona);
				this.actualizaListaPersonas();
				this.imprimeEvento("Se dio de baja a " + persona.toString());
			} else {
				ventana.imprimeMensaje("El abonado debe pagar todas las facturas debidas para poder ser dado de baja");
			}
		} else if (comando.equals("PAGAR")) {
			Persona persona = ventana.getPersona();
			Factura factura = ventana.getFactura();
			double monto;
			if (persona != null) {
				try {
					monto = persona.pagar(factura);
					if (monto == 0) {
						this.imprimeEvento("La factura del mes " + factura.getMes() + " ya se encuentra pagada");
					} else {
						this.imprimeEvento(persona.getNombre() + " abono la factura del mes " + factura.getMes()
								+ " pagando un total de " + monto);
						this.actualizaListaFacturas(persona.getFacturas());
					}
				} catch (SinContratacionesException e) {
					e.printStackTrace();
				}
			}
		} else if (comando.equals("PERSISTIR")) {
			this.persistir();

		} else if (comando.equals("AFIP")) {
			new ThreadAfip(empresa, this, recursoCompartido).start();
		}

	}

	public void persistir() {
		IPersistencia persistencia = new PersistenciaBIN();

		try {
			persistencia.abrirOutput("Empresa.bin");
			persistencia.escribir(empresa);
			persistencia.cerrarOutput();
			persistencia.abrirOutput("Mes.bin");
			persistencia.escribir(ept);
			persistencia.cerrarOutput();
			this.imprimeEvento("Sistema guardado correctamente");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void imprimeEvento(String evento) {
		ventana.imprimeEvento(evento + "\n");
	}

	public void valueChanged(ListSelectionEvent arg0) {
		Persona persona = ventana.getPersona();
		if (persona != null) {
			this.actualizaListaFacturas(persona.getFacturas());
		}

	}

	public void imprimeMensaje(String string) {
		ventana.imprimeMensaje(string);

	}

	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void windowClosing(WindowEvent arg0) {
		this.persistir();
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

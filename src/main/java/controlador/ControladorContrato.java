package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import clientes.Cheque;
import clientes.Domicilio;
import clientes.Efectivo;
import clientes.Persona;
import clientes.Tarjeta;
import excepciones.DomicilioDuplicadoException;
import excepciones.ImposibleCrearContratoException;
import excepciones.ImposibleCrearPaqueteException;
import excepciones.MorosoException;
import excepciones.SinContratacionesException;
import modelo.Contrato;
import servicios.Celular;
import servicios.Internet100;
import servicios.Internet500;
import servicios.Telefono;
import vista.VistaContrato;

/**
 * @author Grupo12<br>
 *         controlador de la interfaz grafica Modifica Contrato, posee una
 *         referencia a la ventana que controla asi como una refenrecia al
 *         controlador principal y a la persona de la cual se va a modificar un
 *         contrato
 *
 */
public class ControladorContrato implements ActionListener {
	VistaContrato ventana;
	ControladorPrincipal controladorPrincipal;
	Persona persona;

	public ControladorContrato(Persona persona, ControladorPrincipal controladorPrincipal) {
		super();
		this.persona = persona;
		this.controladorPrincipal = controladorPrincipal;
		ventana = new VistaContrato(persona.getNombre() + " | " + persona.getIdentificador());
		ventana.setActionListener(this);
		ventana.setListSelectionListenerContratos(new ControladorListaContratos(this, ventana));
		this.actualizaListaContratos(persona.getContratos());
	}

	/**
	 * actionPerformed<br>
	 * este metodo controla cuando un boton es pulsado en la ventana y dependiendo
	 * de cual sea realiza las operaciones correspondientes<br>
	 */
	public void actionPerformed(ActionEvent arg0) {
		String comando = arg0.getActionCommand();

		if (comando.equals("ELIMCELULAR")) {
			Celular celular = ventana.getCelular();
			Contrato contrato = ventana.getContrato();
			if (celular != null && contrato != null) {
				try {
					if (persona.modificaContrato()) {
						contrato.eliminaCelular(celular.getNumeroCelular());
						this.actualizaListaCelulares(contrato.getPaqueteServicios().getCelulares());
						controladorPrincipal.imprimeEvento(persona.getNombre() + " modifico un contrato");
					}
				} catch (MorosoException e) {
					ventana.imprimeMensaje(
							persona.getNombre() + " no puede modificar su contrato devido a que es Moroso");

				} catch (SinContratacionesException e) {
					e.printStackTrace();
				}
			}
			ventana.vaciarTextFields();
		} else if (comando.equals("ELIMTELEFONO")) {
			Telefono telefono = ventana.getTelefono();
			Contrato contrato = ventana.getContrato();
			if (telefono != null && contrato != null) {
				try {
					if (persona.modificaContrato()) {
						contrato.eliminaTelefono(telefono.getNumeroTelefono());
						this.actualizaListaTelefonos(contrato.getPaqueteServicios().getTelefonos());
						controladorPrincipal.imprimeEvento(persona.getNombre() + " modifico un contrato");
					}
				} catch (MorosoException e) {
					ventana.imprimeMensaje(
							persona.getNombre() + " no puede modificar su contrato debido a que es Moroso");

				} catch (SinContratacionesException e) {
					e.printStackTrace();
				}
			}
			ventana.vaciarTextFields();
		} else if (comando.equals("ELIMCONTRATO")) {
			Contrato contrato = ventana.getContrato();
			if (contrato != null) {
				try {
					persona.eliminaContrato(contrato);
					this.actualizaListaContratos(persona.getContratos());
					ventana.limpiaListaCelulares();
					ventana.limpiaListaTelefonos();
					controladorPrincipal.imprimeEvento(persona.getNombre() + " elimino un contrato");
				} catch (MorosoException e) {
					ventana.imprimeMensaje("El contrato no puede eliminarse por que el cliente es Moroso");
				} catch (SinContratacionesException e) {
					e.printStackTrace();
				}
			}
			ventana.vaciarTextFields();
		} else if (comando.equals("ELIMCABLE")) {
			if (ventana.getContrato() != null) {
				ventana.getContrato().eliminaCables(ventana.getCantCablesElim());
				this.actualizaCantCables(ventana.getContrato().getPaqueteServicios().cantidadCables());
				ventana.vaciarTextFields();
				controladorPrincipal.imprimeEvento(persona.getNombre() + " modifico un contrato");
			}
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
				controladorPrincipal.imprimeEvento(persona.getNombre() + " creo un nuevo contrato");
			} catch (DomicilioDuplicadoException e) {
				ventana.imprimeMensaje("No se pudo crear contrato, el domicilio ingresado ya se encuentra registrado");
			} catch (ImposibleCrearContratoException e) {
				e.printStackTrace();
			} catch (ImposibleCrearPaqueteException e) {
				e.printStackTrace();
			}
			ventana.vaciarTextFields();
		} else if (comando.equals("MODIFICAR")) {
			String medioPago = ventana.getMedioPago();
			String tipoInternet = ventana.getTipoInternet();
			Contrato contrato = ventana.getContrato();
			try {
				if (persona.modificaContrato() && contrato != null) {
					contrato.cambiaInternet(tipoInternet);
					contrato.cambiaMedioPago(medioPago);
					controladorPrincipal.imprimeEvento(persona.getNombre() + " modifico un contrato");
				}
			} catch (MorosoException e) {
				ventana.imprimeMensaje(persona.getNombre() + " no puede modificar su contrato debido a que es Moroso");

			} catch (SinContratacionesException e) {
				e.printStackTrace();
			}
			ventana.vaciarTextFields();

		} else if (comando.equals("AGREGAR")) {
			Contrato contrato = ventana.getContrato();
			try {
				if (contrato != null && persona.modificaContrato()) {
					contrato.addCables(ventana.getCantCables());
					contrato.addCelulares(ventana.getCantCelulares());
					contrato.addTelefonos(ventana.getCantTelefonos());
					this.actualizaListaCelulares(contrato.getPaqueteServicios().getCelulares());
					this.actualizaListaTelefonos(contrato.getPaqueteServicios().getTelefonos());
					this.actualizaCantCables(contrato.getPaqueteServicios().cantidadCables());
					ventana.vaciarTextFields();
					controladorPrincipal.imprimeEvento(persona.getNombre() + " modifico un contrato");
				}
			} catch (MorosoException e) {
				ventana.imprimeMensaje(persona.getNombre() + " no puede modificar su contrato debido a que es Moroso");

			} catch (SinContratacionesException e) {
				e.printStackTrace();
			}
		} else if (comando.equals("ATRAS")) {
			ventana.cerrar();
		}

	}

	/**
	 * actualizaListaContratos<br>
	 * este metodo delega la actualizacion de la lista de contratos a la ventana<br>
	 * 
	 * @param contratos : arraylist de contratos
	 */
	private void actualizaListaContratos(ArrayList<Contrato> contratos) {
		ventana.actualizaListaContratos(contratos);

	}

	/**
	 * actualizaCantCables<br>
	 * este metodo delega la actualizacion de la cantidad de cables a la ventana<br>
	 * 
	 * @param cant : cantidad de cables
	 */
	public void actualizaCantCables(int cant) {
		ventana.actualizaCables(cant);
	}

	/**
	 * actualizaListaTelefonos<br>
	 * este metodo delega la actualizacion de la lista de telefonos a la ventana<br>
	 * 
	 * @param telefonos : arraylist de telefonos
	 */
	public void actualizaListaTelefonos(ArrayList<Telefono> telefonos) {
		ventana.actualizaListaTelefonos(telefonos);

	}

	/**
	 * actualizaListaCelulares<br>
	 * este metodo delega la actualizacion de la lista de celulares a la ventana<br>
	 * 
	 * @param telefonos : arraylist de celulares
	 */
	public void actualizaListaCelulares(ArrayList<Celular> celulares) {
		ventana.actualizaListaCelulares(celulares);
	}

	/**
	 * actualizaDomicilio<br>
	 * delega la actualizacion del domicilio a la ventana<br>
	 * 
	 * @param domicilio : domicilio a actualizar
	 */
	public void actualizaDomicilio(Domicilio domicilio) {
		ventana.actualizaDomicilio(domicilio.getNumero(), domicilio.getCalle());
	}

	/**
	 * actualizaMedioPago<br>
	 * delega la actualizacion del medio de pago a la ventana mediante un string con
	 * el mismo<br>
	 */
	public void actualizaMedioPago() {
		Contrato contrato = ventana.getContrato();
		if (contrato != null) {
			if (contrato.getMedioPago() instanceof Cheque) {
				ventana.setMedioPago("Cheque");
			} else if (contrato.getMedioPago() instanceof Efectivo) {
				ventana.setMedioPago("Efectivo");
			} else if (contrato.getMedioPago() instanceof Tarjeta) {
				ventana.setMedioPago("Tarjeta");
			}
		}
	}

	/**
	 * actualizaTipoInternet<br>
	 * delega la actualizacion del tipo de internet a la ventana mediante un string
	 * con el mismo
	 */
	public void actualizaTipoInternet() {
		Contrato contrato = ventana.getContrato();
		if (contrato != null) {
			if (contrato.getPaqueteServicios().getInternet() instanceof Internet100) {
				ventana.setTipoInternet("100");
			} else if (contrato.getPaqueteServicios().getInternet() instanceof Internet500) {
				ventana.setTipoInternet("500");
			}
		}
	}
}

package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;

import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.event.ListSelectionListener;

import clientes.Persona;
import controlador.ControladorContrato;
import modelo.Contrato;
import servicios.Celular;
import servicios.Telefono;

import javax.swing.event.ListSelectionEvent;

public class VistaContrato extends JFrame implements KeyListener {

	private JFrame frame;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JScrollPane scrollPane;
	private JList<Celular> list_Celulares;
	private JScrollPane scrollPane_1;
	private JList<Telefono> list_Telefonos;
	private JScrollPane scrollPane_2;
	private JList<Contrato> list_Contratos;
	private JPanel panel_8;
	private JPanel panel_9;
	private JPanel panel_10;
	private JPanel panel_11;
	private JPanel panel_12;
	private JPanel panel_13;
	private JPanel panel_14;
	private JPanel panel_15;
	private JButton btnNewButton_EliCelu;
	private JButton btn_ElTelef;
	private JButton btnNewButton_EliContrato;
	private JPanel panel_16;
	private JPanel panel_17;
	private JPanel panel_18;
	private JPanel panel_19;
	private JPanel panel_20;
	private JPanel panel_21;
	private JPanel panel_22;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField textField_Numero;
	private JTextField textField_Calle;
	private JButton btnNewButton_Crear;
	private JPanel panel_23;
	private JPanel panel_24;
	private JPanel panel_25;
	private JLabel lblNewLabel_3;
	private JRadioButton rdbtnNewRadioButton_Cheque;
	private JRadioButton rdbtnNewRadioButton_Efectivo;
	private JRadioButton rdbtnNewRadioButton_Tarjeta;
	private JLabel lblNewLabel_4;
	private JRadioButton rdbtnNewRadioButton_Internet100;
	private JRadioButton rdbtnNewRadioButton_Internet500;
	private JButton btnNewButton_Modificar;
	private JButton btnNewButton_Atras;
	private JPanel panel_26;
	private JPanel panel_27;
	private JPanel panel_28;
	private JPanel panel_29;
	private JPanel panel_30;
	private JLabel lblNewLabel_5;
	private JTextField textField_Celulares;
	private JLabel lblNewLabel_6;
	private JTextField textField_Cable;
	private JLabel lblNewLabel_7;
	private JTextField textField_Telefonos;
	private JButton btnNewButton_Agregar;
	private JPanel panel_31;
	private JPanel panel_32;
	private JLabel Label_Domicilio;
	private JPanel panel_33;
	private JPanel panel_34;
	private JLabel lblNewLabel_CantCables;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JPanel panel_35;
	private JPanel panel_36;
	private JButton btnElimCable;
	private JLabel lblNewLabel;
	private JTextField textField_CantCableElim;
	private ActionListener actionListener;
	private DefaultListModel<Celular> modeloListaCelulares;
	private DefaultListModel<Contrato> modeloListaContratos;
	private DefaultListModel<Telefono> modeloListaTelefonos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaContrato window = new VistaContrato("");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VistaContrato(String nombre) {
		initialize(nombre);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String nombre) {
		this.frame = new JFrame(nombre);
		this.frame.setBounds(100, 100, 1141, 609);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.panel = new JPanel();
		this.frame.getContentPane().add(this.panel, BorderLayout.CENTER);
		this.panel.setLayout(new BorderLayout(0, 0));

		this.panel_1 = new JPanel();
		this.panel.add(this.panel_1, BorderLayout.CENTER);
		this.panel_1.setLayout(new GridLayout(0, 3, 0, 0));

		this.panel_3 = new JPanel();
		this.panel_1.add(this.panel_3);
		this.panel_3.setLayout(new GridLayout(2, 0, 0, 0));

		this.panel_7 = new JPanel();
		this.panel_7.setBorder(new TitledBorder(new LineBorder(new Color(64, 64, 64), 3, true), "Lista de Contratos",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panel_3.add(this.panel_7);
		this.panel_7.setLayout(new BorderLayout(0, 0));

		this.scrollPane_2 = new JScrollPane();
		this.panel_7.add(this.scrollPane_2, BorderLayout.CENTER);

		this.list_Contratos = new JList<Contrato>();
		this.modeloListaContratos = new DefaultListModel<Contrato>();
		this.list_Contratos.setModel(modeloListaContratos);
		this.scrollPane_2.setViewportView(this.list_Contratos);

		this.panel_6 = new JPanel();
		this.panel_3.add(this.panel_6);
		this.panel_6.setLayout(new GridLayout(2, 0, 0, 0));

		this.panel_9 = new JPanel();
		this.panel_6.add(this.panel_9);
		this.panel_9.setLayout(new GridLayout(2, 0, 0, 0));

		this.panel_11 = new JPanel();
		this.panel_9.add(this.panel_11);
		this.panel_11.setLayout(new GridLayout(2, 1, 0, 0));

		this.panel_32 = new JPanel();
		this.panel_11.add(this.panel_32);

		this.Label_Domicilio = new JLabel("Domicilio :");
		this.panel_32.add(this.Label_Domicilio);

		this.panel_31 = new JPanel();
		this.panel_11.add(this.panel_31);

		this.panel_10 = new JPanel();
		this.panel_9.add(this.panel_10);
		this.panel_10.setLayout(new GridLayout(2, 0, 0, 0));

		this.panel_33 = new JPanel();
		this.panel_10.add(this.panel_33);

		this.lblNewLabel_CantCables = new JLabel("Cantidad de Cables :");
		this.panel_33.add(this.lblNewLabel_CantCables);

		this.panel_34 = new JPanel();
		this.panel_10.add(this.panel_34);

		this.panel_8 = new JPanel();
		this.panel_6.add(this.panel_8);
		this.panel_8.setLayout(new GridLayout(2, 2, 0, 0));

		this.panel_12 = new JPanel();
		this.panel_8.add(this.panel_12);

		this.btnNewButton_EliCelu = new JButton("Eliminar Celular");
		this.btnNewButton_EliCelu.setActionCommand("ELIMCELULAR");
		this.panel_12.add(this.btnNewButton_EliCelu);

		this.panel_13 = new JPanel();
		this.panel_8.add(this.panel_13);

		this.btn_ElTelef = new JButton("Eliminar Telefono");
		this.btn_ElTelef.setActionCommand("ELIMTELEFONO");
		this.panel_13.add(this.btn_ElTelef);

		this.panel_14 = new JPanel();
		this.panel_8.add(this.panel_14);

		this.btnNewButton_EliContrato = new JButton("Eliminar Contrato");
		this.btnNewButton_EliContrato.setActionCommand("ELIMCONTRATO");
		this.panel_14.add(this.btnNewButton_EliContrato);

		this.panel_15 = new JPanel();
		this.panel_8.add(this.panel_15);
		this.panel_15.setLayout(new GridLayout(2, 0, 0, 0));

		this.panel_36 = new JPanel();
		this.panel_15.add(this.panel_36);

		this.btnElimCable = new JButton("Eliminar Cable");
		this.btnElimCable.setActionCommand("ELIMCABLE");
		this.btnElimCable.setEnabled(false);
		this.panel_36.add(this.btnElimCable);

		this.panel_35 = new JPanel();
		this.panel_15.add(this.panel_35);

		this.lblNewLabel = new JLabel("Cantidad:");
		this.panel_35.add(this.lblNewLabel);

		this.textField_CantCableElim = new JTextField();
		this.textField_CantCableElim.addKeyListener(this);
		this.panel_35.add(this.textField_CantCableElim);
		this.textField_CantCableElim.setColumns(10);

		this.panel_4 = new JPanel();
		this.panel_4.setBorder(new TitledBorder(new LineBorder(new Color(64, 64, 64), 3, true), "Lista de Celulares",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.DARK_GRAY));
		this.panel_1.add(this.panel_4);
		this.panel_4.setLayout(new BorderLayout(0, 0));

		this.scrollPane = new JScrollPane();
		this.panel_4.add(this.scrollPane, BorderLayout.CENTER);

		this.list_Celulares = new JList<Celular>();
		this.modeloListaCelulares = new DefaultListModel<Celular>();
		this.list_Celulares.setModel(modeloListaCelulares);
		this.scrollPane.setViewportView(this.list_Celulares);

		this.panel_5 = new JPanel();
		this.panel_5.setBorder(new TitledBorder(new LineBorder(new Color(64, 64, 64), 3, true), "Lista de Telefonos",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panel_1.add(this.panel_5);
		this.panel_5.setLayout(new BorderLayout(0, 0));

		this.scrollPane_1 = new JScrollPane();
		this.panel_5.add(this.scrollPane_1, BorderLayout.CENTER);

		this.list_Telefonos = new JList<Telefono>();
		this.modeloListaTelefonos = new DefaultListModel<Telefono>();
		this.list_Telefonos.setModel(modeloListaTelefonos);
		this.scrollPane_1.setViewportView(this.list_Telefonos);

		this.panel_2 = new JPanel();
		this.panel_2.setBorder(new LineBorder(new Color(255, 200, 0), 3, true));
		this.panel.add(this.panel_2, BorderLayout.SOUTH);
		this.panel_2.setPreferredSize(new Dimension(90, 90));
		this.panel_2.setLayout(new GridLayout(0, 3, 0, 0));

		this.panel_16 = new JPanel();
		this.panel_2.add(this.panel_16);
		this.panel_16.setLayout(new GridLayout(2, 0, 0, 0));

		this.panel_20 = new JPanel();
		this.panel_16.add(this.panel_20);
		this.panel_20.setLayout(new GridLayout(0, 2, 0, 0));

		this.panel_21 = new JPanel();
		this.panel_20.add(this.panel_21);

		this.lblNewLabel_1 = new JLabel("Calle :");
		this.panel_21.add(this.lblNewLabel_1);

		this.textField_Calle = new JTextField();
		this.textField_Calle.addKeyListener(this);
		this.panel_21.add(this.textField_Calle);
		this.textField_Calle.setColumns(10);

		this.panel_22 = new JPanel();
		this.panel_20.add(this.panel_22);

		this.lblNewLabel_2 = new JLabel("Numero :");
		this.panel_22.add(this.lblNewLabel_2);

		this.textField_Numero = new JTextField();
		this.textField_Numero.addKeyListener(this);
		this.panel_22.add(this.textField_Numero);
		this.textField_Numero.setColumns(10);

		this.panel_19 = new JPanel();
		this.panel_16.add(this.panel_19);

		this.btnNewButton_Atras = new JButton("Atras");
		this.btnNewButton_Atras.setActionCommand("ATRAS");
		this.panel_19.add(this.btnNewButton_Atras);

		this.btnNewButton_Crear = new JButton("Crear Contrato");
		this.btnNewButton_Crear.setActionCommand("CREARCONTRATO");
		this.btnNewButton_Crear.setEnabled(false);
		this.panel_19.add(this.btnNewButton_Crear);

		this.panel_17 = new JPanel();
		this.panel_2.add(this.panel_17);
		this.panel_17.setLayout(new GridLayout(3, 0, 0, 0));

		this.panel_24 = new JPanel();
		this.panel_17.add(this.panel_24);

		this.lblNewLabel_3 = new JLabel("Medio de pago :");
		this.panel_24.add(this.lblNewLabel_3);

		this.rdbtnNewRadioButton_Cheque = new JRadioButton("Cheque");
		buttonGroup.add(this.rdbtnNewRadioButton_Cheque);
		this.panel_24.add(this.rdbtnNewRadioButton_Cheque);

		this.rdbtnNewRadioButton_Efectivo = new JRadioButton("Efectivo");
		this.rdbtnNewRadioButton_Efectivo.setSelected(true);
		buttonGroup.add(this.rdbtnNewRadioButton_Efectivo);
		this.panel_24.add(this.rdbtnNewRadioButton_Efectivo);

		this.rdbtnNewRadioButton_Tarjeta = new JRadioButton("Tarjeta");
		buttonGroup.add(this.rdbtnNewRadioButton_Tarjeta);
		this.panel_24.add(this.rdbtnNewRadioButton_Tarjeta);

		this.panel_25 = new JPanel();
		this.panel_17.add(this.panel_25);

		this.lblNewLabel_4 = new JLabel("Internet :");
		this.panel_25.add(this.lblNewLabel_4);

		this.rdbtnNewRadioButton_Internet100 = new JRadioButton("100");
		this.rdbtnNewRadioButton_Internet100.setSelected(true);
		buttonGroup_1.add(this.rdbtnNewRadioButton_Internet100);
		this.panel_25.add(this.rdbtnNewRadioButton_Internet100);

		this.rdbtnNewRadioButton_Internet500 = new JRadioButton("500");
		buttonGroup_1.add(this.rdbtnNewRadioButton_Internet500);
		this.panel_25.add(this.rdbtnNewRadioButton_Internet500);

		this.panel_23 = new JPanel();
		this.panel_17.add(this.panel_23);

		this.btnNewButton_Modificar = new JButton("Modificar");
		this.btnNewButton_Modificar.setActionCommand("MODIFICAR");
		this.panel_23.add(this.btnNewButton_Modificar);

		this.panel_18 = new JPanel();
		this.panel_2.add(this.panel_18);
		this.panel_18.setLayout(new GridLayout(3, 0, 0, 0));

		this.panel_26 = new JPanel();
		this.panel_18.add(this.panel_26);
		this.panel_26.setLayout(new GridLayout(0, 2, 0, 0));

		this.panel_29 = new JPanel();
		this.panel_26.add(this.panel_29);

		this.lblNewLabel_5 = new JLabel("Celulares :");
		this.panel_29.add(this.lblNewLabel_5);

		this.textField_Celulares = new JTextField();
		this.textField_Celulares.addKeyListener(this);
		this.textField_Celulares.setText("");
		this.panel_29.add(this.textField_Celulares);
		this.textField_Celulares.setColumns(10);

		this.panel_30 = new JPanel();
		this.panel_26.add(this.panel_30);

		this.lblNewLabel_6 = new JLabel("Cables : ");
		this.panel_30.add(this.lblNewLabel_6);

		this.textField_Cable = new JTextField();
		this.textField_Cable.addKeyListener(this);
		this.panel_30.add(this.textField_Cable);
		this.textField_Cable.setColumns(10);

		this.panel_27 = new JPanel();
		this.panel_18.add(this.panel_27);

		this.lblNewLabel_7 = new JLabel("Telefonos :");
		this.panel_27.add(this.lblNewLabel_7);

		this.textField_Telefonos = new JTextField();
		this.textField_Telefonos.addKeyListener(this);
		this.textField_Telefonos.setText("");
		this.panel_27.add(this.textField_Telefonos);
		this.textField_Telefonos.setColumns(10);

		this.panel_28 = new JPanel();
		this.panel_18.add(this.panel_28);

		this.btnNewButton_Agregar = new JButton("Agregar");
		this.btnNewButton_Agregar.setActionCommand("AGREGAR");
		this.btnNewButton_Agregar.setEnabled(false);
		this.panel_28.add(this.btnNewButton_Agregar);

		this.frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.frame.setVisible(true);
	}

	public void setActionListener(ActionListener actionListener) {
		this.btn_ElTelef.addActionListener(actionListener);
		this.btnElimCable.addActionListener(actionListener);
		this.btnNewButton_Agregar.addActionListener(actionListener);
		this.btnNewButton_Atras.addActionListener(actionListener);
		this.btnNewButton_Crear.addActionListener(actionListener);
		this.btnNewButton_EliCelu.addActionListener(actionListener);
		this.btnNewButton_EliContrato.addActionListener(actionListener);
		this.btnNewButton_Modificar.addActionListener(actionListener);
		this.actionListener = actionListener;
	}

	public void keyPressed(KeyEvent arg0) {
	}

	public void keyReleased(KeyEvent arg0) {
		String calle = this.textField_Calle.getText();
		int numeroCalle = 0;
		int celulares = 0;
		int cables = 0;
		int telefonos = 0;
		int cantidad = 0;
		try {
			numeroCalle = Integer.parseInt(this.textField_Numero.getText());

		} catch (NumberFormatException e) {
		}
		try {
			celulares = Integer.parseInt(this.textField_Celulares.getText());
		} catch (NumberFormatException e) {
		}
		try {
			cables = Integer.parseInt(this.textField_Cable.getText());
		} catch (NumberFormatException e) {
		}
		try {
			telefonos = Integer.parseInt(this.textField_Telefonos.getText());
		} catch (NumberFormatException e) {
		}
		try {
			cantidad = Integer.parseInt(this.textField_CantCableElim.getText());
		} catch (NumberFormatException e) {
		}

		boolean condicion = numeroCalle > 0 && !calle.isEmpty();
		this.btnNewButton_Crear.setEnabled(condicion);

		condicion = (celulares > 0 || cables > 0 || telefonos > 0) && (celulares >= 0 && cables >= 0 && telefonos >= 0);
		this.btnNewButton_Agregar.setEnabled(condicion);

		condicion = cantidad > 0;
		this.btnElimCable.setEnabled(condicion);

	}

	public void keyTyped(KeyEvent arg0) {
	}

	public Contrato getContrato() {
		return (Contrato) this.list_Contratos.getSelectedValue();
	}

	public void actualizaListaContratos(ArrayList<Contrato> contratos) {
		this.modeloListaContratos.clear();
		Iterator<Contrato> it = contratos.iterator();
		while (it.hasNext())
			this.modeloListaContratos.addElement(it.next());
		this.repaint();
	}

	public Telefono getTelefono() {
		return (Telefono) this.list_Telefonos.getSelectedValue();
	}

	public void actualizaListaTelefonos(ArrayList<Telefono> telefonos) {
		this.modeloListaTelefonos.clear();
		Iterator<Telefono> it = telefonos.iterator();
		while (it.hasNext())
			this.modeloListaTelefonos.addElement(it.next());
		this.repaint();
	}

	public Celular getCelular() {
		return (Celular) this.list_Celulares.getSelectedValue();
	}

	public void actualizaListaCelulares(ArrayList<Celular> celulares) {
		this.modeloListaCelulares.clear();
		Iterator<Celular> it = celulares.iterator();
		while (it.hasNext())
			this.modeloListaCelulares.addElement(it.next());
		this.repaint();
	}

	public void cerrar() {
		this.frame.dispose();
	}

	public String getCalle() {
		String calle = this.textField_Calle.getText();
		return calle;
	}

	public void selectMedioPago(String medioPago) {
		if (medioPago.equals("Efectivo")) {
			this.rdbtnNewRadioButton_Efectivo.setSelected(true);
		} else if (medioPago.equals("Tarjeta")) {
			this.rdbtnNewRadioButton_Tarjeta.setSelected(true);
		} else if (medioPago.equals("Efectivo")) {
			this.rdbtnNewRadioButton_Cheque.setSelected(true);
		}
	}

	public void selectTipoInternet(String internet) {
		if (internet.equals("100")) {
			this.rdbtnNewRadioButton_Internet100.setSelected(true);
		} else if (internet.equals("500")) {
			this.rdbtnNewRadioButton_Internet500.setSelected(true);
		}
	}

	public int getNumero() {
		int numero = Integer.parseInt(this.textField_Numero.getText());
		return numero;
	}

	public int getCantCelulares() {
		int cant;
		try {
			cant = Integer.parseInt(this.textField_Celulares.getText());
		} catch (NumberFormatException e) {
			cant = 0;
		}
		return cant;
	}

	public int getCantTelefonos() {
		int cant;
		try {
			cant = Integer.parseInt(this.textField_Telefonos.getText());
		} catch (NumberFormatException e) {
			cant = 0;
		}
		return cant;
	}

	public int getCantCables() {
		int cant;
		try {
			cant = Integer.parseInt(this.textField_Cable.getText());
		} catch (NumberFormatException e) {
			cant = 0;
		}
		return cant;
	}

	public String getTipoInternet() {
		String internet = "";
		if (this.rdbtnNewRadioButton_Internet100.isSelected()) {
			internet = "100";
		} else if (this.rdbtnNewRadioButton_Internet500.isSelected()) {
			internet = "500";
		}
		return internet;
	}

	public String getMedioPago() {
		String medioPago = "";
		if (this.rdbtnNewRadioButton_Cheque.isSelected()) {
			medioPago = "Cheque";
		} else if (this.rdbtnNewRadioButton_Tarjeta.isSelected()) {
			medioPago = "Tarjeta";
		} else if (this.rdbtnNewRadioButton_Efectivo.isSelected()) {
			medioPago = "Efectivo";
		}
		return medioPago;
	}

	public void setTipoInternet(String tipoInternet) {
		if (tipoInternet.equals("100")) {
			this.rdbtnNewRadioButton_Internet100.setSelected(true);
		} else if (tipoInternet.equals("500")) {
			this.rdbtnNewRadioButton_Internet500.setSelected(true);
		}
	}

	public void setMedioPago(String medioPago) {
		if (medioPago.equals("Cheque")) {
			this.rdbtnNewRadioButton_Cheque.setSelected(true);
		} else if (medioPago.equals("Tarjeta")) {
			this.rdbtnNewRadioButton_Tarjeta.setSelected(true);
		} else if (medioPago.equals("Efectivo")) {
			this.rdbtnNewRadioButton_Efectivo.setSelected(true);
		}
	}

	public int getCantCablesElim() {
		int cant = Integer.parseInt(this.textField_CantCableElim.getText());
		return cant;
	}

	public void setListSelectionListenerContratos(ListSelectionListener listSelectionListener) {
		this.list_Contratos.addListSelectionListener(listSelectionListener);
	}

	public void imprimeMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}

	public void actualizaCables(int cant) {
		this.lblNewLabel_CantCables.setText("Cantidad de Cables: " + cant);
	}

	public void actualizaDomicilio(int numero, String calle) {
		this.Label_Domicilio.setText("Domicilio: " + calle + " " + numero);
	}

	public void limpiaListaCelulares() {
		this.modeloListaCelulares.clear();
	}

	public void limpiaListaTelefonos() {
		this.modeloListaTelefonos.clear();
	}
	
	public void vaciarTextFields() {
		this.textField_Cable.setText("");
		this.textField_Celulares.setText("");
		this.textField_Telefonos.setText("");
		this.textField_Numero.setText("");
		this.textField_Calle.setText("");
		this.textField_CantCableElim.setText("");
		this.btnElimCable.setEnabled(false);
		this.btnNewButton_Agregar.setEnabled(false);
		this.btnNewButton_Crear.setEnabled(false);
	}
}

package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class MContrato_Menu {

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
	private JList list;
	private JScrollPane scrollPane_1;
	private JList list_1;
	private JScrollPane scrollPane_2;
	private JList list_2;
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
	private JButton btnNewButton_EliCable;
	private JTextField txt_ElimCable;
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
	private JRadioButton rdbtnNewRadioButton_Cheque_Efectivo;
	private JRadioButton rdbtnNewRadioButton_Cheque_Tarjeta;
	private JLabel lblNewLabel_4;
	private JRadioButton rdbtnNewRadioButton_Cheque_Internet100;
	private JRadioButton rdbtnNewRadioButton_Cheque_Internet500;
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
	private JLabel Label_Nombre;
	private JPanel panel_33;
	private JPanel panel_34;
	private JLabel lblNewLabel;
	private JLabel lblDni;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MContrato_Menu window = new MContrato_Menu();
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
	public MContrato_Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.frame = new JFrame();
		this.frame.setBounds(100, 100, 1100, 578);
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
		this.panel_7.setBorder(new TitledBorder(new LineBorder(new Color(64, 64, 64), 3, true), "Lista de Contratos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panel_3.add(this.panel_7);
		this.panel_7.setLayout(new BorderLayout(0, 0));
		
		this.scrollPane_2 = new JScrollPane();
		this.panel_7.add(this.scrollPane_2, BorderLayout.CENTER);
		
		this.list_2 = new JList();
		this.scrollPane_2.setViewportView(this.list_2);
		
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
		
		this.Label_Nombre = new JLabel("Nombre :");
		this.panel_31.add(this.Label_Nombre);
		
		this.panel_10 = new JPanel();
		this.panel_9.add(this.panel_10);
		this.panel_10.setLayout(new GridLayout(2, 0, 0, 0));
		
		this.panel_33 = new JPanel();
		this.panel_10.add(this.panel_33);
		
		this.lblDni = new JLabel("DNI :");
		this.panel_33.add(this.lblDni);
		
		this.panel_34 = new JPanel();
		this.panel_10.add(this.panel_34);
		
		this.lblNewLabel = new JLabel("Cantidad de Cables :");
		this.panel_34.add(this.lblNewLabel);
		
		this.panel_8 = new JPanel();
		this.panel_6.add(this.panel_8);
		this.panel_8.setLayout(new GridLayout(2, 2, 0, 0));
		
		this.panel_12 = new JPanel();
		this.panel_8.add(this.panel_12);
		
		this.btnNewButton_EliCelu = new JButton("Eliminar Celular");
		this.panel_12.add(this.btnNewButton_EliCelu);
		
		this.panel_13 = new JPanel();
		this.panel_8.add(this.panel_13);
		
		this.btn_ElTelef = new JButton("Eliminar Telefono");
		this.panel_13.add(this.btn_ElTelef);
		
		this.panel_14 = new JPanel();
		this.panel_8.add(this.panel_14);
		
		this.btnNewButton_EliContrato = new JButton("Eliminar Contrato");
		this.panel_14.add(this.btnNewButton_EliContrato);
		
		this.panel_15 = new JPanel();
		this.panel_8.add(this.panel_15);
		
		this.btnNewButton_EliCable = new JButton("Eliminar Cable");
		this.panel_15.add(this.btnNewButton_EliCable);
		
		this.txt_ElimCable = new JTextField();
		this.txt_ElimCable.setText("Cant. a Eliminar");
		this.panel_15.add(this.txt_ElimCable);
		this.txt_ElimCable.setColumns(10);
		
		this.panel_4 = new JPanel();
		this.panel_4.setBorder(new TitledBorder(new LineBorder(new Color(64, 64, 64), 3, true), "Lista de Celulares", TitledBorder.LEADING, TitledBorder.TOP, null, Color.DARK_GRAY));
		this.panel_1.add(this.panel_4);
		this.panel_4.setLayout(new BorderLayout(0, 0));
		
		this.scrollPane = new JScrollPane();
		this.panel_4.add(this.scrollPane, BorderLayout.CENTER);
		
		this.list = new JList();
		this.scrollPane.setViewportView(this.list);
		
		this.panel_5 = new JPanel();
		this.panel_5.setBorder(new TitledBorder(new LineBorder(new Color(64, 64, 64), 3, true), "Lista de Telefonos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panel_1.add(this.panel_5);
		this.panel_5.setLayout(new BorderLayout(0, 0));
		
		this.scrollPane_1 = new JScrollPane();
		this.panel_5.add(this.scrollPane_1, BorderLayout.CENTER);
		
		this.list_1 = new JList();
		this.scrollPane_1.setViewportView(this.list_1);
		
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
		this.panel_21.add(this.textField_Calle);
		this.textField_Calle.setColumns(10);
		
		this.panel_22 = new JPanel();
		this.panel_20.add(this.panel_22);
		
		this.lblNewLabel_2 = new JLabel("Numero :");
		this.panel_22.add(this.lblNewLabel_2);
		
		this.textField_Numero = new JTextField();
		this.panel_22.add(this.textField_Numero);
		this.textField_Numero.setColumns(10);
		
		this.panel_19 = new JPanel();
		this.panel_16.add(this.panel_19);
		
		this.btnNewButton_Atras = new JButton("Atras");
		this.panel_19.add(this.btnNewButton_Atras);
		
		this.btnNewButton_Crear = new JButton("Crear Contrato");
		this.panel_19.add(this.btnNewButton_Crear);
		
		this.panel_17 = new JPanel();
		this.panel_2.add(this.panel_17);
		this.panel_17.setLayout(new GridLayout(3, 0, 0, 0));
		
		this.panel_24 = new JPanel();
		this.panel_17.add(this.panel_24);
		
		this.lblNewLabel_3 = new JLabel("Medio de pago :");
		this.panel_24.add(this.lblNewLabel_3);
		
		this.rdbtnNewRadioButton_Cheque = new JRadioButton("Cheque");
		this.panel_24.add(this.rdbtnNewRadioButton_Cheque);
		
		this.rdbtnNewRadioButton_Cheque_Efectivo = new JRadioButton("Efectivo");
		this.panel_24.add(this.rdbtnNewRadioButton_Cheque_Efectivo);
		
		this.rdbtnNewRadioButton_Cheque_Tarjeta = new JRadioButton("Tarjeta");
		this.panel_24.add(this.rdbtnNewRadioButton_Cheque_Tarjeta);
		
		this.panel_25 = new JPanel();
		this.panel_17.add(this.panel_25);
		
		this.lblNewLabel_4 = new JLabel("Internet :");
		this.panel_25.add(this.lblNewLabel_4);
		
		this.rdbtnNewRadioButton_Cheque_Internet100 = new JRadioButton("100");
		this.panel_25.add(this.rdbtnNewRadioButton_Cheque_Internet100);
		
		this.rdbtnNewRadioButton_Cheque_Internet500 = new JRadioButton("500");
		this.panel_25.add(this.rdbtnNewRadioButton_Cheque_Internet500);
		
		this.panel_23 = new JPanel();
		this.panel_17.add(this.panel_23);
		
		this.btnNewButton_Modificar = new JButton("Modificar");
		this.panel_23.add(this.btnNewButton_Modificar);
		
		this.panel_18 = new JPanel();
		this.panel_2.add(this.panel_18);
		this.panel_18.setLayout(new GridLayout(3, 0, 0, 0));
		
		this.panel_26 = new JPanel();
		this.panel_18.add(this.panel_26);
		this.panel_26.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.panel_29 = new JPanel();
		this.panel_26.add(this.panel_29);
		
		this.lblNewLabel_5 = new JLabel("Celular :");
		this.panel_29.add(this.lblNewLabel_5);
		
		this.textField_Celulares = new JTextField();
		this.textField_Celulares.setText("");
		this.panel_29.add(this.textField_Celulares);
		this.textField_Celulares.setColumns(10);
		
		this.panel_30 = new JPanel();
		this.panel_26.add(this.panel_30);
		
		this.lblNewLabel_6 = new JLabel("Cable : ");
		this.panel_30.add(this.lblNewLabel_6);
		
		this.textField_Cable = new JTextField();
		this.panel_30.add(this.textField_Cable);
		this.textField_Cable.setColumns(10);
		
		this.panel_27 = new JPanel();
		this.panel_18.add(this.panel_27);
		
		this.lblNewLabel_7 = new JLabel("Telefono :");
		this.panel_27.add(this.lblNewLabel_7);
		
		this.textField_Telefonos = new JTextField();
		this.textField_Telefonos.setText("");
		this.panel_27.add(this.textField_Telefonos);
		this.textField_Telefonos.setColumns(10);
		
		this.panel_28 = new JPanel();
		this.panel_18.add(this.panel_28);
		
		this.btnNewButton_Agregar = new JButton("Agregar");
		this.panel_28.add(this.btnNewButton_Agregar);
	}

}

package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Alta_menu implements KeyListener {

	private JFrame frame;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel panel_9;
	private JPanel panel_10;
	private JPanel panel_11;
	private JPanel panel_12;
	private JPanel panel_13;
	private JPanel panel_14;
	private JPanel panel_15;
	private JPanel panel_16;
	private JPanel panel_17;
	private JPanel panel_18;
	private JPanel panel_19;
	private JPanel panel_20;
	private JPanel panel_21;
	private JPanel panel_22;
	private JPanel panel_23;
	private JPanel panel_24;
	private JLabel lblNewLabel_3;
	private JRadioButton rdbtnNewRadioButton_Cheque;
	private JRadioButton rdbtnNewRadioButton_Efectivo;
	private JRadioButton rdbtnNewRadioButton_Tarjeta;
	private JButton btnNewButton_Atras;
	private JButton btnNewButton_DarAlta;
	private JPanel panel_25;
	private JPanel panel_26;
	private JLabel lblNewLabel_1;
	private JTextField textField_DNI;
	private JLabel lblNewLabel_2;
	private JTextField textField_Nombre;
	private JPanel panel_27;
	private JPanel panel_30;
	private JPanel panel_29;
	private JLabel lblNewLabel;
	private JRadioButton rdbtnNewRadioButton_Fisica_1;
	private JRadioButton rdbtnNewRadioButton_Juridica_1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Alta_menu window = new Alta_menu();
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
	public Alta_menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.frame = new JFrame();
		this.frame.setBounds(100, 100, 881, 390);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel = new JPanel();
		this.frame.getContentPane().add(this.panel, BorderLayout.CENTER);
		this.panel.setLayout(new GridLayout(6, 3, 0, 0));
		
		this.panel_1 = new JPanel();
		this.panel.add(this.panel_1);
		
		this.panel_2 = new JPanel();
		this.panel.add(this.panel_2);
		
		this.panel_3 = new JPanel();
		this.panel.add(this.panel_3);
		
		this.panel_4 = new JPanel();
		this.panel.add(this.panel_4);
		
		this.panel_5 = new JPanel();
		this.panel.add(this.panel_5);
		this.panel_5.setLayout(new GridLayout(2, 3, 0, 0));
		
		this.panel_27 = new JPanel();
		this.panel_5.add(this.panel_27);
		this.panel_27.setLayout(new GridLayout(0, 1, 0, 0));
		
		this.lblNewLabel = new JLabel("Tipo :");
		this.panel_27.add(this.lblNewLabel);
		
		this.rdbtnNewRadioButton_Juridica_1 = new JRadioButton("Juridica");
		buttonGroup.add(this.rdbtnNewRadioButton_Juridica_1);
		this.panel_5.add(this.rdbtnNewRadioButton_Juridica_1);
		
		this.rdbtnNewRadioButton_Fisica_1 = new JRadioButton("Fisica");
		this.rdbtnNewRadioButton_Fisica_1.setSelected(true);
		buttonGroup.add(this.rdbtnNewRadioButton_Fisica_1);
		this.panel_5.add(this.rdbtnNewRadioButton_Fisica_1);
		
		this.panel_30 = new JPanel();
		this.panel_5.add(this.panel_30);
		
		this.panel_29 = new JPanel();
		this.panel_5.add(this.panel_29);
		
		this.panel_6 = new JPanel();
		this.panel.add(this.panel_6);
		
		this.panel_7 = new JPanel();
		this.panel.add(this.panel_7);
		
		this.panel_8 = new JPanel();
		this.panel.add(this.panel_8);
		this.panel_8.setLayout(new GridLayout(1, 2, 0, 0));
		
		this.panel_25 = new JPanel();
		this.panel_8.add(this.panel_25);
		
		this.lblNewLabel_2 = new JLabel("Nombre :");
		this.panel_25.add(this.lblNewLabel_2);
		
		this.textField_Nombre = new JTextField();
		this.textField_Nombre.addKeyListener(this);
		this.panel_25.add(this.textField_Nombre);
		this.textField_Nombre.setColumns(10);
		
		this.panel_26 = new JPanel();
		this.panel_8.add(this.panel_26);
		
		this.lblNewLabel_1 = new JLabel("DNI :");
		this.panel_26.add(this.lblNewLabel_1);
		
		this.textField_DNI = new JTextField();
		this.textField_DNI.addKeyListener(this);
		this.textField_DNI.setText("");
		this.panel_26.add(this.textField_DNI);
		this.textField_DNI.setColumns(10);
		
		this.panel_9 = new JPanel();
		this.panel.add(this.panel_9);
		
		this.panel_10 = new JPanel();
		this.panel.add(this.panel_10);
		
		this.panel_11 = new JPanel();
		this.panel.add(this.panel_11);
		this.panel_11.setLayout(new GridLayout(2, 3, 0, 0));
		
		this.panel_20 = new JPanel();
		this.panel_11.add(this.panel_20);
		
		this.lblNewLabel_3 = new JLabel("Medio de Pago:");
		this.panel_20.add(this.lblNewLabel_3);
		
		this.panel_19 = new JPanel();
		this.panel_11.add(this.panel_19);
		
		this.panel_21 = new JPanel();
		this.panel_11.add(this.panel_21);
		
		this.panel_22 = new JPanel();
		this.panel_11.add(this.panel_22);
		
		this.rdbtnNewRadioButton_Cheque = new JRadioButton("Cheque");
		buttonGroup_1.add(this.rdbtnNewRadioButton_Cheque);
		this.panel_22.add(this.rdbtnNewRadioButton_Cheque);
		
		this.panel_23 = new JPanel();
		this.panel_11.add(this.panel_23);
		
		this.rdbtnNewRadioButton_Efectivo = new JRadioButton("Efectivo");
		this.rdbtnNewRadioButton_Efectivo.setSelected(true);
		buttonGroup_1.add(this.rdbtnNewRadioButton_Efectivo);
		this.panel_23.add(this.rdbtnNewRadioButton_Efectivo);
		
		this.panel_24 = new JPanel();
		this.panel_11.add(this.panel_24);
		
		this.rdbtnNewRadioButton_Tarjeta = new JRadioButton("Tarjeta");
		buttonGroup_1.add(this.rdbtnNewRadioButton_Tarjeta);
		this.panel_24.add(this.rdbtnNewRadioButton_Tarjeta);
		
		this.panel_12 = new JPanel();
		this.panel.add(this.panel_12);
		
		this.panel_13 = new JPanel();
		this.panel.add(this.panel_13);
		
		this.panel_14 = new JPanel();
		this.panel.add(this.panel_14);
		
		this.panel_15 = new JPanel();
		this.panel.add(this.panel_15);
		
		this.panel_16 = new JPanel();
		this.panel.add(this.panel_16);
		
		this.btnNewButton_Atras = new JButton("Atras");
		this.panel_16.add(this.btnNewButton_Atras);
		
		this.panel_17 = new JPanel();
		this.panel.add(this.panel_17);
		
		this.btnNewButton_DarAlta = new JButton("Dar de Alta");
		this.btnNewButton_DarAlta.setEnabled(false);
		this.panel_17.add(this.btnNewButton_DarAlta);
		
		this.panel_18 = new JPanel();
		this.panel.add(this.panel_18);
	}

	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
		int dni = 0;
		String nombre = this.textField_Nombre.getText(); 
		try {
			dni = Integer.parseInt(this.textField_DNI.getText());
			
		} catch (NumberFormatException e) {
		}

		boolean condicion = dni > 0 && !nombre.isEmpty();
		this.btnNewButton_DarAlta.setEnabled(condicion);
		
	}
	public void keyTyped(KeyEvent arg0) {
	}
}

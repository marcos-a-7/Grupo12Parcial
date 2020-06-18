package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JList;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

public class Interfaz {

	private JFrame frame;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_ListaPersonas;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel panel_9;
	private JPanel panel_10;
	private JPanel panel_11;
	private JButton btn_ActMes;
	private JButton btn_DarAlta;
	private JButton btn_ModiContra;
	private JButton btn_DarBaja;
	private JPanel panel_12;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JList list;
	private JList list_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz window = new Interfaz();
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
	public Interfaz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.frame = new JFrame();
		this.frame.setBounds(100, 100, 1100, 552);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel = new JPanel();
		this.frame.getContentPane().add(this.panel, BorderLayout.CENTER);
		this.panel.setLayout(new BorderLayout(0, 0));
		
		this.panel_1 = new JPanel();
		this.panel.add(this.panel_1, BorderLayout.CENTER);
		this.panel_1.setLayout(new GridLayout(0, 3, 0, 0));
		
		this.panel_3 = new JPanel();
		this.panel_1.add(this.panel_3);
		this.panel_3.setLayout(new GridLayout(6, 0, 0, 0));
		
		this.panel_7 = new JPanel();
		this.panel_3.add(this.panel_7);
		
		this.panel_8 = new JPanel();
		this.panel_3.add(this.panel_8);
		
		this.btn_ActMes = new JButton("Actualizar Mes");
		this.panel_8.add(this.btn_ActMes);
		
		this.panel_6 = new JPanel();
		this.panel_3.add(this.panel_6);
		
		this.btn_DarAlta = new JButton("Dar de Alta");
		this.panel_6.add(this.btn_DarAlta);
		
		this.panel_9 = new JPanel();
		this.panel_3.add(this.panel_9);
		
		this.btn_ModiContra = new JButton("Modifica Contrato");
		this.panel_9.add(this.btn_ModiContra);
		
		this.panel_10 = new JPanel();
		this.panel_3.add(this.panel_10);
		
		this.btn_DarBaja = new JButton("Dar de Baja");
		this.panel_10.add(this.btn_DarBaja);
		
		this.panel_11 = new JPanel();
		this.panel_3.add(this.panel_11);
		
		this.panel_ListaPersonas = new JPanel();
		this.panel_ListaPersonas.setBorder(new TitledBorder(new LineBorder(new Color(64, 64, 64), 3, true), "Listado de Personas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panel_1.add(this.panel_ListaPersonas);
		this.panel_ListaPersonas.setLayout(new BorderLayout(0, 0));
		
		this.scrollPane_1 = new JScrollPane();
		this.panel_ListaPersonas.add(this.scrollPane_1, BorderLayout.CENTER);
		
		this.list = new JList();
		this.scrollPane_1.setViewportView(this.list);
		
		this.panel_5 = new JPanel();
		this.panel_5.setBorder(new TitledBorder(new LineBorder(new Color(64, 64, 64), 3, true), "Listado de Contratos", TitledBorder.LEADING, TitledBorder.TOP, null, Color.DARK_GRAY));
		this.panel_1.add(this.panel_5);
		this.panel_5.setLayout(new BorderLayout(0, 0));
		
		this.scrollPane_2 = new JScrollPane();
		this.panel_5.add(this.scrollPane_2, BorderLayout.CENTER);
		
		this.list_1 = new JList();
		this.scrollPane_2.setViewportView(this.list_1);
		
		this.panel_2 = new JPanel();
		this.panel.add(this.panel_2, BorderLayout.SOUTH);
		this.panel_2.setPreferredSize(new Dimension(80, 80));
		this.panel_2.setLayout(new BorderLayout(0, 0));
		
		this.panel_12 = new JPanel();
		this.panel_12.setBorder(new LineBorder(new Color(255, 200, 0), 3, true));
		this.panel_2.add(this.panel_12, BorderLayout.CENTER);
		this.panel_12.setLayout(new GridLayout(1, 0, 0, 0));
		
		this.scrollPane = new JScrollPane();
		this.panel_12.add(this.scrollPane);
		
		this.textArea = new JTextArea();
		this.scrollPane.setViewportView(this.textArea);
		
		
	}

}

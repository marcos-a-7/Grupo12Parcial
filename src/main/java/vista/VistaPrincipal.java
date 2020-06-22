package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import javax.swing.DefaultListModel;
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
import javax.swing.event.ListSelectionListener;

import clientes.Persona;

import javax.swing.event.ListSelectionEvent;

public class VistaPrincipal extends JFrame {

	private JFrame frame;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_ListaPersonas;
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
	private JTextArea textArea_Eventos;
	private JScrollPane scrollPane_1;
	private JList<Persona> list_Personas;
	private ActionListener actionListener;
	private DefaultListModel<Persona> listaPersonas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaPrincipal window = new VistaPrincipal("");
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
	public VistaPrincipal(String nombre) {
		initialize(nombre);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String nombre) {
		this.frame = new JFrame(nombre);
		this.frame.setBounds(100, 100, 1100, 552);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.panel = new JPanel();
		this.frame.getContentPane().add(this.panel, BorderLayout.CENTER);
		this.panel.setLayout(new BorderLayout(0, 0));

		this.panel_1 = new JPanel();
		this.panel.add(this.panel_1, BorderLayout.CENTER);
		this.panel_1.setLayout(new GridLayout(0, 2, 0, 0));

		this.panel_3 = new JPanel();
		this.panel_1.add(this.panel_3);
		this.panel_3.setLayout(new GridLayout(6, 0, 0, 0));

		this.panel_7 = new JPanel();
		this.panel_3.add(this.panel_7);

		this.panel_8 = new JPanel();
		this.panel_3.add(this.panel_8);

		this.btn_ActMes = new JButton("Actualizar Mes");
		this.btn_ActMes.setActionCommand("ACTUALIZARMES");
		this.panel_8.add(this.btn_ActMes);

		this.panel_6 = new JPanel();
		this.panel_3.add(this.panel_6);

		this.btn_DarAlta = new JButton("Dar de Alta");
		this.btn_DarAlta.setActionCommand("DARALTA");
		this.panel_6.add(this.btn_DarAlta);

		this.panel_9 = new JPanel();
		this.panel_3.add(this.panel_9);

		this.btn_ModiContra = new JButton("Modifica Contrato");
		this.btn_ModiContra.setActionCommand("MODIFICACONTRATO");
		this.panel_9.add(this.btn_ModiContra);

		this.panel_10 = new JPanel();
		this.panel_3.add(this.panel_10);

		this.btn_DarBaja = new JButton("Dar de Baja");
		this.btn_DarBaja.setActionCommand("DARBAJA");
		this.panel_10.add(this.btn_DarBaja);

		this.panel_11 = new JPanel();
		this.panel_3.add(this.panel_11);

		this.panel_ListaPersonas = new JPanel();
		this.panel_ListaPersonas.setBorder(new TitledBorder(new LineBorder(new Color(64, 64, 64), 3, true),
				"Listado de Personas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panel_1.add(this.panel_ListaPersonas);
		this.panel_ListaPersonas.setLayout(new BorderLayout(0, 0));

		this.scrollPane_1 = new JScrollPane();
		this.panel_ListaPersonas.add(this.scrollPane_1, BorderLayout.CENTER);

		this.list_Personas = new JList<Persona>();
		this.scrollPane_1.setViewportView(this.list_Personas);
		this.listaPersonas = new DefaultListModel<Persona>();
		this.list_Personas.setModel(listaPersonas);

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

		this.textArea_Eventos = new JTextArea();
		this.scrollPane.setViewportView(this.textArea_Eventos);
		this.frame.setVisible(true);
	}

	public void setActionListener(ActionListener actionListener) {
		this.btn_ActMes.addActionListener(actionListener);
		this.btn_DarAlta.addActionListener(actionListener);
		this.btn_DarBaja.addActionListener(actionListener);
		this.btn_ModiContra.addActionListener(actionListener);
		this.actionListener = actionListener;
	}

	public Persona getPersona() {
		return (Persona) this.list_Personas.getSelectedValue();
	}

	public void actualizaListaPersonas(HashMap<Integer, Persona> personas) {
		this.listaPersonas.clear();
		Set<Entry<Integer, Persona>> entrySet = personas.entrySet();
		Iterator<Entry<Integer, Persona>> it = entrySet.iterator();
		while (it.hasNext())
			this.listaPersonas.addElement(it.next().getValue());
		this.repaint();
	}
	
	public void imprimeEvento(String evento) {
		this.textArea_Eventos.setText(this.textArea_Eventos.getText() + evento);
	}

}

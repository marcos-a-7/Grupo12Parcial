package vista;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionListener;

import controlador.ControladorAfip;
import modelo.Factura;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class VistaAfip extends JFrame {

	private JFrame frame;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JScrollPane scrollPane;
	private JList<Factura> list_Factura;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JTextArea textArea_Detalle;
	private JTextArea textArea_Reporte;
	private DefaultListModel<Factura> listaFacturas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaAfip window = new VistaAfip("");
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
	public VistaAfip(String nombre) {
		initialize(nombre);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String nombre) {
		this.frame = new JFrame(nombre);
		this.frame.setBounds(100, 100, 848, 553);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.panel = new JPanel();
		this.frame.getContentPane().add(this.panel, BorderLayout.CENTER);
		this.panel.setLayout(new GridLayout(0, 2, 0, 0));

		this.panel_1 = new JPanel();
		this.panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 3, true), "Reporte",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panel.add(this.panel_1);
		this.panel_1.setLayout(new BorderLayout(0, 0));

		this.scrollPane_2 = new JScrollPane();
		this.panel_1.add(this.scrollPane_2, BorderLayout.CENTER);

		this.textArea_Reporte = new JTextArea();
		this.textArea_Reporte.setEditable(false);
		this.scrollPane_2.setViewportView(this.textArea_Reporte);

		this.panel_2 = new JPanel();
		this.panel.add(this.panel_2);
		this.panel_2.setLayout(new GridLayout(2, 0, 0, 0));

		this.panel_3 = new JPanel();
		this.panel_3.setBorder(new TitledBorder(new LineBorder(new Color(30, 144, 255), 3, true), "Lista de Facturas",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panel_2.add(this.panel_3);
		this.panel_3.setLayout(new BorderLayout(0, 0));

		this.scrollPane = new JScrollPane();
		this.panel_3.add(this.scrollPane, BorderLayout.CENTER);

		this.list_Factura = new JList<Factura>();
		this.scrollPane.setViewportView(this.list_Factura);
		this.listaFacturas = new DefaultListModel<Factura>();
		this.list_Factura.setModel(listaFacturas);

		this.panel_4 = new JPanel();
		this.panel_4.setBorder(new TitledBorder(new LineBorder(new Color(30, 144, 255), 3, true), "Detalles",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panel_2.add(this.panel_4);
		this.panel_4.setLayout(new BorderLayout(0, 0));

		this.scrollPane_1 = new JScrollPane();
		this.panel_4.add(this.scrollPane_1, BorderLayout.CENTER);

		this.textArea_Detalle = new JTextArea();
		this.textArea_Detalle.setEditable(false);
		this.scrollPane_1.setViewportView(this.textArea_Detalle);

		this.frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.frame.setVisible(true);
	}

	public void setListSelectionListener(ListSelectionListener listSelectionListener) {
		this.list_Factura.addListSelectionListener(listSelectionListener);
	}

	public void setWindowListener(WindowListener windowListener) {
		this.frame.addWindowListener(windowListener);
	}

	public void setReporte(String reporte) {
		this.textArea_Reporte.setText(reporte);
	}

	public Factura getFactura() {
		return this.list_Factura.getSelectedValue();
	}

	/**
	 * actualizaListaFacturas<br>
	 * actualiza la lista de facturas y la reescribe<br>
	 * @param facturas : lista de facturas a escribir
	 */
	public void actualizaListaFacturas(ArrayList<Factura> facturas) {
		this.listaFacturas.clear();
		Iterator<Factura> it = facturas.iterator();
		while (it.hasNext())
			this.listaFacturas.addElement(it.next());
		this.repaint();
	}

	/**
	 * imprimeFactura<>br>
	 * imprime una factura en el text area de detalle
	 * 
	 * @param factura
	 */
	public void imprimeFactura(String factura) {
		this.textArea_Detalle.setText(factura);
	}

}

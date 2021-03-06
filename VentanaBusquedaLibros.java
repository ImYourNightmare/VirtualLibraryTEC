package control;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

public class VentanaBusquedaLibros extends JFrame {
	private VentanaConsultaLibros ventana1;
	private static int a=0;
	private JPanel contentPane;
	private JTable tablalibros;
	private JTextField txtnombrebuscar;
	static DefaultTableModel model = new DefaultTableModel();
	public static GestionBusquedaLibros buscarlibros = new GestionBusquedaLibros();
	private JComboBox<String> cmbTema;
	public static Libro libro;
	public static JComboBox<Object> libreriabox = new JComboBox<Object>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaBusquedaLibros frame = new VentanaBusquedaLibros();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaBusquedaLibros() {
		setTitle("Buscar Libros");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 452, 582);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFiltros = new JLabel("Filtros");
		lblFiltros.setBounds(190, 11, 46, 14);
		contentPane.add(lblFiltros);
		
		JLabel lblLibreria = new JLabel("Libreria");
		lblLibreria.setBounds(10, 35, 46, 14);
		contentPane.add(lblLibreria);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 60, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblTema = new JLabel("Tema");
		lblTema.setBounds(10, 85, 46, 14);
		contentPane.add(lblTema);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(10, 110, 46, 14);
		contentPane.add(lblPrecio);
		
		
		
		JLabel lblMinmo = new JLabel("M\u00EDnimo");
		lblMinmo.setBounds(66, 110, 46, 14);
		contentPane.add(lblMinmo);
		
		JSpinner spinnerminimo = new JSpinner();
		spinnerminimo.setBounds(108, 107, 55, 20);
		contentPane.add(spinnerminimo);
		
		JLabel lblMximo = new JLabel("M\u00E1ximo");
		lblMximo.setBounds(176, 110, 46, 14);
		contentPane.add(lblMximo);
		
		JSpinner spinnermaximo = new JSpinner();
		spinnermaximo.setBounds(222, 107, 48, 20);
		contentPane.add(spinnermaximo);
		
		tablalibros = new JTable(model);
		tablalibros.setCellSelectionEnabled(true);
		tablalibros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablalibros.setBounds(10, 188, 354, 240);
		contentPane.add(tablalibros);
		model.addColumn("Issn");
		model.addColumn("Nombre");
		model.addColumn("Tema");
		
		JButton btnBuscar = new JButton("Buscar");
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				model.setRowCount(0);
				buscarlibros.buscarpornombre_libreria_tema_precio((Libreria)libreriabox.getSelectedItem(), txtnombrebuscar.getText(), cmbTema.getSelectedItem().toString(),(Integer)spinnerminimo.getValue(),(Integer)spinnermaximo.getValue());
			}
		});
		btnBuscar.setBounds(275, 31, 89, 23);
		contentPane.add(btnBuscar);
		
		txtnombrebuscar = new JTextField();
		txtnombrebuscar.setBounds(66, 57, 162, 20);
		contentPane.add(txtnombrebuscar);
		txtnombrebuscar.setColumns(10);
		
		JLabel lblIssn = new JLabel("Issn");
		lblIssn.setBounds(10, 163, 46, 14);
		contentPane.add(lblIssn);
		
		JLabel lblnombre = new JLabel("Nombre");
		lblnombre.setBounds(127, 163, 46, 14);
		contentPane.add(lblnombre);
		
		JLabel lblTema_1 = new JLabel("Tema");
		lblTema_1.setBounds(247, 163, 46, 14);
		contentPane.add(lblTema_1);
		
		JButton btnBuscarPorNombre = new JButton("Buscar por Nombre");
		btnBuscarPorNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				model.setRowCount(0);
				buscarlibros.buscarpornombre(txtnombrebuscar.getText());
			}
		});
		btnBuscarPorNombre.setHorizontalAlignment(SwingConstants.LEFT);
		btnBuscarPorNombre.setBounds(275, 56, 151, 23);
		contentPane.add(btnBuscarPorNombre);
		
		JButton btnBuscarPorLibreria_1 = new JButton("Buscar por Libreria");
		btnBuscarPorLibreria_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
				buscarlibros.buscarporlibreria((Libreria)libreriabox.getSelectedItem());
			}
		});
		btnBuscarPorLibreria_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnBuscarPorLibreria_1.setBounds(275, 81, 151, 23);
		contentPane.add(btnBuscarPorLibreria_1);
		
		JButton btnBuscarPorTema = new JButton("Buscar por Tema");
		btnBuscarPorTema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
				buscarlibros.buscarportema(cmbTema.getSelectedItem().toString());
			}
		});
		btnBuscarPorTema.setHorizontalAlignment(SwingConstants.LEFT);
		btnBuscarPorTema.setBounds(275, 106, 151, 23);
		contentPane.add(btnBuscarPorTema);
		
		JButton btnBuscarPorPrecio = new JButton("Buscar por Precio");
		btnBuscarPorPrecio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
				buscarlibros.buscarporprecio((Integer)spinnerminimo.getValue(), (Integer)spinnermaximo.getValue());
			}
		});
		btnBuscarPorPrecio.setHorizontalAlignment(SwingConstants.LEFT);
		btnBuscarPorPrecio.setBounds(275, 129, 151, 23);
		contentPane.add(btnBuscarPorPrecio);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(a==0) {
					ventana1 = new VentanaConsultaLibros();
				}
				int column=tablalibros.getSelectedColumn();
				int row=tablalibros.getSelectedRow();
				libro = (Libro)tablalibros.getValueAt(row, column);
				buscarlibros.append(libro);
				ventana1.setVisible(true);
				String textovendida=String.valueOf(libro.CantidadVendida);
				String textodisponible=String.valueOf(libro.CantidadDisponible);
				String textoprecio=String.valueOf(libro.Precio);
				VentanaConsultaLibros.txtissn.setText(libro.Issn);
				VentanaConsultaLibros.txtnombre.setText(libro.Nombre);
				VentanaConsultaLibros.txttema.setText(libro.Tema);
				VentanaConsultaLibros.txtdescripcion.setText(libro.Descripcion);
				VentanaConsultaLibros.txtvendida.setText(textovendida);
				VentanaConsultaLibros.txtdisponible.setText(textodisponible);
				VentanaConsultaLibros.txtprecio.setText(textoprecio);
			}
		});
		btnConsultar.setBounds(10, 439, 89, 23);
		contentPane.add(btnConsultar);
		
		JButton btnVolver_1 = new JButton("Volver");
		btnVolver_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaBusquedaLibros.this.hide();
			}
		});
		btnVolver_1.setBounds(10, 473, 89, 23);
		contentPane.add(btnVolver_1);
		
		cmbTema = new JComboBox<String>();
		cmbTema.setModel(new DefaultComboBoxModel<String>(new String[] {"Ingenier\u00EDa", "Administraci\u00F3n", "Ciencias Naturales", "Artes", "Historia", "Matem\u00E1ticas"}));
		cmbTema.setBounds(66, 82, 162, 17);
		contentPane.add(cmbTema);
		
		JButton btnVerLibrosConsultados = new JButton("Ver Libros Consultados");
		btnVerLibrosConsultados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana1.setVisible(true);
			}
		});
		btnVerLibrosConsultados.setBounds(108, 439, 162, 23);
		contentPane.add(btnVerLibrosConsultados);
		
		libreriabox.setBounds(66, 32, 162, 20);
		contentPane.add(libreriabox);
	}
}

package view;

import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import controller.ControladorAsistente;
import controller.ControladorGimnasio;
import model.Asistente;
import model.Gimnasio;
import model.Localidad;


import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtffiltro;
	private JTextField jtfId;
	private JTextField jtfdni;
	private JTextField jtfNombre;
	private JTextField jtfApellidos;
	private JTextField jtffechanac;
	private JTextField jtfCuota;
	JComboBox<Gimnasio> jcbgimnasio;
	JComboBox<Asistente> jcbasistente;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	JCheckBox chbxActivo;
	private Object jcbLocalidad;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 487, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 63, 0, 255, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblgestionasistentesagimnasio = new JLabel("Gestion de asistentes a gimnasio");
		lblgestionasistentesagimnasio.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblgestionasistentesagimnasio = new GridBagConstraints();
		gbc_lblgestionasistentesagimnasio.insets = new Insets(0, 0, 5, 0);
		gbc_lblgestionasistentesagimnasio.gridwidth = 15;
		gbc_lblgestionasistentesagimnasio.gridx = 0;
		gbc_lblgestionasistentesagimnasio.gridy = 0;
		contentPane.add(lblgestionasistentesagimnasio, gbc_lblgestionasistentesagimnasio);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 15;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblGimnasio = new JLabel("Gimnasio:");
		GridBagConstraints gbc_lblGimnasio = new GridBagConstraints();
		gbc_lblGimnasio.insets = new Insets(0, 0, 5, 5);
		gbc_lblGimnasio.anchor = GridBagConstraints.EAST;
		gbc_lblGimnasio.gridx = 0;
		gbc_lblGimnasio.gridy = 0;
		panel.add(lblGimnasio, gbc_lblGimnasio);
		
		JComboBox jcbgimnasio = new JComboBox();
		GridBagConstraints gbc_jcbgimnasio = new GridBagConstraints();
		gbc_jcbgimnasio.gridwidth = 5;
		gbc_jcbgimnasio.insets = new Insets(0, 0, 5, 0);
		gbc_jcbgimnasio.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbgimnasio.gridx = 1;
		gbc_jcbgimnasio.gridy = 0;
		panel.add(jcbgimnasio, gbc_jcbgimnasio);

		jcbgimnasio = new JComboBox<Gimnasio>();
		jcbgimnasio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarListaGimnasio();
			}
		});
		
		JLabel lblFiltros = new JLabel("Filtros apellidos asistente:");
		GridBagConstraints gbc_lblFiltros = new GridBagConstraints();
		gbc_lblFiltros.anchor = GridBagConstraints.EAST;
		gbc_lblFiltros.insets = new Insets(0, 0, 5, 5);
		gbc_lblFiltros.gridx = 0;
		gbc_lblFiltros.gridy = 1;
		panel.add(lblFiltros, gbc_lblFiltros);
		
		jtffiltro = new JTextField();
		GridBagConstraints gbc_jtffiltro = new GridBagConstraints();
		gbc_jtffiltro.gridwidth = 4;
		gbc_jtffiltro.insets = new Insets(0, 0, 5, 5);
		gbc_jtffiltro.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtffiltro.gridx = 1;
		gbc_jtffiltro.gridy = 1;
		panel.add(jtffiltro, gbc_jtffiltro);
		jtffiltro.setColumns(10);
		
		JButton jbtnFiltrarAsistentes = new JButton("Filtrar aistentes");
		GridBagConstraints gbc_jbtnFiltrarAsistentes = new GridBagConstraints();
		gbc_jbtnFiltrarAsistentes.insets = new Insets(0, 0, 5, 0);
		gbc_jbtnFiltrarAsistentes.fill = GridBagConstraints.HORIZONTAL;
		gbc_jbtnFiltrarAsistentes.gridx = 5;
		gbc_jbtnFiltrarAsistentes.gridy = 1;
		panel.add(jbtnFiltrarAsistentes, gbc_jbtnFiltrarAsistentes);
		
		JLabel jlblAsistentes = new JLabel("Asistentes filtrados:");
		GridBagConstraints gbc_jlblAsistentes = new GridBagConstraints();
		gbc_jlblAsistentes.anchor = GridBagConstraints.EAST;
		gbc_jlblAsistentes.insets = new Insets(0, 0, 0, 5);
		gbc_jlblAsistentes.gridx = 0;
		gbc_jlblAsistentes.gridy = 2;
		panel.add(jlblAsistentes, gbc_jlblAsistentes);
		
		JComboBox jcbAsistentes = new JComboBox();
		GridBagConstraints gbc_jcbAsistentes = new GridBagConstraints();
		gbc_jcbAsistentes.gridwidth = 5;
		gbc_jcbAsistentes.insets = new Insets(0, 0, 0, 5);
		gbc_jcbAsistentes.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbAsistentes.gridx = 1;
		gbc_jcbAsistentes.gridy = 2;
			panel.add(jcbAsistentes, gbc_jcbAsistentes);

			jcbasistente = new JComboBox<Asistente>();
			jcbasistente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cargarAsistenteEnPantalla();
				}
			});
		
		JLabel jlblDatos = new JLabel("Datos del asistente");
		jlblDatos.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_jlblDatos = new GridBagConstraints();
		gbc_jlblDatos.gridwidth = 15;
		gbc_jlblDatos.insets = new Insets(0, 0, 5, 0);
		gbc_jlblDatos.gridx = 0;
		gbc_jlblDatos.gridy = 2;
		contentPane.add(jlblDatos, gbc_jlblDatos);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 15;
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 3;
		contentPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel jlblId = new JLabel("Id:");
		GridBagConstraints gbc_jlblId = new GridBagConstraints();
		gbc_jlblId.insets = new Insets(0, 0, 5, 5);
		gbc_jlblId.anchor = GridBagConstraints.EAST;
		gbc_jlblId.gridx = 1;
		gbc_jlblId.gridy = 0;
		panel_1.add(jlblId, gbc_jlblId);
		
		jtfId = new JTextField();
		jtfId.setEditable(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.gridwidth = 2;
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 2;
		gbc_jtfId.gridy = 0;
		panel_1.add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		JLabel jlblDni = new JLabel("DNI/NIE/Pasaporte:");
		GridBagConstraints gbc_jlblDni = new GridBagConstraints();
		gbc_jlblDni.anchor = GridBagConstraints.EAST;
		gbc_jlblDni.insets = new Insets(0, 0, 5, 5);
		gbc_jlblDni.gridx = 1;
		gbc_jlblDni.gridy = 1;
		panel_1.add(jlblDni, gbc_jlblDni);
		
		jtfdni = new JTextField();
		GridBagConstraints gbc_jtfdni = new GridBagConstraints();
		gbc_jtfdni.insets = new Insets(0, 0, 5, 0);
		gbc_jtfdni.gridwidth = 2;
		gbc_jtfdni.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfdni.gridx = 2;
		gbc_jtfdni.gridy = 1;
		panel_1.add(jtfdni, gbc_jtfdni);
		jtfdni.setColumns(10);
		
		JLabel jlblLocalidad = new JLabel("Localidad:");
		GridBagConstraints gbc_jlblLocalidad = new GridBagConstraints();
		gbc_jlblLocalidad.anchor = GridBagConstraints.EAST;
		gbc_jlblLocalidad.insets = new Insets(0, 0, 5, 5);
		gbc_jlblLocalidad.gridx = 1;
		gbc_jlblLocalidad.gridy = 2;
		panel_1.add(jlblLocalidad, gbc_jlblLocalidad);
		
		JComboBox jcbLocalidad = new JComboBox();
		GridBagConstraints gbc_jcbLocalidad = new GridBagConstraints();
		gbc_jcbLocalidad.insets = new Insets(0, 0, 5, 0);
		gbc_jcbLocalidad.gridwidth = 2;
		gbc_jcbLocalidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbLocalidad.gridx = 2;
		gbc_jcbLocalidad.gridy = 2;
		panel_1.add(jcbLocalidad, gbc_jcbLocalidad);

		jcbLocalidad = new JComboBox<Localidad>();
		jcbLocalidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("actionPerformed jcbProducto");
				cargarLocalidadEnPantalla();
			}

			private void cargarLocalidadEnPantalla() {
				// TODO Auto-generated method stub
				
			}
		});
		
		JLabel jlblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_jlblNombre = new GridBagConstraints();
		gbc_jlblNombre.anchor = GridBagConstraints.EAST;
		gbc_jlblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_jlblNombre.gridx = 1;
		gbc_jlblNombre.gridy = 3;
		Container panel_2 = null;
		panel_1.add(jlblNombre, gbc_jlblNombre);
		
		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 0);
		gbc_jtfNombre.gridwidth = 2;
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 2;
		gbc_jtfNombre.gridy = 3;
		panel_1.add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);
		
		JLabel jlblApellidos = new JLabel("Apellidos:");
		GridBagConstraints gbc_jlblApellidos = new GridBagConstraints();
		gbc_jlblApellidos.anchor = GridBagConstraints.EAST;
		gbc_jlblApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_jlblApellidos.gridx = 1;
		gbc_jlblApellidos.gridy = 4;
		panel_1.add(jlblApellidos, gbc_jlblApellidos);
		
		jtfApellidos = new JTextField();
		GridBagConstraints gbc_jtfApellidos = new GridBagConstraints();
		gbc_jtfApellidos.insets = new Insets(0, 0, 5, 0);
		gbc_jtfApellidos.gridwidth = 2;
		gbc_jtfApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfApellidos.gridx = 2;
		gbc_jtfApellidos.gridy = 4;
		panel_1.add(jtfApellidos, gbc_jtfApellidos);
		jtfApellidos.setColumns(10);
		
		JCheckBox chbxActivo = new JCheckBox("");
		GridBagConstraints gbc_chbxActivo = new GridBagConstraints();
		gbc_chbxActivo.anchor = GridBagConstraints.EAST;
		gbc_chbxActivo.insets = new Insets(0, 0, 5, 5);
		gbc_chbxActivo.gridx = 1;
		gbc_chbxActivo.gridy = 5;
		panel_1.add(chbxActivo, gbc_chbxActivo);
		
		JLabel jlblActivo = new JLabel("Activo");
		GridBagConstraints gbc_jlblActivo = new GridBagConstraints();
		gbc_jlblActivo.anchor = GridBagConstraints.WEST;
		gbc_jlblActivo.insets = new Insets(0, 0, 5, 5);
		gbc_jlblActivo.gridx = 2;
		gbc_jlblActivo.gridy = 5;
		panel_1.add(jlblActivo, gbc_jlblActivo);
		
		JLabel jlblFechaNacimiento = new JLabel("Fecha de nacimiento:");
		GridBagConstraints gbc_jlblFechaNacimiento = new GridBagConstraints();
		gbc_jlblFechaNacimiento.anchor = GridBagConstraints.EAST;
		gbc_jlblFechaNacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_jlblFechaNacimiento.gridx = 1;
		gbc_jlblFechaNacimiento.gridy = 6;
		panel_1.add(jlblFechaNacimiento, gbc_jlblFechaNacimiento);
		
		jtffechanac = new JTextField();
		GridBagConstraints gbc_jtffechanac = new GridBagConstraints();
		gbc_jtffechanac.insets = new Insets(0, 0, 5, 0);
		gbc_jtffechanac.gridwidth = 2;
		gbc_jtffechanac.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtffechanac.gridx = 2;
		gbc_jtffechanac.gridy = 6;
		panel_1.add(jtffechanac, gbc_jtffechanac);
		jtffechanac.setColumns(10);
		
		JLabel jlblCuota = new JLabel("Cuota Mensual (€):");
		GridBagConstraints gbc_jlblCuota = new GridBagConstraints();
		gbc_jlblCuota.anchor = GridBagConstraints.EAST;
		gbc_jlblCuota.insets = new Insets(0, 0, 5, 5);
		gbc_jlblCuota.gridx = 1;
		gbc_jlblCuota.gridy = 7;
		panel_1.add(jlblCuota, gbc_jlblCuota);
		
		jtfCuota = new JTextField();
		GridBagConstraints gbc_jtfCuota = new GridBagConstraints();
		gbc_jtfCuota.insets = new Insets(0, 0, 5, 0);
		gbc_jtfCuota.gridwidth = 2;
		gbc_jtfCuota.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfCuota.gridx = 2;
		gbc_jtfCuota.gridy = 7;
		panel_1.add(jtfCuota, gbc_jtfCuota);
		jtfCuota.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Guardar");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 8;
		panel_1.add(btnNewButton_1, gbc_btnNewButton_1);
		
		cargarListaGimnasio();
	}


	


	private void cargarListaGimnasio() {
		List<Gimnasio> l = ControladorGimnasio.findAll();
		for (Gimnasio g : l) {
			this.jcbgimnasio.addItem(g);
		}
	}
	
	/**
	 * 
	 */
	private void cargargimnasio() {
		Gimnasio g = (Gimnasio) this.jcbgimnasio.getSelectedItem();
		List<Gimnasio> l = ControladorGimnasio.findAllByIdGimnasio(g.getId());

		this.jcbgimnasio.removeAllItems();
		for (Gimnasio o : l) {
			this.jcbgimnasio.addItem(o);
		}
	}
	/**
	 * 
	 */
	private void cargarAsistenteEnPantalla() {
		Asistente a  = (Asistente) this.jcbasistente.getSelectedItem();
		if (a != null) {
			this.jtfId.setText("" + a.getId());
			this.jtfdni.setText(a.getDniNiePasaporte());
			this.jtfNombre.setText(a.getNombre());
			this.jtfApellidos.setText(a.getApellidos());
			this.chbxActivo.setSelected(a.isActivo());
			String strFecha = (a.getFechaNacimiento() != null)? 
					sdf.format(a.getFechaNacimiento()) : "";
			this.jtffechanac.setText(strFecha);
			
			
		}
	}

	/**
	 * 
	 * @return
	 */
	private boolean isCuota2 () {		
		return this.jtfCuota.getText().matches("[A-Z]{3,}.*");
	}
	
	
	/**
	 * 
	 * @return
	 */
	private boolean isCuota1() {
		String srtCuota = this.jtfCuota.getText();
		
		String strCuota = null;
		if (strCuota.length() > 2) {
			for (int i = 0; i < 3; i++) {
				if (!Character.isUpperCase(strCuota.charAt(i))) {
					return false;
				}
			}
		}
		else {
			return false;
		}
		
		return true;
	}
	
	
	/**
	 * 
	 */
	private void guardarAsistente() {
		
		try {
			// Comprobaciones
			if (!isCuota()) {
				JOptionPane.showMessageDialog(null, "El código no es válido. "
						+ "Debe comenzar por tres caracteres en mayúscula");
				return;
			}
			
			if (!isFechaNacimento()) {
				JOptionPane.showMessageDialog(null, "La fecha de nacimiento no es "
						+ "posterior a hoy");
				return;
			}
			
			if (!isCuota()) {
				JOptionPane.showMessageDialog(null, "Las las cuotas mensuales deben "
						+ "ser un número entero");
				return;
			}

			// Guardado del producto
			Asistente a  = new Asistente();
			
			a.setId(Integer.parseInt(this.jtfId.getText()));
			a.setDniNiePasaporte(this.jtfdni.getText());
			a.setIdLocalidad(((Asistente)((JComboBox<Gimnasio>) this.jcbLocalidad).getSelectedItem()).getIdLocalidad());
			a.setNombre(this.jtfNombre.getText());
			a.setApellidos(this.jtfApellidos.getText());
			a.setActivo(this.chbxActivo.isSelected());
			
			Date nuevaFecha = (!this.jtffechanac.getText().trim().equals(""))?
					sdf.parse(this.jtffechanac.getText()) : null;
		
			a.setCuotaMensual(Integer.parseInt(this.jtfCuota.getText()));
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}		
	}

	
	/**
	 * 
	 * @return
	 */
	private boolean isFechaNacimento() {
		String strFechNac = this.jtffechanac.getText();
		
		String strFechaNac = null;
		if (strFechaNac.trim().equals("")) {
			return true;
		}
		
		Date fechaNac = null;
		try {
			fechaNac = sdf.parse(strFechaNac);
		}
		catch (Exception ex) {
			return false;
		}
		
		if ((new Date()).after(fechaNac)) {
			return false;
		}
		else {
			return true;
		}
	}
	
	
	/**
	 * 
	 * @return
	 */
	private boolean isCuota () {
		try {
			Integer.parseInt(this.jtfCuota.getText());
			return true;
		}
		catch (Exception ex) {
			return false;
		}
	}
	
	

}



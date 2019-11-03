package igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.ComponentOrientation;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnNorte;
	private JPanel pnRelleno;
	private JPanel pnInicioSesion;
	private JButton btnRegistrarse;
	private JButton btnIniciarSesion;
	private JPanel pnOpciones;
	private JButton btnMesaDeJuego;
	private JButton btnBanca;
	private JButton btnConsumiciones;
	private JPanel pnFiltrosBar;
	private JLabel lblFiltros;
	private JButton btnFiltro1;
	private JPanel pnBotones;
	private JPanel pnRelleno2;
	private JPanel pnSiguienteCancelar;
	private JPanel pnPrinicpalBar;
	private JLabel lblConsumiciones;
	private JLabel lblUnidades;
	private JComboBox comboBox;
	private JSpinner spinner;
	private JPanel pnAnnadirEliminarBar;
	private JButton btnAadir;
	private JButton btnEliminar;
	private JPanel pnPrecioBar;
	private JTextField txtPrecioDelPedidoBar;
	private JLabel lblPrecioDelPedido;
	private JButton btnCancelar;
	private JButton btnSiguiente;
	private JPanel pnCarritoBar;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JLabel lblPedido;

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
		setBounds(100, 100, 1264, 635);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPnNorte(), BorderLayout.NORTH);
		// contentPane.add(getPnFiltrosBar(), BorderLayout.WEST);
		contentPane.add(getPnBotones(), BorderLayout.SOUTH);
		contentPane.add(getPnPrinicpalBar(), BorderLayout.CENTER);
		// contentPane.add(getPnCarritoBar(), BorderLayout.EAST);
	}

	public void mostrarCamposJuego() {
		// contentPane.remove(getLblFoto());
		// contentPane.add(getBtnCrearActividad());
	}

	public void borrarCamposJuego() {
		// contentPane.remove(getLblFoto());
	}

	public void mostrarCamposBar() {
		btnConsumiciones.setBackground(new java.awt.Color(255, 235, 205));
		contentPane.add(getPnPrinicpalBar(), BorderLayout.CENTER);
		contentPane.add(getPnCarritoBar(), BorderLayout.EAST);
		contentPane.add(getPnFiltrosBar(), BorderLayout.WEST);
		// contentPane.remove(getLblFoto());
		// contentPane.add(getBtnCrearActividad());
	}

	public void borrarCamposBar() {
		btnConsumiciones.setBackground(new java.awt.Color(240, 240, 240));
		contentPane.remove(getPnPrinicpalBar());
		contentPane.remove(getPnCarritoBar());
		contentPane.remove(getPnFiltrosBar());
		// contentPane.remove(getLblFoto());
	}

	public void mostrarCamposBanca() {
		btnBanca.setBackground(new java.awt.Color(255, 235, 205));
		// contentPane.remove(getLblFoto());
		// contentPane.add(getBtnCrearActividad());
	}

	public void borrarCamposBanca() {
		btnBanca.setBackground(new java.awt.Color(240, 240, 240));
		// contentPane.remove(getLblFoto());
	}

	private JPanel getPnNorte() {
		if (pnNorte == null) {
			pnNorte = new JPanel();
			pnNorte.setBackground(Color.WHITE);
			pnNorte.setLayout(new GridLayout(0, 2, 0, 0));
			pnNorte.add(getPnRelleno());
			pnNorte.add(getPanel_2());
			pnNorte.add(getPnOpciones());
		}
		return pnNorte;
	}

	private JPanel getPnRelleno() {
		if (pnRelleno == null) {
			pnRelleno = new JPanel();
		}
		return pnRelleno;
	}

	private JPanel getPanel_2() {
		if (pnInicioSesion == null) {
			pnInicioSesion = new JPanel();
			pnInicioSesion.setBackground(Color.WHITE);
			pnInicioSesion.setLayout(new GridLayout(0, 2, 0, 0));
			pnInicioSesion.add(getBtnRegistrarse());
			pnInicioSesion.add(getBtnIniciarSesion());
		}
		return pnInicioSesion;
	}

	private JButton getBtnRegistrarse() {
		if (btnRegistrarse == null) {
			btnRegistrarse = new JButton("Registrarse");
			btnRegistrarse.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarVentanaRegistro();
				}
			});
			btnRegistrarse.setMnemonic('R');
		}
		return btnRegistrarse;
	}

	private JButton getBtnIniciarSesion() {
		if (btnIniciarSesion == null) {
			btnIniciarSesion = new JButton("Iniciar sesion");
			btnIniciarSesion.setMnemonic('I');
		}
		return btnIniciarSesion;
	}

	private void mostrarVentanaRegistro() {
		VentanaRegistro vR = new VentanaRegistro(this);
		vR.setLocationRelativeTo(this);
		vR.setVisible(true);
	}

	private JPanel getPnOpciones() {
		if (pnOpciones == null) {
			pnOpciones = new JPanel();
			pnOpciones.setLayout(new GridLayout(0, 3, 0, 0));
			pnOpciones.add(getBtnMesaDeJuego());
			pnOpciones.add(getBtnBanca());
			pnOpciones.add(getBtnConsumiciones());
		}
		return pnOpciones;
	}

	private JButton getBtnMesaDeJuego() {
		if (btnMesaDeJuego == null) {
			btnMesaDeJuego = new JButton("Mesa de juego");
			btnMesaDeJuego.setMnemonic('M');
		}
		return btnMesaDeJuego;
	}

	private JButton getBtnBanca() {
		if (btnBanca == null) {
			btnBanca = new JButton("Banca");
			btnBanca.setForeground(new Color(0, 0, 0));
			btnBanca.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					borrarCamposBar();
					mostrarCamposBanca();
				}
			});
			btnBanca.setMnemonic('B');
		}
		return btnBanca;
	}

	private JButton getBtnConsumiciones() {
		if (btnConsumiciones == null) {
			btnConsumiciones = new JButton("Consumiciones");
			btnConsumiciones.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					borrarCamposBanca();
					mostrarCamposBar();

				}
			});
			btnConsumiciones.setMnemonic('C');
		}
		return btnConsumiciones;
	}

	private JPanel getPnFiltrosBar() {
		if (pnFiltrosBar == null) {
			pnFiltrosBar = new JPanel();
			pnFiltrosBar.setLayout(new GridLayout(4, 1, 0, 0));
			pnFiltrosBar.add(getLblFiltros());
			pnFiltrosBar.add(getBtnFiltro1());
		}
		return pnFiltrosBar;
	}

	private JLabel getLblFiltros() {
		if (lblFiltros == null) {
			lblFiltros = new JLabel("Filtros");
		}
		return lblFiltros;
	}

	private JButton getBtnFiltro1() {
		if (btnFiltro1 == null) {
			btnFiltro1 = new JButton("New button");
		}
		return btnFiltro1;
	}

	private JPanel getPnBotones() {
		if (pnBotones == null) {
			pnBotones = new JPanel();
			pnBotones.setLayout(new GridLayout(0, 2, 0, 0));
			pnBotones.add(getPnRelleno2());
			pnBotones.add(getPnSiguienteCancelar());
		}
		return pnBotones;
	}

	private JPanel getPnRelleno2() {
		if (pnRelleno2 == null) {
			pnRelleno2 = new JPanel();
		}
		return pnRelleno2;
	}

	private JPanel getPnSiguienteCancelar() {
		if (pnSiguienteCancelar == null) {
			pnSiguienteCancelar = new JPanel();
			pnSiguienteCancelar.setLayout(new GridLayout(0, 2, 0, 0));
			pnSiguienteCancelar.add(getBtnCancelar());
			pnSiguienteCancelar.add(getBtnSiguiente());
		}
		return pnSiguienteCancelar;
	}

	private JPanel getPnPrinicpalBar() {
		if (pnPrinicpalBar == null) {
			pnPrinicpalBar = new JPanel();
			pnPrinicpalBar.setLayout(new GridLayout(3, 2, 0, 0));
			pnPrinicpalBar.add(getLblConsumiciones());
			pnPrinicpalBar.add(getLblUnidades());
			pnPrinicpalBar.add(getComboBox());
			pnPrinicpalBar.add(getSpinner());
			pnPrinicpalBar.add(getPnAnnadirEliminarBar());
			pnPrinicpalBar.add(getPnPrecioBar());
		}
		return pnPrinicpalBar;
	}

	private JLabel getLblConsumiciones() {
		if (lblConsumiciones == null) {
			lblConsumiciones = new JLabel("Consumiciones");
			lblConsumiciones.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		}
		return lblConsumiciones;
	}

	private JLabel getLblUnidades() {
		if (lblUnidades == null) {
			lblUnidades = new JLabel("Unidades");
		}
		return lblUnidades;
	}

	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
		}
		return comboBox;
	}

	private JSpinner getSpinner() {
		if (spinner == null) {
			spinner = new JSpinner();
			spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		}
		return spinner;
	}

	private JPanel getPnAnnadirEliminarBar() {
		if (pnAnnadirEliminarBar == null) {
			pnAnnadirEliminarBar = new JPanel();
			pnAnnadirEliminarBar.setLayout(new GridLayout(0, 2, 0, 0));
			pnAnnadirEliminarBar.add(getBtnAadir());
			pnAnnadirEliminarBar.add(getBtnEliminar());
		}
		return pnAnnadirEliminarBar;
	}

	private JButton getBtnAadir() {
		if (btnAadir == null) {
			btnAadir = new JButton("A\u00F1adir");
			btnAadir.setMnemonic('A');
		}
		return btnAadir;
	}

	private JButton getBtnEliminar() {
		if (btnEliminar == null) {
			btnEliminar = new JButton("Eliminar");
			btnEliminar.setMnemonic('E');
		}
		return btnEliminar;
	}

	private JPanel getPnPrecioBar() {
		if (pnPrecioBar == null) {
			pnPrecioBar = new JPanel();
			pnPrecioBar.setLayout(new GridLayout(2, 1, 0, 0));
			pnPrecioBar.add(getLblPrecioDelPedido());
			pnPrecioBar.add(getTxtPrecioDelPedidoBar());
		}
		return pnPrecioBar;
	}

	private JTextField getTxtPrecioDelPedidoBar() {
		if (txtPrecioDelPedidoBar == null) {
			txtPrecioDelPedidoBar = new JTextField();
			txtPrecioDelPedidoBar.setEditable(false);
			txtPrecioDelPedidoBar.setText("");
			txtPrecioDelPedidoBar.setColumns(10);
		}
		return txtPrecioDelPedidoBar;
	}

	private JLabel getLblPrecioDelPedido() {
		if (lblPrecioDelPedido == null) {
			lblPrecioDelPedido = new JLabel("Precio del pedido:");
		}
		return lblPrecioDelPedido;
	}

	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setBackground(new Color(255, 0, 0));
		}
		return btnCancelar;
	}

	private JButton getBtnSiguiente() {
		if (btnSiguiente == null) {
			btnSiguiente = new JButton("Siguiente");
			btnSiguiente.setBackground(new Color(127, 255, 0));
		}
		return btnSiguiente;
	}

	private JPanel getPnCarritoBar() {
		if (pnCarritoBar == null) {
			pnCarritoBar = new JPanel();
			pnCarritoBar.setLayout(new GridLayout(2, 1, 0, 0));
			pnCarritoBar.add(getLblPedido());
			pnCarritoBar.add(getScrollPane());
		}
		return pnCarritoBar;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}

	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setEditable(false);
		}
		return textArea;
	}

	private JLabel getLblPedido() {
		if (lblPedido == null) {
			lblPedido = new JLabel("Pedido");
		}
		return lblPedido;
	}
}

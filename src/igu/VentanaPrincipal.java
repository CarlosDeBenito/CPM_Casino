package igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Menu;
import logica.OrderBar;
import logica.Usuario;

import java.awt.Color;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.KeyStroke;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import java.awt.Toolkit;

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

	private Menu menu;
	private OrderBar orderBar;
	private Usuario usuario;
	private JMenuBar menuBar;
	private JMenu mnCasino;
	private JMenuItem mntmReiniciar;
	private JSeparator separator;
	private JMenuItem mntmSalir;
	private JMenu mnHelp;
	private JMenuItem mntmContents;
	private JMenu mnAcercaDe;
	private JMenuItem mntmInformacin;
	private JPanel pnCentral;
	private JLabel lblAquiIraEl;
	private JPanel pnIzquierdo;
	private JLabel lblNewLabel;
	private JButton btnTirar;
	private JPanel pnSur;
	private JLabel lblAquiSePondran;
	private JPanel pnDerecho;
	private JLabel lblAquiIranLas;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/ruleta.png")));
		setTitle("CASINO");
		usuario = new Usuario("Carlos", "1", 100.0, orderBar);
		menu = new Menu();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1264, 635);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPnNorte(), BorderLayout.NORTH);
		contentPane.add(getPnCentral(), BorderLayout.CENTER);
		contentPane.add(getPnIzquierdo(), BorderLayout.WEST);
		contentPane.add(getPnSur(), BorderLayout.SOUTH);
		contentPane.add(getPnDerecho(), BorderLayout.EAST);
		cargaAyuda();
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
			btnIniciarSesion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarVentanaInicioSesion();
				}
			});
			btnIniciarSesion.setMnemonic('I');
		}
		return btnIniciarSesion;
	}

	private void mostrarVentanaRegistro() {
		 VentanaRegistro vR = new VentanaRegistro(this);
		 vR.setLocationRelativeTo(this);
		 vR.setVisible(true);
	}
	
	private void mostrarVentanaInicioSesion() {
		 VentanaInicioSesion vI = new VentanaInicioSesion(this);
		 vI.setLocationRelativeTo(this);
		 vI.setVisible(true);
	}

	private void mostrarVentanaBanca() {
		// VentanaRegistro vR = new VentanaRegistro(this);
		// vR.setLocationRelativeTo(this);
		// vR.setVisible(true);
	}

	private void mostrarVentanaBar() {
		VentanaBar vB = new VentanaBar(this, usuario);
		vB.setLocationRelativeTo(this);
		vB.setVisible(true);
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
			btnMesaDeJuego.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					menu.getUsuarios();
				}
			});
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
					mostrarVentanaBanca();
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
					mostrarVentanaBar();
				}
			});
			btnConsumiciones.setMnemonic('C');
		}
		return btnConsumiciones;
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnCasino());
			menuBar.add(getMnHelp());
			menuBar.add(getMnAcercaDe());
		}
		return menuBar;
	}

	private JMenu getMnCasino() {
		if (mnCasino == null) {
			mnCasino = new JMenu("Casino");
			mnCasino.setMnemonic('C');
			mnCasino.add(getMntmReiniciar());
			mnCasino.add(getSeparator());
			mnCasino.add(getMntmSalir());
		}
		return mnCasino;
	}

	private JMenuItem getMntmReiniciar() {
		if (mntmReiniciar == null) {
			mntmReiniciar = new JMenuItem("Reiniciar");
			mntmReiniciar.setMnemonic('r');
		}
		return mntmReiniciar;
	}

	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}

	private JMenuItem getMntmSalir() {
		if (mntmSalir == null) {
			mntmSalir = new JMenuItem("Salir");
			mntmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));
			mntmSalir.setMnemonic('s');
			mntmSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
		}
		return mntmSalir;
	}

	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Ayuda");
			mnHelp.setMnemonic('a');
			mnHelp.add(getMntmContents());
		}
		return mnHelp;
	}

	private JMenuItem getMntmContents() {
		if (mntmContents == null) {
			mntmContents = new JMenuItem("Contents");
			mntmContents.setMnemonic('c');
			mntmContents.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, InputEvent.CTRL_MASK));
		}
		return mntmContents;
	}

	private JMenu getMnAcercaDe() {
		if (mnAcercaDe == null) {
			mnAcercaDe = new JMenu("Acerca de");
			mnAcercaDe.setMnemonic('a');
			mnAcercaDe.add(getMntmInformacin());
		}
		return mnAcercaDe;
	}

	private JMenuItem getMntmInformacin() {
		if (mntmInformacin == null) {
			mntmInformacin = new JMenuItem("Informaci\u00F3n");
			mntmInformacin.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_MASK));
			mntmInformacin.setMnemonic('i');
			mntmInformacin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evento) {
					JOptionPane.showMessageDialog(
							VentanaPrincipal.this, ("Casino" + "\n" + "Web de casino" + "\n"
									+ "Página realiza por Carlos de Benito Álvarez" + "\n" + "Versión 1.2"),
							"Acerca de", JOptionPane.PLAIN_MESSAGE);
				}
			});
		}
		return mntmInformacin;
	}

	private void cargaAyuda() {
		URL hsURL;
		HelpSet hs;
		try {
			File fichero = new File("help/Ayuda.hs");
			hsURL = fichero.toURI().toURL();
			hs = new HelpSet(null, hsURL);
		} catch (Exception e) {
			System.out.println("Ayuda no encontrada");
			return;
		}
		HelpBroker hb = hs.createHelpBroker();

		hb.enableHelpKey(getRootPane(), "introduccion", hs);
		hb.enableHelpOnButton(mntmContents, "introduccion", hs);
	}
	private JPanel getPnCentral() {
		if (pnCentral == null) {
			pnCentral = new JPanel();
			pnCentral.setBackground(Color.WHITE);
			pnCentral.add(getLblAquiIraEl());
		}
		return pnCentral;
	}
	private JLabel getLblAquiIraEl() {
		if (lblAquiIraEl == null) {
			lblAquiIraEl = new JLabel("Aqui ira el tablero");
		}
		return lblAquiIraEl;
	}
	private JPanel getPnIzquierdo() {
		if (pnIzquierdo == null) {
			pnIzquierdo = new JPanel();
			pnIzquierdo.setLayout(new GridLayout(2, 0, 0, 0));
			pnIzquierdo.add(getLblNewLabel());
			pnIzquierdo.add(getBtnTirar());
		}
		return pnIzquierdo;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Aqui va la ruleta");
		}
		return lblNewLabel;
	}
	private JButton getBtnTirar() {
		if (btnTirar == null) {
			btnTirar = new JButton("Tirar");
		}
		return btnTirar;
	}
	private JPanel getPnSur() {
		if (pnSur == null) {
			pnSur = new JPanel();
			pnSur.add(getLblAquiSePondran());
		}
		return pnSur;
	}
	private JLabel getLblAquiSePondran() {
		if (lblAquiSePondran == null) {
			lblAquiSePondran = new JLabel("Aqui estaran las fichas");
		}
		return lblAquiSePondran;
	}
	private JPanel getPnDerecho() {
		if (pnDerecho == null) {
			pnDerecho = new JPanel();
			pnDerecho.add(getLblAquiIranLas());
		}
		return pnDerecho;
	}
	private JLabel getLblAquiIranLas() {
		if (lblAquiIranLas == null) {
			lblAquiIranLas = new JLabel("Aqui iran las apuestas hasta el moemnto");
		}
		return lblAquiIranLas;
	}
}
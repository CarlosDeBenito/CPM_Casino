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

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnNorte;
	private JLabel lblImagenPrincipal;
	private JPanel panel_1;
	private JPanel pnInicioSesion;
	private JButton btnRegistrarse;
	private JButton btnIniciarSesion;

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
		contentPane.add(getLblImagenPrincipal(), BorderLayout.CENTER);
	}

	private JPanel getPnNorte() {
		if (pnNorte == null) {
			pnNorte = new JPanel();
			pnNorte.setBackground(Color.WHITE);
			pnNorte.setLayout(new GridLayout(0, 2, 0, 0));
			pnNorte.add(getPanel_1());
			pnNorte.add(getPanel_2());
		}
		return pnNorte;
	}
	private JLabel getLblImagenPrincipal() {
		if (lblImagenPrincipal == null) {
			lblImagenPrincipal = new JLabel("New label");
		}
		return lblImagenPrincipal;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
		}
		return panel_1;
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
		}
		return btnIniciarSesion;
	}
	
	private void mostrarVentanaRegistro() {
		VentanaRegistro vR = new VentanaRegistro(this);
		vR.setLocationRelativeTo(this);
		vR.setVisible(true);
	}
}

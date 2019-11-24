package igu;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import logica.Menu;
import logica.Usuario;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class VentanaInicioSesion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel pnPrincipal;
	private JLabel lblPassword;
	private JPasswordField passwordField;
	private JPanel pnRegistro;
	private JButton btnSiguiente;
	private JButton btnCancelar;
	private VentanaPrincipal ventana;
	private JLabel lblNombreDeUsuario;
	private JTextField txtNombreUsuario;
	private Menu menu;

	public VentanaInicioSesion(VentanaPrincipal vi) {
		this.ventana = vi;
		menu = new Menu();
		setTitle("Inicio de sesi\u00F3n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 371);
		pnPrincipal = new JPanel();
		pnPrincipal.setToolTipText("");
		pnPrincipal.setBackground(Color.WHITE);
		setContentPane(pnPrincipal);
		pnPrincipal.setLayout(null);
		pnPrincipal.add(getPnRegistro());
		pnPrincipal.add(getBtnSiguiente());
		pnPrincipal.add(getBtnCancelar());
	}

	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password:");
			lblPassword.setBounds(25, 101, 127, 23);
			lblPassword.setDisplayedMnemonic('P');
			lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 21));
		}
		return lblPassword;
	}

	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setText("1");
			passwordField.setBounds(245, 98, 189, 26);
			passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return passwordField;
	}

	private JPanel getPnRegistro() {
		if (pnRegistro == null) {
			pnRegistro = new JPanel();
			pnRegistro.setBounds(10, 21, 470, 212);
			pnRegistro.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Inicio de sesi\u00F3n",
					TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			pnRegistro.setBackground(Color.WHITE);
			pnRegistro.setLayout(null);
			pnRegistro.add(getLblPassword());
			pnRegistro.add(getPasswordField());
			pnRegistro.add(getLblNombreDeUsuario());
			pnRegistro.add(getTxtNombreUsuario());
		}
		return pnRegistro;
	}

	private JButton getBtnSiguiente() {
		if (btnSiguiente == null) {
			btnSiguiente = new JButton("Siguiente");
			btnSiguiente.setBounds(278, 244, 117, 35);
			btnSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (check()) {
						Usuario u =menu.buscarUsuario(getTxtNombreUsuario().getText(), String.valueOf(getPasswordField().getPassword()));
						if(u!=null) {
						JOptionPane.showMessageDialog(null, "Inicio de sesión con exito, hola " + u.getNombreUsuario());
						// Usuario user = new Usuario(getTxtNombreUsuario().getText(),
						// getPasswordField().getPassword().toString(), getTxtDni().getText(), 100, new
						// int[5]);
						dispose();
						// FileUtil.aniadirCliente(user);
						}else
							JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña incorrectos");
					} else
						JOptionPane.showMessageDialog(null, "Nombre vacio o la contraseña no coincide");
				}
			});
			btnSiguiente.setForeground(Color.WHITE);
			btnSiguiente.setBackground(new Color(50, 205, 50));
			btnSiguiente.setMnemonic('S');
			btnSiguiente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return btnSiguiente;
	}

	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setBounds(407, 244, 123, 35);
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnCancelar.setForeground(Color.WHITE);
			btnCancelar.setBackground(Color.RED);
			btnCancelar.setMnemonic('C');
			btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return btnCancelar;
	}

	private boolean checkNombreUsuario() {
		String nombreUsuario = getTxtNombreUsuario().getText();
		if (nombreUsuario.equals(""))
			return false;
		else
			return true;
	}

	private boolean checkPassword() {
		String password = String.valueOf(getPasswordField().getPassword());
		if (password.equals(""))
			return false;
		else
			return true;
	}

	private boolean check() {
		if (checkPassword() && checkNombreUsuario())
			return true;
		else
			return false;
	}

	public VentanaPrincipal getVentana() {
		return ventana;
	}

	private JLabel getLblNombreDeUsuario() {
		if (lblNombreDeUsuario == null) {
			lblNombreDeUsuario = new JLabel("Nombre de usuario:");
			lblNombreDeUsuario.setToolTipText("");
			lblNombreDeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 21));
			lblNombreDeUsuario.setDisplayedMnemonic('N');
			lblNombreDeUsuario.setBounds(25, 49, 199, 31);
		}
		return lblNombreDeUsuario;
	}

	private JTextField getTxtNombreUsuario() {
		if (txtNombreUsuario == null) {
			txtNombreUsuario = new JTextField();
			txtNombreUsuario.setText("a");
			txtNombreUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtNombreUsuario.setColumns(10);
			txtNombreUsuario.setBounds(245, 49, 189, 26);
		}
		return txtNombreUsuario;
	}
}

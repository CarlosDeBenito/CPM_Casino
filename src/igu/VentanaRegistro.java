package igu;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import logica.FileUtil;
import logica.Menu;
import logica.Usuario;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

public class VentanaRegistro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel pnPrincipal;
	private JLabel lblNombreYApellidos;
	private JLabel lblPassword;
	private JLabel lblReintroduzcaElPassword;
	private JTextField txtNombreYApellidos;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldRepeat;
	private JPanel pnRegistro;
	private JButton btnSiguiente;
	private JButton btnCancelar;
	private VentanaPrincipal ventana;
	private JLabel lblNombreDeUsuario;
	private JTextField txtNombreUsuario;
	private JTextField txtDni;
	private JLabel lblDni;
	private Menu menu;

	/**
	 * Create the frame.
	 */
	public VentanaRegistro(VentanaPrincipal vi) {
		this.ventana = vi;
		menu = new Menu();
		setTitle("Registro");
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

	private JLabel getLblNombreYApellidos() {
		if (lblNombreYApellidos == null) {
			lblNombreYApellidos = new JLabel("Nombre y Apellidos:");
			lblNombreYApellidos.setBounds(25, 48, 146, 20);
			lblNombreYApellidos.setDisplayedMnemonic('N');
			lblNombreYApellidos.setToolTipText("");
			lblNombreYApellidos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lblNombreYApellidos;
	}

	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password:");
			lblPassword.setBounds(25, 144, 73, 20);
			lblPassword.setDisplayedMnemonic('P');
			lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lblPassword;
	}

	private JLabel getLblReintroduzcaElPassword() {
		if (lblReintroduzcaElPassword == null) {
			lblReintroduzcaElPassword = new JLabel("Reintroduzca el password: ");
			lblReintroduzcaElPassword.setBounds(25, 172, 191, 20);
			lblReintroduzcaElPassword.setDisplayedMnemonic('R');
			lblReintroduzcaElPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lblReintroduzcaElPassword;
	}

	private JTextField getTxtNombreYApellidos() {
		if (txtNombreYApellidos == null) {
			txtNombreYApellidos = new JTextField();
			txtNombreYApellidos.setText("a");
			txtNombreYApellidos.setBounds(245, 42, 189, 26);
			txtNombreYApellidos.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtNombreYApellidos.setColumns(10);
		}
		return txtNombreYApellidos;
	}

	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setText("1");
			passwordField.setBounds(245, 138, 189, 26);
			passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return passwordField;
	}

	private JPasswordField getPasswordFieldRepeat() {
		if (passwordFieldRepeat == null) {
			passwordFieldRepeat = new JPasswordField();
			passwordFieldRepeat.setText("1");
			passwordFieldRepeat.setBounds(245, 169, 189, 26);
			passwordFieldRepeat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return passwordFieldRepeat;
	}

	private JPanel getPnRegistro() {
		if (pnRegistro == null) {
			pnRegistro = new JPanel();
			pnRegistro.setBounds(10, 21, 470, 212);
			pnRegistro.setBorder(
					new TitledBorder(null, "Datos del cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnRegistro.setBackground(Color.WHITE);
			pnRegistro.setLayout(null);
			pnRegistro.add(getLblNombreYApellidos());
			pnRegistro.add(getLblPassword());
			pnRegistro.add(getLblReintroduzcaElPassword());
			pnRegistro.add(getTxtNombreYApellidos());
			pnRegistro.add(getPasswordField());
			pnRegistro.add(getPasswordFieldRepeat());
			pnRegistro.add(getLblNombreDeUsuario());
			pnRegistro.add(getTxtNombreUsuario());
			pnRegistro.add(getTxtDni());
			pnRegistro.add(getLblDni());
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
						if (!menu.dniYaExiste(getTxtDni().getText())) {
							JOptionPane.showMessageDialog(null, "Registrado con exito");
							Usuario user = new Usuario(getTxtNombreYApellidos().getText(),
									getTxtNombreUsuario().getText(), String.valueOf(getPasswordField().getPassword()),
									getTxtDni().getText(), 100, new int[5]);
							dispose();
							FileUtil.aniadirCliente(user);
						} else
							JOptionPane.showMessageDialog(null, "DNI ya existente");
					} else
						JOptionPane.showMessageDialog(null, "Nombre vacio o la contraseņa no coincide");
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

	private boolean checkNombreYApellido() {
		String nombreYApellidos = getTxtNombreYApellidos().getText();
		if (nombreYApellidos.equals(""))
			return false;
		else
			return true;
	}

	private boolean checkNombreUsuario() {
		String nombreUsuario = getTxtNombreUsuario().getText();
		if (nombreUsuario.equals(""))
			return false;
		else
			return true;
	}

	private boolean checkDni() {
		String dni = getTxtDni().getText();
		if (dni.equals(""))
			return false;
		else
			return true;
	}

	private boolean checkPassword() {
		String password = String.valueOf(getPasswordField().getPassword());
		String repeatPassword = String.valueOf(getPasswordFieldRepeat().getPassword());
		if (!password.equals(repeatPassword) || password.equals(""))
			return false;
		else
			return true;
	}

	private boolean check() {
		if (checkNombreYApellido() && checkPassword() && checkNombreUsuario() && checkDni())
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
			lblNombreDeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNombreDeUsuario.setDisplayedMnemonic('N');
			lblNombreDeUsuario.setBounds(25, 82, 146, 20);
		}
		return lblNombreDeUsuario;
	}

	private JTextField getTxtNombreUsuario() {
		if (txtNombreUsuario == null) {
			txtNombreUsuario = new JTextField();
			txtNombreUsuario.setText("a");
			txtNombreUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtNombreUsuario.setColumns(10);
			txtNombreUsuario.setBounds(245, 76, 189, 26);
		}
		return txtNombreUsuario;
	}

	private JTextField getTxtDni() {
		if (txtDni == null) {
			txtDni = new JTextField();
			txtDni.setText("a");
			txtDni.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtDni.setColumns(10);
			txtDni.setBounds(245, 108, 189, 26);
		}
		return txtDni;
	}

	private JLabel getLblDni() {
		if (lblDni == null) {
			lblDni = new JLabel("DNI:");
			lblDni.setToolTipText("");
			lblDni.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblDni.setDisplayedMnemonic('N');
			lblDni.setBounds(25, 111, 62, 20);
		}
		return lblDni;
	}
}

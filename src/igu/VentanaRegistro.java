package igu;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaRegistro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pnPrincipal;
	private JLabel lblNombreYApellidos;
	private JLabel lblAoDeNacimiento;
	private JLabel lblPassword;
	private JLabel lblReintroduzcaElPassword;
	private JTextField txtNombreYApellidos;
	private JComboBox<Integer> comboBoxFecha;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldRepeat;
	private JPanel pnRegistro;
	private JButton btnSiguiente;
	private JButton btnCancelar;
	private VentanaPrincipal ventana;

	/**
	 * Create the frame.
	 */
	public VentanaRegistro(VentanaPrincipal vi) {
		this.ventana = vi;
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
			lblNombreYApellidos.setBounds(25, 33, 146, 20);
			lblNombreYApellidos.setDisplayedMnemonic('N');
			lblNombreYApellidos.setToolTipText("");
			lblNombreYApellidos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lblNombreYApellidos;
	}

	private JLabel getLblAoDeNacimiento() {
		if (lblAoDeNacimiento == null) {
			lblAoDeNacimiento = new JLabel("A\u00F1o de nacimiento:");
			lblAoDeNacimiento.setBounds(25, 74, 139, 20);
			lblAoDeNacimiento.setDisplayedMnemonic('A');
			lblAoDeNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lblAoDeNacimiento;
	}

	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password:");
			lblPassword.setBounds(25, 115, 73, 20);
			lblPassword.setDisplayedMnemonic('P');
			lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lblPassword;
	}

	private JLabel getLblReintroduzcaElPassword() {
		if (lblReintroduzcaElPassword == null) {
			lblReintroduzcaElPassword = new JLabel("Reintroduzca el password: ");
			lblReintroduzcaElPassword.setBounds(25, 161, 191, 20);
			lblReintroduzcaElPassword.setDisplayedMnemonic('R');
			lblReintroduzcaElPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lblReintroduzcaElPassword;
	}

	private JTextField getTxtNombreYApellidos() {
		if (txtNombreYApellidos == null) {
			txtNombreYApellidos = new JTextField();
			txtNombreYApellidos.setText("a");
			txtNombreYApellidos.setBounds(245, 30, 189, 26);
			txtNombreYApellidos.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtNombreYApellidos.setColumns(10);
		}
		return txtNombreYApellidos;
	}

	private JComboBox<Integer> getComboBoxFecha() {
		if (comboBoxFecha == null) {
			comboBoxFecha = new JComboBox<Integer>();
			comboBoxFecha.setBounds(245, 71, 146, 26);
			for (int i = 1920; i < 2020; i++) {
				comboBoxFecha.addItem(i);
			}
			comboBoxFecha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return comboBoxFecha;
	}

	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setText("1");
			passwordField.setBounds(245, 112, 146, 26);
			passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return passwordField;
	}

	private JPasswordField getPasswordFieldRepeat() {
		if (passwordFieldRepeat == null) {
			passwordFieldRepeat = new JPasswordField();
			passwordFieldRepeat.setText("1");
			passwordFieldRepeat.setBounds(245, 158, 146, 26);
			passwordFieldRepeat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return passwordFieldRepeat;
	}

	private JPanel getPnRegistro() {
		if (pnRegistro == null) {
			pnRegistro = new JPanel();
			pnRegistro.setBounds(10, 21, 470, 202);
			pnRegistro.setBorder(
					new TitledBorder(null, "Datos del cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnRegistro.setBackground(Color.WHITE);
			pnRegistro.setLayout(null);
			pnRegistro.add(getLblNombreYApellidos());
			pnRegistro.add(getLblAoDeNacimiento());
			pnRegistro.add(getLblPassword());
			pnRegistro.add(getLblReintroduzcaElPassword());
			pnRegistro.add(getTxtNombreYApellidos());
			pnRegistro.add(getComboBoxFecha());
			pnRegistro.add(getPasswordField());
			pnRegistro.add(getPasswordFieldRepeat());
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
						JOptionPane.showMessageDialog(null, "Registrado con exito");
						dispose();
					}else
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

	private boolean checkNombreYApellido() {
		String nombreYApellidos = getTxtNombreYApellidos().getText();
		if (nombreYApellidos.equals(""))
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
		if (checkNombreYApellido() && checkPassword())
			return true;
		else
			return false;
	}

	public VentanaPrincipal getVentana() {
		return ventana;
	}
}

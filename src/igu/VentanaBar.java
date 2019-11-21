package igu;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

import logica.Menu;
import logica.OrderBar;
import logica.ProductBar;
import logica.Usuario;

import javax.swing.JSpinner;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SpinnerNumberModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JCheckBox;
import javax.swing.border.TitledBorder;

public class VentanaBar extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 662564947700750237L;
	private VentanaPrincipal ventana;
	private JPanel pnFondos;
	private JLabel lblFondos;
	private JTextField txtFondos;
	private JPanel pnPedido;
	private JScrollPane scrollPane;
	private JTextArea textAreaPedido;
	private JLabel lblPedidoActual;
	private JPanel pnCombox;
	private JComboBox<ProductBar> cmbBoxArticulos;
	private JLabel lblUnidades;
	private JSpinner spnUnidades;
	private JLabel lblCarta;
	private JButton btnAnnadir;
	private JButton btnEliminar;
	private JPanel pnFiltros;
	private JPanel panel;
	private JButton btnAtras;
	private JButton btnPagar;

	private OrderBar orderBar;
	private Usuario usuario;
	private Menu menu;
	private JLabel lblProductoBar;
	private JPanel pnFiltrosTipo;
	private JCheckBox chckbxAlchlica;
	private JCheckBox chckbxBebidasNoAlcholicas;
	private JLabel lblBar;

	/**
	 * Create the dialog.
	 * 
	 * @param ventanaPrincipal_OtraForma
	 */
	public VentanaBar(VentanaPrincipal vP, Usuario usuario) {
		getContentPane().setBackground(Color.WHITE);
		this.ventana = vP;
		this.usuario = usuario;
		menu = new Menu();
		orderBar = new OrderBar();
		setBounds(100, 100, 886, 687);
		getContentPane().setLayout(null);
		getContentPane().add(getPnFondos());
		getContentPane().add(getPnPedido());
		getContentPane().add(getLblPedidoActual());
		getContentPane().add(getPnCombox());
		getContentPane().add(getPnFiltros());
		getContentPane().add(getPanel());
		getContentPane().add(getLblBar());

	}

	public OrderBar getOrderBar() {
		return orderBar;
	}

	private JPanel getPnFondos() {
		if (pnFondos == null) {
			pnFondos = new JPanel();
			pnFondos.setBackground(Color.WHITE);
			pnFondos.setBounds(570, 10, 269, 36);
			pnFondos.setLayout(null);
			pnFondos.add(getLblFondos());
			pnFondos.add(getTxtFondos());
		}
		return pnFondos;
	}

	private JLabel getLblFondos() {
		if (lblFondos == null) {
			lblFondos = new JLabel("Fondos:");
			lblFondos.setBounds(0, 0, 92, 26);
		}
		return lblFondos;
	}

	private JTextField getTxtFondos() {
		if (txtFondos == null) {
			txtFondos = new JTextField();
			txtFondos.setBackground(Color.WHITE);
			txtFondos.setEditable(false);
			txtFondos.setBounds(83, 0, 186, 29);
			txtFondos.setColumns(10);
			txtFondos.setText(usuario.getDinero() + "€");
		}
		return txtFondos;
	}

	private JPanel getPnPedido() {
		if (pnPedido == null) {
			pnPedido = new JPanel();
			pnPedido.setBounds(570, 99, 269, 409);
			pnPedido.setLayout(null);
			pnPedido.add(getScrollPane());
		}
		return pnPedido;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 0, 269, 409);
			scrollPane.setViewportView(getTextAreaPedido());
		}
		return scrollPane;
	}

	private JTextArea getTextAreaPedido() {
		if (textAreaPedido == null) {
			textAreaPedido = new JTextArea();
			textAreaPedido.setEditable(false);
			textAreaPedido.setText(getOrderBar().toStringConDescuento(usuario));
		}
		return textAreaPedido;
	}

	private JLabel getLblPedidoActual() {
		if (lblPedidoActual == null) {
			lblPedidoActual = new JLabel("Pedido Actual");
			lblPedidoActual.setBounds(570, 67, 167, 26);
		}
		return lblPedidoActual;
	}

	private JPanel getPnCombox() {
		if (pnCombox == null) {
			pnCombox = new JPanel();
			pnCombox.setBackground(Color.WHITE);
			pnCombox.setBounds(230, 99, 319, 419);
			pnCombox.setLayout(null);
			pnCombox.add(getCmbBoxArticulos());
			pnCombox.add(getLblUnidades());
			pnCombox.add(getSpnUnidades());
			pnCombox.add(getLblCarta());
			pnCombox.add(getBtnEliminar());
			pnCombox.add(getLblProductoBar());
			pnCombox.add(getBtnAnnadir());
		}
		return pnCombox;
	}

	private JComboBox<ProductBar> getCmbBoxArticulos() {
		if (cmbBoxArticulos == null) {
			cmbBoxArticulos = new JComboBox<ProductBar>();
			cmbBoxArticulos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mostrarFotoYUnidades();
				}
			});
			ProductBar[] productos = menu.getProducts();
			for (ProductBar product : productos) {
				cmbBoxArticulos.addItem(product);
			}
			cmbBoxArticulos.setBounds(10, 32, 160, 32);
		}
		return cmbBoxArticulos;
	}

	private void mostrarFotoYUnidades() {
		getSpnUnidades().setValue(1);
		if (getCmbBoxArticulos().getItemCount() > 0) {
			String fotoArticulo = "/img/" + (((ProductBar) getCmbBoxArticulos().getSelectedItem()).getCode() + ".png");
			getLblProductoBar().setIcon(new ImageIcon(VentanaPrincipal.class.getResource(fotoArticulo)));
		}
	}

	private JLabel getLblUnidades() {
		if (lblUnidades == null) {
			lblUnidades = new JLabel("Unidades");
			lblUnidades.setFont(new Font("Tahoma", Font.PLAIN, 21));
			lblUnidades.setBounds(191, 0, 97, 26);
		}
		return lblUnidades;
	}

	private JSpinner getSpnUnidades() {
		if (spnUnidades == null) {
			spnUnidades = new JSpinner();
			spnUnidades.setModel(new SpinnerNumberModel(new Integer(1), new Integer(0), null, new Integer(1)));
			spnUnidades.setBounds(191, 32, 81, 32);
		}
		return spnUnidades;
	}

	private JLabel getLblCarta() {
		if (lblCarta == null) {
			lblCarta = new JLabel("Carta");
			lblCarta.setFont(new Font("Tahoma", Font.PLAIN, 21));
			lblCarta.setBounds(10, -1, 82, 26);
		}
		return lblCarta;
	}

	private JButton getBtnAnnadir() {
		if (btnAnnadir == null) {
			btnAnnadir = new JButton("A\u00F1adir");
			btnAnnadir.setBounds(26, 363, 118, 35);
			btnAnnadir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if ((int) getSpnUnidades().getValue() > 0) {
						orderBar.add((ProductBar) getCmbBoxArticulos().getSelectedItem(),
								(int) getSpnUnidades().getValue());
						textAreaPedido.setText(getOrderBar().toStringConDescuento(usuario));
						// String precio = orderBar.calcTotal() + "";
						// getTxtPrecio().setText(precio);
						getSpnUnidades().setValue(1);
						if (!orderBar.getOrderList().isEmpty() && usuario.getDinero() - orderBar.calcTotal() >= 0)
							getBtnPagar().setEnabled(true);
						else if (usuario.getDinero() - orderBar.calcTotal() < 0)
							getBtnPagar().setEnabled(false);
					} else
						JOptionPane.showMessageDialog(null, "Por favor seleccione al menos una unidad del producto");
				}
			});
			btnAnnadir.setMnemonic('A');
		}
		return btnAnnadir;
	}

	private JButton getBtnEliminar() {
		if (btnEliminar == null) {
			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (orderBar.unidadesDelPedido(
							(ProductBar) (getCmbBoxArticulos().getSelectedItem())) >= (int) getSpnUnidades()
									.getValue()) {
						orderBar.remove((ProductBar) getCmbBoxArticulos().getSelectedItem(),
								(int) getSpnUnidades().getValue());
						textAreaPedido.setText(getOrderBar().toStringConDescuento(usuario));
						// String precio = orderBar.calcTotal() + "";
						// getTxtPrecio().setText(precio);
						getSpnUnidades().setValue(1);
						if (orderBar.getOrderList().isEmpty() || usuario.getDinero() - orderBar.calcTotal() < 0)
							getBtnPagar().setEnabled(false);
						else if (!orderBar.getOrderList().isEmpty() && usuario.getDinero() - orderBar.calcTotal() >= 0)
							getBtnPagar().setEnabled(true);
					} else
						JOptionPane.showMessageDialog(null, "No puedes borrar un producto que no has pedido");
				}
			});
			btnEliminar.setMnemonic('E');
			btnEliminar.setBounds(165, 363, 123, 35);
		}
		return btnEliminar;
	}

	private JPanel getPnFiltros() {
		if (pnFiltros == null) {
			pnFiltros = new JPanel();
			pnFiltros.setBackground(Color.WHITE);
			pnFiltros.setBounds(21, 89, 200, 419);
			pnFiltros.setLayout(new GridLayout(2, 0, 0, 0));
			pnFiltros.add(getPnFiltrosTipo());
		}
		return pnFiltros;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBounds(570, 539, 269, 56);
			panel.setLayout(null);
			panel.add(getBtnAtras());
			panel.add(getBtnPagar());
		}
		return panel;
	}

	private JButton getBtnAtras() {
		if (btnAtras == null) {
			btnAtras = new JButton("Atr\u00E1s");
			btnAtras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnAtras.setMnemonic('t');
			btnAtras.setBounds(11, 10, 113, 35);
		}
		return btnAtras;
	}

	private JButton getBtnPagar() {
		if (btnPagar == null) {
			btnPagar = new JButton("Pagar");
			btnPagar.setEnabled(false);
			btnPagar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Una vez que confirme pagar su pedido se deberia reiniciar. Y cerrar los dos dialogos
					int res = JOptionPane.showConfirmDialog(null, "¿Seguro que quiere pagar?, Una vez pagado no se podrá devolver", "YES_NO_OPTION", JOptionPane.YES_NO_OPTION,
							JOptionPane.INFORMATION_MESSAGE);
					if(res==0) {//Si le da que si
						usuario.setDinero(usuario.getDinero() - orderBar.calcTotal());
						txtFondos.setText(usuario.getDinero() + "€");
						dispose();
						orderBar.initialize();
					}
					
						
				}
			});
			btnPagar.setMnemonic('P');
			btnPagar.setBounds(145, 10, 113, 35);
		}
		return btnPagar;
	}

	public VentanaPrincipal getVentana() {
		return ventana;
	}

	private JLabel getLblProductoBar() {
		if (lblProductoBar == null) {
			lblProductoBar = new JLabel("");
			lblProductoBar.setBounds(21, 85, 277, 257);
		}
		return lblProductoBar;
	}

	private JPanel getPnFiltrosTipo() {
		if (pnFiltrosTipo == null) {
			pnFiltrosTipo = new JPanel();
			pnFiltrosTipo.setBorder(
					new TitledBorder(null, "Tipo de bebida", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnFiltrosTipo.setBackground(Color.WHITE);
			pnFiltrosTipo.setLayout(null);
			pnFiltrosTipo.add(getChckbxAlchlica());
			pnFiltrosTipo.add(getChckbxBebidasNoAlcholicas());
		}
		return pnFiltrosTipo;
	}

	private void filtro() {
		getCmbBoxArticulos().removeAllItems();
		ProductBar[] productos = menu.getProducts();
		if (getChckbxAlchlica().isSelected() && getChckbxBebidasNoAlcholicas().isSelected()) {
			for (ProductBar product : productos)
				cmbBoxArticulos.addItem(product);
		} else if (getChckbxAlchlica().isSelected()) {
			for (ProductBar product : productos)
				if (product.getType().equals("0"))
					cmbBoxArticulos.addItem(product);
		} else {
			for (ProductBar product : productos)
				if (product.getType().equals("1"))
					cmbBoxArticulos.addItem(product);
		}

	}

	private JCheckBox getChckbxAlchlica() {
		if (chckbxAlchlica == null) {
			chckbxAlchlica = new JCheckBox("Alcoh\u00F3licas");
			chckbxAlchlica.setFont(new Font("Tahoma", Font.PLAIN, 20));
			chckbxAlchlica.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					filtro();
				}
			});
			chckbxAlchlica.setSelected(true);
			chckbxAlchlica.setBackground(Color.WHITE);
			chckbxAlchlica.setBounds(17, 41, 154, 35);
		}
		return chckbxAlchlica;
	}

	private JCheckBox getChckbxBebidasNoAlcholicas() {
		if (chckbxBebidasNoAlcholicas == null) {
			chckbxBebidasNoAlcholicas = new JCheckBox("No alcoh\u00F3licas");
			chckbxBebidasNoAlcholicas.setFont(new Font("Tahoma", Font.PLAIN, 20));
			chckbxBebidasNoAlcholicas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					filtro();
				}
			});
			chckbxBebidasNoAlcholicas.setSelected(true);
			chckbxBebidasNoAlcholicas.setBackground(Color.WHITE);
			chckbxBebidasNoAlcholicas.setBounds(17, 89, 166, 35);
		}
		return chckbxBebidasNoAlcholicas;
	}
	private JLabel getLblBar() {
		if (lblBar == null) {
			lblBar = new JLabel("Consumiciones");
			lblBar.setForeground(Color.RED);
			lblBar.setFont(new Font("Tahoma", Font.PLAIN, 42));
			lblBar.setBounds(33, 22, 284, 56);
		}
		return lblBar;
	}
}

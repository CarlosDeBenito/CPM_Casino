package logica;

import java.util.*;

public class Menu {

	private static final String PRODUCTS_FILE = "files/bebidas.dat";
	private List<ProductBar> productsList = null;
	private List<Usuario> usuariosList = null;

	public Menu() {
		productsList = new ArrayList<ProductBar>();
		loadProducts();
		usuariosList = new ArrayList<Usuario>();
		loadUsuarios();
	}

	private void loadProducts() {
		FileUtil.loadFile(PRODUCTS_FILE, productsList);
	}

	public ProductBar[] getProducts() {
		ProductBar[] products = productsList.toArray(new ProductBar[productsList.size()]);
		return products;
	}

	private void loadUsuarios() {
		FileUtil.loadFileCliente(usuariosList);
	}

	public Usuario[] getUsuarios() {
		Usuario[] usuarios = usuariosList.toArray(new Usuario[usuariosList.size()]);
		System.out.print(usuarios[1].toString());
		return usuarios;
	}
	
	public Usuario buscarUsuario(String nombreUsuario, String contrasenna) {
		for (Usuario u : usuariosList) {
			if(u.getNombreUsuario().equals(nombreUsuario) && u.getContrasenna().equals(contrasenna))
				return u;
		}
		return null;
	}

	public boolean dniYaExiste(String dni) {
		for (Usuario u : usuariosList) {
			if(u.getDni().equals(dni))
				return true;
		}
		return false;
	}
}

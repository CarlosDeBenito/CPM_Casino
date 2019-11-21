package logica;

import java.util.*;

public class Menu {

	private static final String PRODUCTS_FILE = "files/bebidas.dat";
	private List<ProductBar> productsList = null;

	public Menu() {
		productsList = new ArrayList<ProductBar>();
		loadProducts();
	}

	private void loadProducts() {
		 FileUtil.loadFile (PRODUCTS_FILE, productsList);
	}

	public ProductBar[] getProducts() {
		ProductBar[] products = productsList.toArray(new ProductBar[productsList.size()]);
		return products;
	}

}

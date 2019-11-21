package logica;

import java.util.*;

public class OrderBar {

	private List<ProductBar> orderList = null;

	public List<ProductBar> getOrderList() {
		return orderList;
	}

	public OrderBar() {
		orderList = new ArrayList<ProductBar>();
	}

	public void add(ProductBar item, int units) {
		ProductBar itemInOrder = null;

		for (ProductBar a : orderList) {
			if (a.getCode().equals(item.getCode()))
				itemInOrder = a;
		}

		if (itemInOrder == null) {
			ProductBar itemToOrder = new ProductBar(item);
			itemToOrder.setUnits(units);
			orderList.add(itemToOrder);
		} else {
			int totalUnits = itemInOrder.getUnits() + units;
			itemInOrder.setUnits(totalUnits);
		}
	}

	public void remove(ProductBar item, int units) {
		ProductBar itemInOrder = null;

		for (ProductBar a : orderList) {
			if (a.getCode().equals(item.getCode()))
				itemInOrder = a;
		}

		if (itemInOrder != null) {
			int totalUnits = itemInOrder.getUnits() - units;
			itemInOrder.setUnits(totalUnits);
			if (totalUnits == 0)
				orderList.remove(itemInOrder);
		}
	}

	public boolean existeElProducto(ProductBar item) {
		boolean existe = false;
		for (ProductBar a : orderList) {
			if (a.getCode().equals(item.getCode())) {
				existe = true;
				return existe;
			}
		}
		return existe;
	}

	public int unidadesDelPedido(ProductBar item) {
		int uds = 0;
		for (ProductBar a : orderList) {
			if (a.getCode().equals(item.getCode())) {
				return a.getUnits();
			}
		}
		return uds;
	}

	public float calcTotal() {
		float total = 0.0f;
		for (ProductBar a : orderList) {
			total += a.getPrice() * a.getUnits();
		}
		return total;
	}

	public float calcDescuento() {
		float precioProductos = calcTotal();
		if (precioProductos >= 50)
			return (float) (precioProductos * 0.1);
		else
			return 0;
	}

	// public void saveOrder(String fileName) {
	// FileUtil.saveToFile(fileName, orderList);
	// }

	public void initialize() {
		orderList.clear();
	}

	public String toStringConDescuento(Usuario user) {
		String cadena = "";
		cadena += "TU PEDIDO: \n";
		cadena += "\n";
		for (ProductBar product : orderList) {
			cadena += product + "\n";
			;
		}
		cadena += "\n";
		cadena += "Precio productos: " + calcTotal() + "€ \n";
		cadena += "Descuentos oferta: " + calcDescuento() + "€ \n";
		cadena += "Importe total: " + (calcTotal() - calcDescuento()) + "€ \n";
		cadena += "Su saldo final sera de: " + (user.getDinero() - (calcTotal() - calcDescuento())) + "€ \n";
		return cadena;
	}

	@Override
	public String toString() {
		String cadena = "";
		for (ProductBar product : orderList) {
			cadena += product.toString2() + "\n";
			;
		}
		cadena += "\n";
		cadena += "Importe total: " + calcTotal() + "\n";
		return cadena;
	}
}
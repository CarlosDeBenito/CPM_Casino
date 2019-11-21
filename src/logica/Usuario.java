package logica;

public class Usuario {
	private String nombreApellido;
	private String contrasenna;
	private double dinero;
	private int[] monedero;
	private OrderBar orderBar;

	public Usuario(String nombreApellido, String contrasenna, double dinero, int[] monedero) {
		super();
		this.nombreApellido = nombreApellido;
		this.contrasenna = contrasenna;
		this.dinero = dinero;
		this.monedero = monedero;
	}

	public Usuario(String nombreApellido, String contrasenna, double dinero, OrderBar orderBar) {
		this.nombreApellido = nombreApellido;
		this.contrasenna = contrasenna;
		this.dinero = dinero;
		this.orderBar = new OrderBar();
		;
	}

	public OrderBar getOrderBar() {
		return orderBar;
	}

	public String getNombreApellido() {
		return nombreApellido;
	}

	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}

	public String getContrasenna() {
		return contrasenna;
	}

	public void setContrasenna(String contrasenna) {
		this.contrasenna = contrasenna;
	}

	public double getDinero() {
		return dinero;
	}

	public void setDinero(double dinero) {
		this.dinero = dinero;
	}

	public int[] getMonedero() {
		return monedero;
	}

	public void setMonedero(int[] monedero) {
		this.monedero = monedero;
	}

}

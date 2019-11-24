package logica;

public class Usuario {
	private String nombreApellido;
	private String nombreUsuario;
	private String dni;
	private String contrasenna;
	private double dinero;
	private int[] monedero;
	private OrderBar orderBar;

	public Usuario(String nombreApellido, String nombreUsuario, String contrasenna, String dni, double dinero,
			int[] monedero) {
		super();
		this.nombreApellido = nombreApellido;
		this.nombreUsuario = nombreUsuario;
		this.dni = dni;
		this.contrasenna = contrasenna;
		this.dinero = dinero;
		this.monedero = monedero;
	}

	public Usuario(String nombreApellido, String dni, String nombreUsuario, String contrasenna, double dinero) {
		this.nombreApellido = nombreApellido;
		this.nombreUsuario = nombreUsuario;
		this.dni = dni;
		this.contrasenna = contrasenna;
		this.dinero = dinero;
	}

	public Usuario(String nombreApellido, String contrasenna, double dinero, OrderBar orderBar) {
		this.nombreApellido = nombreApellido;
		this.contrasenna = contrasenna;
		this.dinero = dinero;
		this.orderBar = new OrderBar();
	}

	public Usuario(String nombreApellido, String dni, String nombreUsuario, String contrasenna) {
		this.nombreApellido = nombreApellido;
		this.nombreUsuario = nombreUsuario;
		this.dni = dni;
		this.contrasenna = contrasenna;
	}

	public Usuario() {
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

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Usuario [nombreApellido=" + nombreApellido + ", nombreUsuario=" + nombreUsuario + ", dni=" + dni
				+ ", contrasenna=" + contrasenna + "]";
	}
}

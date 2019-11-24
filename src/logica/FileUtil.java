package logica;

import java.io.*;
import java.util.*;

public abstract class FileUtil {

	private static Scanner delimitar;

	public static void loadFile(String fileName, List<ProductBar> productsList) {
		String line;
		String[] productData = null;
		try {
			BufferedReader file = new BufferedReader(new FileReader(fileName));
			while (file.ready()) {
				line = file.readLine();
				productData = line.split("@");
				productsList.add(new ProductBar(productData[0], productData[1], productData[2],
						Float.parseFloat(productData[3]), 0));
			}
			file.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("File not found.");
		} catch (IOException ioe) {
			new RuntimeException("I/O Error.");
		}
	}

	public static void saveToFile(String fileName, List<ProductBar> orderList) {
		try {
			BufferedWriter file = new BufferedWriter(new FileWriter("files/" + fileName + ".dat"));
			String line = orderList.toString();
			file.write(line);
			file.close();
		}

		catch (FileNotFoundException fnfe) {
			System.out.println("The file could not be saved.");
		} catch (IOException ioe) {
			new RuntimeException("I/O Error.");
		}
	}

	public static String setFileName() {
		String code = "";
		String base = "0123456789abcdefghijklmnopqrstuvwxyz";
		int length = 8;
		for (int i = 0; i < length; i++) {
			int numero = (int) (Math.random() * (base.length()));
			code += base.charAt(numero);
		}
		return code;
	}

	public static void crearArchivoClientes(ArrayList<Usuario> lista) {
		FileWriter flwriter = null;
		try {
			flwriter = new FileWriter("files/usuarios.dat");
			BufferedWriter bfwriter = new BufferedWriter(flwriter);
			for (Usuario usuario : lista) {
				bfwriter.write(usuario.getNombreApellido() + "\n");
			}
			bfwriter.close();
			System.out.println("Archivo creado satisfactoriamente..");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (flwriter != null) {
				try {
					flwriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static ArrayList<Usuario> leerArchivoClientes() {
		File file = new File("files/usuarios.dat");
		ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
		Scanner scanner;
		try {
			scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String linea = scanner.nextLine();
				delimitar = new Scanner(linea);
				delimitar.useDelimiter("\\s*,\\s*");
				Usuario e = new Usuario();
				e.setNombreApellido(delimitar.next());
				listaUsuarios.add(e);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return listaUsuarios;
	}

	public static void loadFileCliente(List<Usuario> usuariosList) {
		String line;
		String[] usuarioData = null;
		try {
			BufferedReader file = new BufferedReader(new FileReader("files/usuarios.dat"));
			while (file.ready()) {
				line = file.readLine();
				usuarioData = line.split("//");
				usuariosList.add(new Usuario(usuarioData[0], usuarioData[1], usuarioData[2], usuarioData[3], Double.parseDouble(usuarioData[4])));
			}
			file.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("File not found.");
		} catch (IOException ioe) {
			new RuntimeException("I/O Error.");
		}
	}

	public static void aniadirCliente(Usuario usuario) {
		FileWriter flwriter = null;
		try {
			flwriter = new FileWriter("files/usuarios.dat", true);
			BufferedWriter bfwriter = new BufferedWriter(flwriter);
			bfwriter.write(usuario.getNombreApellido() + "//" + usuario.getDni() + "//" + usuario.getNombreUsuario() + "//"
					+ usuario.getContrasenna() + "//" + usuario.getDinero() + "\n");
			bfwriter.close();
			System.out.println("Archivo modificado satisfactoriamente..");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (flwriter != null) {
				try {
					flwriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

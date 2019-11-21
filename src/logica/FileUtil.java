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

	// crea el archivo en disco, recibe como par�metro la lista de estudiantes
	public static void crearArchivoClientes(ArrayList<Usuario> lista) {
		FileWriter flwriter = null;
		try {
			// crea el flujo para escribir en el archivo
			flwriter = new FileWriter("files/usuarios.dat");
			// crea un buffer o flujo intermedio antes de escribir directamente en el
			// archivo
			BufferedWriter bfwriter = new BufferedWriter(flwriter);
			for (Usuario usuario : lista) {
				// escribe los datos en el archivo
				bfwriter.write(usuario.getNombreApellido() + "\n");
			}
			// cierra el buffer intermedio
			bfwriter.close();
			System.out.println("Archivo creado satisfactoriamente..");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (flwriter != null) {
				try {// cierra el flujo principal
					flwriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// crea el archivo en disco, retorna la lista de estudiantes
	public static ArrayList<Usuario> leerArchivoClientes() {
		// crea el flujo para leer desde el archivo
		File file = new File("files/usuarios.dat");
		ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
		Scanner scanner;
		try {
			// se pasa el flujo al objeto scanner
			scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				// el objeto scanner lee linea a linea desde el archivo
				String linea = scanner.nextLine();
				delimitar = new Scanner(linea);
				// se usa una expresi�n regular
				// que valida que antes o despues de una coma (,) exista cualquier cosa
				// parte la cadena recibida cada vez que encuentre una coma
				delimitar.useDelimiter("\\s*,\\s*");
				Usuario e = new Usuario();
				e.setNombreApellido(delimitar.next());
				listaUsuarios.add(e);
			}
			// se cierra el ojeto scanner
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return listaUsuarios;
	}

	// a�adir m�s estudiantes al archivo
	public void aniadirCliente(ArrayList<Usuario> lista) {
		FileWriter flwriter = null;
		try {// adem�s de la ruta del archivo recibe un par�metro de tipo boolean, que le
				// indican que se va a�adir m�s registros
			flwriter = new FileWriter("files/usuarios.dat", true);
			BufferedWriter bfwriter = new BufferedWriter(flwriter);
			for (Usuario usuario : lista) {
				// escribe los datos en el archivo
				bfwriter.write(usuario.getNombreApellido() + "\n");
			}
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

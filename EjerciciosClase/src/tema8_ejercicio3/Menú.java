package tema8_ejercicio3;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

public class Menú {
	static TreeSet<Producto> listaProductos = new TreeSet<Producto>();
	static Scanner sc = new Scanner(System.in);
	static Producto prod = null;
	static double precio;
	private static String listaProd=;

	public static void main(String[] args) {
		String nombre = "";

		String tipo;
		int opcion;
		int diasCaducar;

		System.out.println("!BIENVENIDO!");

		do {

			System.out.println("Por favor seleccione una de estas opciones:");
			System.out.println("1. Añadir producto");
			System.out.println("2. Listar productos");
			System.out.println("3. Eliminar producto");
			System.out.println("4. Modificar producto");
			System.out.println("5. Guardar producto");
			System.out.println("0. Salir");
			opcion = sc.nextInt();
			sc.nextLine();
			switch (opcion) {
			case 1:

				System.out.println("Por favor introduzca los datos del producto");
				System.out.println("nombre,precio y tipo de producto: 'perecedero', 'no perecedero' ");
				nombre = sc.nextLine();
				precio = sc.nextDouble();
				sc.nextLine();
				tipo = sc.nextLine();
				if (tipo.equalsIgnoreCase("perecedero")) {
					System.out.println("Por favor introduzca los días a caducar del producto");
					diasCaducar = sc.nextInt();
					sc.nextLine();
					prod = new Perecedero(nombre, precio, diasCaducar);
					listaProductos.add(prod);
				} else {
					System.out.println("Introduzca el tipo del producto");
					tipo = sc.nextLine();
					prod = new NoPerecedero(nombre, precio, tipo);
					listaProductos.add(prod);
				}

				break;

			case 2:
				for (Producto productos : listaProductos) {
					System.out.println(productos);
				}

				break;
			case 3:
				eliminar();
				break;

			case 4:
				modificar();
				break;
			case 5:

				break;

			case 0:
				// Mostramos un mensaje saliendo del sistema
				System.out.println("Saliendo del sistema...");

				break;
			}
		} while (opcion != 0);
	}

	/**
	 * 
	 * @param nombre
	 * @param o
	 * @param sc
	 * @param listaProductos
	 */

	public static void eliminar() {
		String nombre;
		System.out.println("Por favor introduzca el nombre del producto que desea eliminar");
		nombre = sc.nextLine();
		prod = new Producto(nombre);
		if (listaProductos.remove(prod)) {
			// Y mostrará un mensaje de eliminado correctamente
			System.out.println("Producto eliminado correctamente");
			// En caso contrario
		} else {
			// Mostrará un mensaje de que no se encuentra
			System.out.println(
					"No se ha podido eliminar el producto, compruebe que el producto se encuentre en el listado");
		}
	}

	public static void modificar() {
		System.out.println("Por favor introduzca el nombre del producto que desea modificar ");
		String nombre = sc.nextLine();
		prod = new Producto(nombre);
		if (listaProductos.contains(prod)) {
			for (Producto i : listaProductos) {
				if (i.equals(prod)) {

					System.out.println("Por favor seleccione una de estas opciones:");
					System.out.println("1. Modificar precio");
					System.out.println("2. Modificar días de caducidad");
					System.out.println("3. Modificar tipo del producto");
					int opcion = sc.nextInt();
					sc.nextLine();
					switch (opcion) {
					case 1:

						System.out.println("Introduzca el nuevo precio");
						double precio = sc.nextDouble();
						sc.nextLine();
						((Producto) i).setPrecio(precio);
						break;
					case 2:

						if (i instanceof Perecedero) {
							System.out.println("Introduzca los dias a caducar");
							int dias = sc.nextInt();
							sc.nextLine();
							((Perecedero) i).setDiasCaducar(dias);
						} else {
							System.out.println("No se puede hace este cambio porque el producto es perecedero");
						}

						break;
					case 3:

						if (i instanceof NoPerecedero) {
							System.out.println("Introduzca el tipo del producto");
							String tipo = sc.nextLine();
							((NoPerecedero) i).setTipo(tipo);
						}

						break;

					}
					break;
				}
			}
		}
	}

	public static void guardar() throws IOException {
		try {
			BufferedWriter in = new BufferedWriter(new FileWriter(listaProd));

			
			for (Producto producto : listaProductos) {

			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}

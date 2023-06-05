package tema8_ejercicio3;

import java.util.Scanner;
import java.util.TreeSet;




public class Menú {

	public static void main(String[] args) {
		String nombre;
		double precio;
		String tipo;
		int opcion;
		int diasCaducar;
		Producto prod=null;
		Perecedero perecedero=null;
		Scanner sc = new Scanner(System.in);
		
		TreeSet<Producto> listaProductos = new TreeSet<Producto>();
		
		Producto producto1 = new Producto ("galletas maria", 3.90);
		Producto producto2 = new Producto ("leche", 0.90);
		
		
		System.out.println("!BIENVENIDO!");
		System.out.println("Por favor seleccione una de estas opciones:");
		System.out.println("1. Añadir producto");
		System.out.println("2. Listar productos");
		System.out.println("3. Eliminar producto");
		System.out.println("0. Salir");
		opcion=sc.nextInt();

		switch (opcion) {
		case 1: 
			System.out.println("Por favor introduzca los datos del producto");
			System.out.println("nombre,precio y tipo de producto: 'perecedero', 'no perecedero' ");
			nombre=sc.nextLine();
			precio=sc.nextDouble();
			sc.nextLine();
			tipo=sc.nextLine();
			
			if(tipo.equalsIgnoreCase("perecedero")) {
				System.out.println("Por favor introduzca los días a caducar del producto");
				diasCaducar=sc.nextInt();
				perecedero = new Perecedero (nombre,precio,diasCaducar);
				Perecedero.add(perecedero);
			}
			
			prod = new Producto (nombre,precio);
			Producto.add(prod);
			break;
			
		case 2:
			for (Producto productos: listaProductos ) {
				System.out.println(productos);
			}
		
			
			break;
		case 3:
			System.out.println("Por favor introduzca el nombre del producto que desea eliminar");
			nombre=sc.nextLine();
			prod = new Producto (nombre);
			if (listaProductos.remove(prod)) {
				//Y mostrará un mensaje de eliminado correctamente
				System.out.println("Producto eliminado correctamente");
			// En caso contrario
			} else {
				//Mostrará un mensaje de que no se encuentra
				System.out.println("No se ha podido eliminar el producto, compruebe que el producto se encuentre en el listado");
			}
			break;
			
			
		case 0:
			//Mostramos un mensaje saliendo del sistema
			System.out.println("Saliendo del sistema...");
			
			break;
		}
	}

}

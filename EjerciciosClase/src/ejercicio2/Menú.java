package ejercicio2;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Scanner;

import ejercicio2.Electrodoméstico.Color;
import ejercicio2.Electrodoméstico.Letra;
import tema8_ejercicio3.NoPerecedero;
import tema8_ejercicio3.Perecedero;

public class Menú {

	static int opcion;
	static int codigoElec;
	static String tipoElectro;
	static double cargaLavadora;
	static double precio;
	static String color;
	static char consumoEnergetico;
	static double peso;
	static double resolucionTele;
	static boolean tdtTele;
	static Scanner sc = new Scanner(System.in);
	static LinkedHashSet<Electrodoméstico> coleccionElectro = new LinkedHashSet<Electrodoméstico>();

	public static void main(String[] args) {
		leerFichero();
		do {
			menu();
			opcion = sc.nextInt();
			sc.nextLine();

			switch (opcion) {
			case 1:
				añadirElectrodomestico();
				break;
			case 2:
				for (Electrodoméstico valores : coleccionElectro) {
					System.out.println(valores.toString());
					System.out.println();
				}
				break;
			case 3:
				modificarElectrodomestico();
				break;
			case 4:
				eliminarElectrodomestico();
				break;
			case 5:
				guardarFichero(coleccionElectro);
				break;
			case 0:
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opción incorrecta");
			}
		} while (opcion != 0);

	}

	public static LinkedHashSet<Electrodoméstico> leerFichero() {
		try {
			String linea = "";
			String electr[];
			Electrodoméstico e = null;
			Scanner sc = new Scanner(new FileReader("src\\ejercicio2\\electrodomesticos.txt"));
			while (sc.hasNextLine()) {
				linea = sc.nextLine();
				electr = linea.split(";");
				if (electr[0].equals("Lavadora")) {
					e = new Lavadora(Double.parseDouble(electr[6]), Integer.parseInt(electr[1]),
							Double.parseDouble(electr[2]), electr[3], electr[4].charAt(0),
							Double.parseDouble(electr[5]));
				} else if (electr[0].equals("Television")) {
					e = new Television(Double.parseDouble(electr[6]), Boolean.parseBoolean(electr[7]),
							Integer.parseInt(electr[1]), Double.parseDouble(electr[2]), electr[3], electr[4].charAt(0),
							Double.parseDouble(electr[5]));

				} else {
					e = new Electrodoméstico(Integer.parseInt(electr[1]), Double.parseDouble(electr[2]),
							String.valueOf(electr[3]), electr[4].charAt(0), Double.parseDouble(electr[5]));
				}
				coleccionElectro.add(e);
			}
		} catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el archivo");
			System.out.println(e.getMessage());
		}

		return coleccionElectro;
	}

	public static void guardarFichero(LinkedHashSet<Electrodoméstico> coleccionElectro) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("src\\ejercicio2\\Electrodomesticos.txt"));
			for (Electrodoméstico colect : coleccionElectro) {
				String cadena = colect.getCodigo() + ";" + colect.getPrecioBase() + ";" + colect.getColor() + ";"
						+ colect.getConsumoEnergetico() + ";" + colect.getPeso() + ";";

				if (colect instanceof Lavadora) {
					cadena = "Lavadora" + ";" + cadena + ((Lavadora) colect).getCarga();
				} else if (colect instanceof Television) {
					cadena = "Televisión" + ";" + cadena
							+ (((Television) colect).getResolucion() + ";" + ((Television) colect).isTdt());
				} else {
					cadena = "Electrodoméstico" + ";" + cadena;
				}
				bw.write(cadena);
				bw.newLine();
			}
			bw.flush();
		} catch (IOException e) {
			System.out.println("No se encuentra el fichero");
			System.out.println(e.getMessage());
		}
	}

	public static void eliminarElectrodomestico() {
		System.out.println("Por favor introduzca el código del electrodoméstico a eliminar: ");
		codigoElec = sc.nextInt();
		sc.nextLine();
		Electrodoméstico e = new Electrodoméstico(codigoElec);
		if (coleccionElectro.remove(e)) {
			System.out.println("Eliminado correctamente");
		} else {
			System.out.println("El electrodoméstico no existe");
		}
	}

	public static void modificarElectrodomestico() {
		System.out.println("Por favor introduzca el código del electrodoméstico a modificar: ");
		codigoElec = sc.nextInt();
		sc.nextLine();
		Electrodoméstico e = new Electrodoméstico(codigoElec);
		if (!coleccionElectro.contains(e)) {
			System.out.println("El electrodoméstico no existe");
		} else {
			System.out.println("Seleccione una opción: ");
			System.out.println("1. Precio");
			System.out.println("2. Color");
			System.out.println("3. Consumo");
			System.out.println("4. Peso");
			System.out.println("5. Carga");
			System.out.println("6. Resolución");
			System.out.println("7. Sintonizador");
			System.out.println();
			opcion = sc.nextInt();
			sc.nextLine();
			for (Electrodoméstico electr : coleccionElectro) {
				if (electr.equals(e)) {
					switch (opcion) {
					case 1:
						System.out.println("Introduzca el nuevo precio: ");
						precio = sc.nextDouble();
						sc.nextLine();
						electr.setPrecioBase(precio);
						break;
					case 2:
						System.out.println("Introduzca el nuevo Color: ");
						color = sc.next();
						sc.nextLine();
						electr.setColor(color);
						break;
					case 3:
						System.out.println("Introduzca el nuevo Consumo: ");
						consumoEnergetico = sc.next().charAt(0);
						sc.nextLine();
						electr.setConsumoEnergetico(consumoEnergetico);
						break;
					case 4:
						System.out.println("Introduzco el nuevo Peso: ");
						peso = sc.nextDouble();
						sc.nextLine();
						electr.setPeso(peso);
						break;
					case 5:
						if (electr instanceof Lavadora) {
							System.out.println("Introduzca la nueva carga: ");
							cargaLavadora = sc.nextDouble();
							sc.nextLine();
							((Lavadora) electr).setCarga(cargaLavadora);
						}
						break;

					case 6:
						System.out.println("Introduzca la nueva resolución: ");
						resolucionTele = sc.nextDouble();
						sc.nextLine();
						((Television) electr).setResolucion(resolucionTele);
						break;
					case 7:
						System.out.println("Sintonizador (True|False)");
						tdtTele = sc.nextBoolean();
						sc.nextLine();
						((Television) electr).setTdt(tdtTele);
						break;
					default:
						System.out.println("Opción incorrecta");
					}
				}
			}
		}
	}

	public static void añadirElectrodomestico() {
		System.out.println("Introduzca el código del electrodoméstico a añadir: ");
		codigoElec = sc.nextInt();
		sc.nextLine();
		Electrodoméstico elec = new Electrodoméstico(codigoElec);
		if (coleccionElectro.contains(elec)) {
			System.out.println("Ya existe el producto");
		} else {
			System.out.println("Precio del producto: ");
			precio = sc.nextDouble();
			sc.nextLine();
			System.out.println("Color: ");
			color = sc.next();
			sc.nextLine();
			System.out.println("Consumo energético: ");
			consumoEnergetico = sc.next().charAt(0);
			sc.nextLine();
			System.out.println("Peso: ");
			peso =sc.nextDouble();
			sc.nextLine();
			System.out.println("Tipo de electrodoméstico (Lavadora|Televisión): ");
			tipoElectro = sc.next();
			sc.nextLine();
			Electrodoméstico elect = null;
			if (tipoElectro.equalsIgnoreCase("Lavadora")) {
				System.out.println("Por favor introduzca la carga de la lavadora");
				cargaLavadora = sc.nextInt();
				sc.nextLine();
				Lavadora lavadora = new Lavadora(cargaLavadora, codigoElec, precio, color, consumoEnergetico, peso);
				coleccionElectro.add(lavadora);
			} else {
				System.out.println("Introduzca la resolución de la televisión");
				resolucionTele = sc.nextDouble();
				sc.nextLine();
				System.out.println("Contiene sintonizador (True|False): ");
				tdtTele = sc.nextBoolean();
				sc.nextLine();
				Television tele = new Television(resolucionTele, tdtTele, codigoElec, precio, color, consumoEnergetico,
						peso);
				coleccionElectro.add(tele);
			}
			
		}
	}

	public static void menu() {
		System.out.println("Por favor seleccione una  una opción: ");
		System.out.println("1. Añadir electrodoméstico");
		System.out.println("2. Listar electrodomésticos");
		System.out.println("3. Modificar electrodoméstico");
		System.out.println("4. Eliminar electrodoméstico");
		System.out.println("5. Guardar en fichero");
		System.out.println("0. Salir");
		System.out.println();

	}

}

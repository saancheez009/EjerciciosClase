package ejercicio2;

import java.util.Objects;

public class Electrodoméstico implements Comparable<Electrodoméstico> {
	enum Color {
		blanco, negro, rojo, azul, gris
	}

	enum Letra {
		A, B, C, D, E, F
	}

	protected int codigo;
	protected int precioBase = 100;
	protected Color color;
	protected Letra consumoEnergetico;
	protected int peso = 5;

	public Electrodoméstico() {
		super();
	}

	/**
	 * 
	 * @param codigo
	 */
	public Electrodoméstico(int codigo) {
		super();
		if (codigo > 0) {
			this.codigo = codigo;
		}
	}

	/**
	 * 
	 * @param codigo
	 * @param precioBase
	 * @param peso
	 */
	public Electrodoméstico(int codigo, double precioBase, double peso) {
		super();
		if (codigo > 0) {
			this.codigo = codigo;
		}
		if (precioBase > 0) {
			this.precioBase = (int) precioBase;
		}
		if (peso > 0) {
			this.peso = (int) peso;
		}
	}

	/**
	 * 
	 * @param codigo
	 * @param precioBase
	 * @param color
	 * @param consumoEnergetico
	 * @param peso
	 */
	public Electrodoméstico(int codigo, double precioBase, String color, char consumoEnergetico, double peso) {
		super();
		if (codigo > 0) {
			this.codigo = codigo;
		}
		if (precioBase > 0) {
			this.precioBase = (int) precioBase;
		}
		comprobarColor(color);
		comprobarConsumoEnergetico(consumoEnergetico);
		if (precioBase > 0) {
			this.precioBase = (int) precioBase;
		}
	}

	/**
	 * 
	 * @return
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * 
	 * @param codigo
	 */
	public void setCodigo(int codigo) {
		if (codigo > 0) {
			this.codigo = codigo;
		}
	}

	/**
	 * 
	 * @return
	 */
	public double getPrecioBase() {
		return precioBase;
	}

	/**
	 * 
	 * @param precioBase
	 */
	public void setPrecioBase(double precioBase) {
		if (precioBase > 0) {
			this.precioBase = (int) precioBase;
		}
	}

	/**
	 * 
	 * @return
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * 
	 * @param color
	 */
	public void setColor(String color) {
		comprobarColor(color);
	}

	/**
	 * 
	 * @return
	 */
	public Letra getConsumoEnergetico() {
		return consumoEnergetico;
	}

	/**
	 * 
	 * @param consumoEnergetico
	 */
	public void setConsumoEnergetico(char consumoEnergetico) {
		comprobarConsumoEnergetico(consumoEnergetico);
	}

	/**
	 * 
	 * @return
	 */
	public double getPeso() {
		return peso;
	}

	/**
	 * 
	 * @param peso
	 */
	public void setPeso(double peso) {
		if (peso > 0) {
			this.peso = (int) peso;
		}
	}

	@Override
	public boolean equals(Object o) {
		boolean estado = false;
		Electrodoméstico electro = (Electrodoméstico) o;
		if (this.codigo == electro.codigo) {
			estado = true;
		}

		return estado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	/**
	 * 
	 * @param letra
	 * @return
	 */
	private Letra comprobarConsumoEnergetico(char letra) {
		switch (letra) {
		case 'A', 'B', 'C', 'D', 'E', 'F':
			consumoEnergetico = Letra.valueOf(String.valueOf(letra));
			break;
		default:
			consumoEnergetico = Letra.F;
		}

		return consumoEnergetico;
	}

	/**
	 * 
	 * @param color
	 * @return
	 */
	private Color comprobarColor(String color) {
		if (color.equals("Blanco") || color.equals("Negro") || color.equals("Rojo") || color.equals("Azul")
				|| color.equals("Gris")) {
			this.color = Color.valueOf(color);
		} else {
			this.color = Color.blanco;
		}

		return this.color;
	}

	/**
	 * 
	 */
	public void precioFinal() {
		switch (consumoEnergetico) {
		case A:
			precioBase += 100;
		case B:
			precioBase += 80;
		case C:
			precioBase += 60;
		case D:
			precioBase += 50;
		case E:
			precioBase += 30;
		case F:
			precioBase += 10;
		default:
			System.out.println("El consumo energético no existe");
		}

		if (peso > 0 && peso <= 19) {
			precioBase += 10;
		} else if (peso >= 20 && peso <= 49) {
			precioBase += 50;
		} else if (peso >= 50 && peso <= 79) {
			precioBase += 80;
		} else if (peso > 80) {
			precioBase += 100;
		}
	}

	public String toString() {
		String result = "";
		result = "Código: " + codigo + "\nPrecio Base: " + precioBase + "\nColor: " + color + "\nConsumo: " 
		+ consumoEnergetico + "\nPeso: " + peso;

		return result;
	}

	public int compareTo(Electrodoméstico o) {
		int result = 0;
		result = this.codigo - o.codigo;
		return result;

	}

}
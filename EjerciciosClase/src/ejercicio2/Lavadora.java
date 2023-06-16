package ejercicio2;

public class Lavadora extends Electrodoméstico {

	double carga = 5;
	
	public Lavadora() {
		super();
	}
	/**
	 * 
	 * @param carga
	 */
	public Lavadora(double carga) {
		super();
		this.carga = carga;
	}
	/**
	 * 
	 * @param codigo
	 */
	public Lavadora(int codigo) {
		super(codigo);
	}
	
	/**
	 * 
	 * @param codigo
	 * @param precio
	 * @param peso
	 */
	public Lavadora(int codigo, double precio, double peso) {
		super(codigo, precio, peso);
	}
	/**
	 * 
	 * @param carga
	 * @param codigo
	 * @param precio
	 * @param color
	 * @param consumo
	 * @param peso
	 */
	public Lavadora(double carga, int codigo, double precio, String color, char consumo, double peso) {
		super(codigo, precio, color, consumo, peso);
		if (carga > 0) {
			this.carga = carga;
		}
	}
	/**
	 * 
	 * @param carga
	 */
	public void setCarga(double carga) {
		if (carga > 0) {
			this.carga = carga;
		}
	}

	@Override
	public void precioFinal() {
		super.precioFinal();
		if (carga > 30) {
			precioBase += 50;
		}
	}

	public String toString() {
		String result = "";
		result = "Electrodoméstico: Lavadora" + "\n" + super.toString() + "\nCarga: " + carga;
		return result;
	}
	/**
	 * 
	 * @return
	 */
	public String getCarga() {
	
		return null;
	}

}

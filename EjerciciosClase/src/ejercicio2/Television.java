package ejercicio2;

public class Television extends Electrodoméstico{
	double resolucion=20;
	boolean tdt = false;
	
	public Television() {
		super();
	}
	/**
	 * 
	 * @param codigo
	 */
	public Television(int codigo) {
		super(codigo);
	}
	/**
	 * 
	 * @param codigo
	 * @param precio
	 * @param peso
	 */
	public Television(int codigo, double precio, double peso) {
		super(codigo, precio, peso);
	}
	
	/**
	 * 
	 * @param resolucion
	 * @param tdt
	 * @param codigo
	 * @param precio
	 * @param color
	 * @param consumo
	 * @param peso
	 */
	public Television(double resolucion, boolean tdt, int codigo, double precio, String color, char consumo,
			double peso) {
		super(codigo, precio, color, consumo, peso);
		if (resolucion > 0) {
			this.resolucion = resolucion;
		}
		this.tdt = tdt;
	}
	/**
	 * 
	 * @return
	 */
	public double getResolucion() {
		return resolucion;
	}

	/**
	 * 
	 * @param resolucion
	 */
	public void setResolucion(double resolucion) {
		if (resolucion > 0) {
			this.resolucion = resolucion;
		}
	}

	/**
	 * 
	 * @return
	 */
	public boolean isTdt() {
		return tdt;
	}
	/**
	 * 
	 * @param tdt
	 */
	public void setTdt(boolean tdt) {
		this.tdt = tdt;
	}

	@Override
	public void precioFinal() {
		super.precioFinal();
		if (resolucion > 40) {
			precioBase += (precioBase / 100) * 30;
		}
		if (tdt) {
			precioBase += 50;
		}
	}

	/**
	 * 
	 */
	public String toString() {
		String result = "";
		result = "Electrodoméstico: Televisión" + "\n" + super.toString() + "\nResolución: " + resolucion +
				"\nSintonizador TDT: " + (tdt ? "Si" : "No");

		return result;
	}


}

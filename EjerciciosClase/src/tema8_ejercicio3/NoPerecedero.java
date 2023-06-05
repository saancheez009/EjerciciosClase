package tema8_ejercicio3;

public class NoPerecedero extends Producto {
	private String tipo;

	public NoPerecedero() {
		super();

	}

	/**
	 * 
	 * @param nombre
	 * @param precio
	 */
	public NoPerecedero(String nombre, double precio, String tipo) {
		super(nombre, precio);
		if (tipo != null && !tipo.isEmpty()) {
			this.tipo = tipo;
		}
	}

	/**
	 * 
	 * @return
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * 
	 * @param tipo
	 */
	public void setTipo(String tipo) {
		if (tipo != null && !tipo.isEmpty()) {
			this.tipo = tipo;
		}
	}

	@Override
	public String toString() {
		return super.toString()+"\nTipo:" + tipo;
	}

}

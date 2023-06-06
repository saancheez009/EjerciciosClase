package tema8_ejercicio3;

import java.util.Objects;

public class Producto implements Comparable<Producto> {
	protected String nombre = " ";
	protected double precio;

	public Producto() {
		super();

	}
	
/**
 * 
 * @param nombre
 */
	public Producto(String nombre) {
		super();
		this.nombre = nombre;
	}


	/**
	 * 
	 * @param nombre
	 * @param precio
	 */
	public Producto(String nombre,double precio) {
		super();
		if (nombre != null && !nombre.isEmpty()) {
			this.nombre = nombre;
		}
		if (precio > 0) {
			this.precio = precio;
		}
	}

	/**
	 * 
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		if (nombre != null && !nombre.isEmpty()) {
			this.nombre = nombre;
		}
	}

	/**
	 * 
	 * @return
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * 
	 * @param precio
	 */
	public void setPrecio(double precio) {
		if (precio > 0) {
			this.precio = precio;
		}
	}

	/**
	 * 
	 * @param cantidad
	 * @return
	 */
	public double calcular(int cantidad) {
		return cantidad * precio;
	}

	@Override
	public String toString() {
		return "Producto: \n" + "nombre:" + nombre + "\n" + "precio:" + precio;
	}

	@Override
	public int compareTo(Producto o) {
		int res=this.nombre.compareTo(o.nombre);
		return res;
	}

	
	@Override
	public boolean equals(Object obj) {
		boolean res=false;
		Producto prod = (Producto) obj;
		if(this.nombre.equals(prod.nombre)) {
			res=true;
		}
		return res;
	}

	

}

package tema8_ejercicio3;

public class Perecedero extends Producto{
	private int diasCaducar;

	public Perecedero() {
		super();
		
	}
/**
 * 
 * @param nombre
 * @param precio
 */
	public Perecedero(String nombre, double precio,int diasCaducar) {
		super(nombre, precio);
		if(diasCaducar>0) {
			this.diasCaducar = diasCaducar;
		}
	}

	@Override
	public double calcular(int cantidad) {
		double result = super.calcular(cantidad);

		if (diasCaducar == 1) {
			result /= 4;
		} else if (diasCaducar == 2) {
			result /= 3;
		} else if (diasCaducar == 3) {
			result /= 2;
		}

		return result;
	}

@Override
public String toString() {
	return super.toString()+"\nDías a caducar:" + diasCaducar ;
}
	
	

}

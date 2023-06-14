package ejercicio2;

public class Electrodoméstico1 {
	
protected int codigo;
protected int precioBase;
protected String color;
protected String consumoEnergetico;
protected int peso;








public Electrodoméstico1(int codigo, int precioBase, String color, String consumoEnergetico, int peso) {
	super();
	this.codigo = codigo;
	this.precioBase = precioBase;
	this.color = color;
	this.consumoEnergetico = consumoEnergetico;
	this.peso = peso;
}




public void Electrodoméstico() {
	
	this.precioBase = 100;
	this.color = "blanco";
	this.consumoEnergetico = "F";
	this.peso = 5;
}




public static String comprobarColor(String color){
    switch (color.toLowerCase()){
        case "blanco", "negro","rojo", "azul", "gris":
            break;
        default:
            color = "blanco";
    }
    return color;
}
}

package grand_restaurante;
import java.util.*;

import java.util.UUID;
//[["123", "100USD", "Helado"],[],[]]
public class Plato {
	static Scanner scanner = new Scanner(System.in);
    int codigoPlato;
    String descripcion;
    double precioU ;
    public Plato(int codigoPlato, String descripcion, double precioU) {
        this.codigoPlato = codigoPlato;
        this.descripcion = descripcion;
        this.precioU = precioU;
    }
    
    public static void comidas(Plato[] platos){

        for (int i = 0; i < platos.length; i++) {
            int codigoP = Helper.validarEntero("ingrese el codigo de plato: ");
            String descripcion = Helper.validarString("ingrese el nombre y descripcion del plato: ");
            double precioU = Helper.validarPrecio("ingrese el el precio: ");
            
            platos[i]= new Plato(codigoP, descripcion, precioU);
        }
    }
    
    public static void mostrarPlatos(Plato[] platos) {
    	for (Plato plato : platos) {
           System.out.println(plato);
        }
    }

	public int getCodigoPlato() {
		return codigoPlato;
	}

	public void setCodigoPlato(int codigoPlato) {
		this.codigoPlato = codigoPlato;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioU() {
		return precioU;
	}

	public void setPrecioU(double precioU) {
		this.precioU = precioU;
	}
    
    
}

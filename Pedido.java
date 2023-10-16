package grand_restaurante;
import java.util.Scanner;
public class Pedido {
	Scanner scanner = new Scanner(System.in);
	private static int contador = 1;
    private int numeroPedido;
    private int numeroMesa;
    private String estadoPedido;
    private Plato[] ordenDePlatos;
    private String platoSeleccionados[]; //["flan", "fideos", "pez"]
    
    public Pedido(int numeroMesa,Plato[] ordenDePlatos) {
        ++this.numeroPedido;
        this.numeroMesa=numeroMesa;
        this.estadoPedido = "espera";
        this.ordenDePlatos = ordenDePlatos;
        this.platoSeleccionados = new String[4];
    }
    
    public void generarPedido(Plato[] platos) {
    	System.out.println("Elegir plato/s (hasta 4): ");
    	
    	for(int i=0; i<4;i++) {
    		String platoElegido = Helper.validarString("Ingrese el nombre del plato");
    		platoSeleccionados[i]= new String(platoElegido);
    		Pedido nuevoPedido = new Pedido(i, platoSeleccionados[i]);
    		System.out.println("Quiere añadir otro plato? (si/no)");
    		String respuesta = scanner.nextLine();
    		if(respuesta.equalsIgnoreCase("no")) {
    			break;
    		}
    	}
    }
    // Getters y setters
}

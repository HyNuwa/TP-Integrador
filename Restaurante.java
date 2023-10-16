package grand_restaurante;

import java.util.Scanner;

public class Restaurante {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("---INICIO JORNADA LABORAL---");
        int cantidadMesa = Helper.validarEntero("Cantidad de mesas que posee el local: ");
        Mesa[] mesas = new Mesa[cantidadMesa];
        Mesa.asignarPorcentajeMesas(mesas);
        
        int cantidadPlatos = Helper.validarEntero("Cantidad de Platos disponibles en la carta: ");
        Plato[] platos = new Plato[cantidadPlatos];
        Plato.comidas(platos);
        
        while (true) {
        	System.out.println("---CONSULTAS Y SERVICIO A MESA---");
            System.out.println("Menú: \n 1. Consulta de mesas disponibles "
            		+ "\n 2. Consulta de mesas ocupadas "
            		+ "\n 3. Consulta por número de mesa "
            		+ "\n 4. Ocupar una mesa "
            		+ "\n 5. Consulta de total de clientes en espera, atendidos y servidos. "
            		+ "\n 6. Consultar total de clientes en restaurante "
            		+ "\n 7. Atencion de Mesas "
            		+ "\n ---GESTION DE PEDIDO--- "
            		+ "\n 8. Alta de pedido"
            		+ "\n 9. Salir "
            		+ "\n Seleccione una opción: ");
            System.out.println(" ");
            int opcion = Helper.validarEntero("Ingrese una opcion del 1 al 9");

            switch (opcion) {
                case 1:
                    Mesa.consultarMesasDisponibles(mesas);
                    break;
                case 2:
                    Mesa.consultarMesasOcupadas(mesas);
                    break;
                case 3:
                    Mesa.consultarPorNumeroMesa(mesas);
                    break;
                case 4:
                	Mesa.ocuparMesa(mesas);
                    break;
                case 5:
                    Mesa.consultarTotales(mesas);
                    break;
                case 6:
                	System.out.println(Mesa.getClientesTotales());
                	break;
                case 7:
                	//Mesa.atencionMesas(mesas); //
                	break;
                case 8:
                	Plato.mostrarPlatos(platos);
                	//
                	break;
                case 9:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
	}

}

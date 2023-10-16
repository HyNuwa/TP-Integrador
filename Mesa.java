package grand_restaurante;
import java.util.Scanner;
public class Mesa {
	static Scanner scanner = new Scanner(System.in);
    int numero;
    int capacidad;
    String estado;
    String servicio;
    int comensales;
    static int clientesTotales=0;
    Mesa(int numero, int capacidad) {
        this.numero = numero;
        this.capacidad = capacidad;
        this.estado = "libre";
        this.servicio = "ninguno";
        this.comensales = 0;
    }
    
    public static void atencionMesas(Mesa[] mesas, int comensales) {
        System.out.println("Mesas disponibles:");
        for (Mesa mesa : mesas) {
            if (mesa.estado.equals("espera")) {
                mesa.mostrarInformacion();
            }
        }
        System.out.print("Seleccione una mesa para atender: ");
        int numeroMesaOcupar = scanner.nextInt();
        if (numeroMesaOcupar >= 1 && numeroMesaOcupar<=mesas.length) {
            mesas[numeroMesaOcupar - 1].ocupar(comensales);
        } else {
            System.out.println("Número de mesa no válido.");
        }
    }
    
    public void ocupar(int comensales) {
        if (this.estado.equals("libre") && comensales <= capacidad) {
            this.estado = "ocupada";
            this.servicio = "espera";
            this.comensales = comensales;
            ++Mesa.clientesTotales;
            System.out.println("Mesa " + numero + " ocupada por " + comensales + " comensales.");
        } else {
            System.out.println("No es posible ocupar la mesa " + numero + ", capacidad superada");
        }
    }	

    public void atender() {
        if (this.estado.equals("ocupada") && this.servicio.equals("espera")) {
            this.servicio = "atendida";
            System.out.println("Mesa " + numero + " atendida.");
        }
    }

    public void mostrarInformacion() {
        System.out.println("NÃºmero de mesa: " + numero);
        System.out.println("Capacidad: " + capacidad);
        System.out.println("Estado: " + estado);
        System.out.println("Servicio: " + servicio);
        System.out.println("Comensales: " + comensales);
    }
    public void mostrarServicio() {
        System.out.println("NÃºmero de mesa: " + numero);
        System.out.println("Total de clientes en espera: " + servicio);

    }
    public void mostrarInformacionMesasOcupadas() {
        System.out.println("NÃºmero de mesa: " + numero);
        System.out.println("Capacidad: " + capacidad);
        System.out.println("Estado: " + estado);
        if (estado.equals("ocupada")) {
            System.out.println("Servicio: " + servicio);
            System.out.println("Comensales: " + comensales);
        }
    }
    
    public static void asignarPorcentajeMesas(Mesa[] mesas) {
    	int cantidadMesas2Asientos = (int)(0.3 * mesas.length);
    	for (int i = 0; i < mesas.length; i++) {
            if (i < cantidadMesas2Asientos) {
                mesas[i] = new Mesa(i + 1,2);
            } else {
                mesas[i] = new Mesa(i + 1, 4);
            }
        }
    }
    
    public static void consultarMesasDisponibles(Mesa[] mesas) {
    	System.out.println("Mesas disponibles:");
        for (Mesa mesa : mesas) {
            if (mesa.estado.equals("libre")) {
                mesa.mostrarInformacion();
            }
        }
    }
    public static void consultarMesasOcupadas(Mesa[] mesas) {
    	System.out.println("Mesas ocupadas:");
        for (Mesa mesa : mesas) {
            if (mesa.estado.equals("ocupada")) {
                mesa.mostrarInformacion();
            }
        }
    }
    public static void consultarPorNumeroMesa(Mesa[] mesas) {
    	System.out.print("Ingrese el número de mesa: ");
		int numeroMesa = scanner.nextInt();
        if (numeroMesa >= 1 && numeroMesa <= mesas.length) {
            mesas[numeroMesa - 1].mostrarInformacionMesasOcupadas();
        } else {
            System.out.println("Número de mesa no válido.");
        }
    }
    public static void ocuparMesa(Mesa[] mesas) {
    	System.out.print("Ingrese la cantidad de comensales: ");
        int comensales = scanner.nextInt();
        System.out.println("Mesas disponibles:");
        for (Mesa mesa : mesas) {
            if (mesa.estado.equals("libre") && mesa.capacidad >= comensales) {
                mesa.mostrarInformacion();
            }
        }
        System.out.print("Seleccione una mesa para ocupar: ");
        int numeroMesaOcupar = scanner.nextInt();
        if (numeroMesaOcupar >= 1 && numeroMesaOcupar <= mesas.length) {
            mesas[numeroMesaOcupar - 1].ocupar(comensales);
        } else {
            System.out.println("Número de mesa no válido.");
        }
    }
    
    public static void consultarTotales(Mesa[] mesas) {
        int clientesEnEspera = 0;
        int clientesAtendidos = 0;
        int clientesServidos = 0;

        for (Mesa mesa : mesas) {
            if (mesa.estado.equals("ocupada") && mesa.servicio.equals("espera")) {
                clientesEnEspera += mesa.comensales;
            } else if (mesa.estado.equals("ocupada") && mesa.servicio.equals("atendida")) {
                clientesAtendidos += mesa.comensales;
            } else if (mesa.estado.equals("ocupada") && mesa.servicio.equals("servida")) {
                clientesServidos += mesa.comensales;
            }
        }

        System.out.println("Total de clientes en espera: " + clientesEnEspera);
        System.out.println("Total de clientes atendidos: " + clientesAtendidos);
        System.out.println("Total de clientes servidos: " + clientesServidos);
    }
    
	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	public static int getClientesTotales() {
		return clientesTotales;
	}

	public static void setClientesTotales(int clientesTotales) {
		Mesa.clientesTotales = clientesTotales;
	}

	public int getComensales() {
		return comensales;
	}

	public void setComensales(int comensales) {
		this.comensales = comensales;
	}
	
	
    
}



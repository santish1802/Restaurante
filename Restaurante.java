
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Restaurante {

    // ESTADISTICAS NUEVAS:
    //
    //
    //
    //
    //

    // 1.- registar nuevas mesa -
    // 2.- el tiempo de atención en base a platos o comidas (sub menu)
    // 3.- Liberar la mesa de la atención
    // 4.- Abrir el dia y cerrar el dia (pasar las estadisticas guardas en memoria sin archivo)
    //     En las estadisticas solicitar el dia primero
    // 5.- Meseros fijos, mostrar lista de meseros para atender. (sub menu)


    static Mesa[] mesas = new Mesa[10];  // 10 mesas disponibles
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        for (int i = 0; i < mesas.length; i++) {
            mesas[i] = new Mesa(i + 1);
        }

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    registrarMesa();
                    break;
                case 2:
                    asignarMesaACliente();
                    break;
                case 3:
                    asignarMeseroACliente();
                    break;
                case 4:
                    registrarAtencion();
                    break;
                case 5:
                    listarMesas();
                    break;
                case 6:
                    mostrarEstadisticasMenu();
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 7);
        scanner.close();
    }

    public static void mostrarMenu() {
        System.out.println("1. Registrar Mesa");
        System.out.println("2. Asignar Mesa a Cliente");
        System.out.println("3. Asignar Mesero a Cliente");
        System.out.println("4. Registrar Atención");
        System.out.println("5. Listar Mesas");
        System.out.println("6. Estadísticas");
        System.out.println("7. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public static void registrarMesa() {
        System.out.print("Ingrese el número de la mesa: ");
        String mesa = scanner.nextLine();
        if (isValidNumber(mesa)) {
            int mesaIndex = Integer.parseInt(mesa) - 1;
            mesas[mesaIndex] = new Mesa(mesaIndex + 1);
        } else {
            System.out.println("Número de mesa inválido.");
        }
    }

    public static void asignarMesaACliente() {
        System.out.print("Ingrese el nombre del cliente: ");
        String cliente = scanner.nextLine();
        System.out.print("Ingrese el número de la mesa: ");
        String mesa = scanner.nextLine();
        if (isValidNumber(mesa)) {
            int mesaIndex = Integer.parseInt(mesa) - 1;
            mesas[mesaIndex].setCliente(cliente);
        } else {
            System.out.println("Número de mesa inválido.");
        }
    }

    public static void asignarMeseroACliente() {
        System.out.print("Ingrese el nombre del mesero: ");
        String mesero = scanner.nextLine();
        System.out.print("Ingrese el número de la mesa: ");
        String mesa = scanner.nextLine();
        if (isValidNumber(mesa)) {
            int mesaIndex = Integer.parseInt(mesa) - 1;
            mesas[mesaIndex].setMesero(mesero);
        } else {
            System.out.println("Número de mesa inválido.");
        }
    }

    public static void registrarAtencion() {
        System.out.print("Ingrese el número de la mesa: ");
        String mesa = scanner.nextLine();
        if (isValidNumber(mesa)) {
            int mesaIndex = Integer.parseInt(mesa) - 1;
            System.out.print("Ingrese el tiempo de ocupación (en minutos): ");
            int tiempo = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            System.out.print("Ingrese el dinero facturado: ");
            double dinero = scanner.nextDouble();
            scanner.nextLine(); // Consumir el salto de línea
            mesas[mesaIndex].setTiempoOcupacion(tiempo);
            mesas[mesaIndex].setDineroFacturado(dinero);
        } else {
            System.out.println("Número de mesa inválido.");
        }
    }

    public static void listarMesas() {
        for (Mesa mesa : mesas) {
            System.out.println(mesa);
        }
    }

    public static void mostrarEstadisticasMenu() {
        int opcion;
        do {
            System.out.println("1. Tiempo de ocupación de mesas (por día)");
            System.out.println("2. Cantidad de clientes (por día)");
            System.out.println("3. Dinero facturado (por día, por mesero)");
            System.out.println("4. Dinero facturado por mesa (por día)");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    mostrarTiempoOcupacion();
                    break;
                case 2:
                    mostrarCantidadClientes();
                    break;
                case 3:
                    mostrarDineroFacturado();
                    break;
                case 4:
                    mostrarDineroPorMesa();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 5);
    }

    public static void mostrarTiempoOcupacion() {
        int tiempoTotal = 0;
        for (Mesa mesa : mesas) {
            tiempoTotal += mesa.getTiempoOcupacion();
        }
        System.out.println("Tiempo total de ocupación de mesas (por día): " + tiempoTotal + " minutos.");
    }

    public static void mostrarCantidadClientes() {
        int cantidadClientes = 0;
        for (Mesa mesa : mesas) {
            if (mesa.getCliente() != null) {
                cantidadClientes++;
            }
        }
        System.out.println("Cantidad de clientes (por día): " + cantidadClientes);
    }

    public static void mostrarDineroFacturado() {
        double dineroTotal = 0;
        for (Mesa mesa : mesas) {
            dineroTotal += mesa.getDineroFacturado();
        }
        System.out.println("Dinero facturado (por día): " + dineroTotal);
    }

    public static boolean isValidNumber(String number) {
        Pattern pattern = Pattern.compile("^\\d+$");
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }

    public static void mostrarDineroPorMesa() {
        for (Mesa mesa : mesas) {
            System.out.println("Dinero facturado por mesa " + mesa.getNumero() + " (por día): " + mesa.getDineroFacturado());
        }
    }
}
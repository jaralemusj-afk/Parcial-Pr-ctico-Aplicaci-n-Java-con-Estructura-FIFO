import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MenuPrincipal {

    static Queue<Cliente> colaClientes = new LinkedList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcion;

        do {

            mostrarMenu();

            while (!sc.hasNextInt()) {
                System.out.println("Entrada inválida.");
                sc.next();
            }

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1 -> agregarCliente(sc);

                case 2 -> atenderCliente();

                case 3 -> verProximoCliente();

                case 4 -> mostrarFilaCompleta();

                case 5 -> mostrarCantidadClientes();

                case 6 -> vaciarCola();

                case 7 -> System.out.println("\nGracias por usar el sistema.");

                default -> System.out.println("\nOpción inválida.");
            }

        } while (opcion != 7);

        sc.close();
    }

    // ===================================================
    // MENU
    // ===================================================

    public static void mostrarMenu() {

        System.out.println("\n========== BANCOMLOMBIA ==========");
        System.out.println("1. Agregar cliente");
        System.out.println("2. Atender siguiente cliente");
        System.out.println("3. Ver próximo cliente");
        System.out.println("4. Mostrar fila completa");
        System.out.println("5. Cantidad de clientes en espera");
        System.out.println("6. Vaciar cola");
        System.out.println("7. Salir");
        System.out.print("Seleccione una opción: ");
    }

    // ===================================================
    // AGREGAR CLIENTE
    // ===================================================

    public static void agregarCliente(Scanner sc) {

        try {

            System.out.print("\nNombre: ");
            String nombre = sc.nextLine();

            System.out.print("Identificación: ");
            String identificacion = sc.nextLine();

            System.out.print("Tipo de transacción (Deposito, Retiro, Consulta, Pago): ");
            String tipo = sc.nextLine();

            boolean prioridad;

            while (true) {

                System.out.print("¿Cliente prioritario? (true/false): ");

                if (sc.hasNextBoolean()) {

                    prioridad = sc.nextBoolean();
                    sc.nextLine();
                    break;

                } else {

                    System.out.println("Digite únicamente true o false.");
                    sc.next();
                }
            }

            Cliente nuevoCliente = new Cliente(
                    nombre,
                    identificacion,
                    tipo,
                    prioridad
            );

            // CLIENTE PRIORITARIO AL INICIO
            if (prioridad) {

                Queue<Cliente> temporal = new LinkedList<>();

                temporal.add(nuevoCliente);

                temporal.addAll(colaClientes);

                colaClientes = temporal;

            } else {

                colaClientes.add(nuevoCliente);
            }

            // MENSAJE CORREGIDO
            System.out.println("\n=================================");
            System.out.println("Cliente agregado correctamente.");
            System.out.println("Total clientes en cola: "
                    + colaClientes.size());
            System.out.println("=================================");

        } catch (Exception e) {

            System.out.println("\nError: " + e.getMessage());
        }
    }

    // ===================================================
    // ATENDER CLIENTE
    // ===================================================

    public static void atenderCliente() {

        if (colaClientes.isEmpty()) {

            System.out.println("\nNo hay clientes en espera.");

        } else {

            Cliente atendido = colaClientes.poll();

            System.out.println("\n===== CLIENTE ATENDIDO =====");
            System.out.println(atendido);

            // TOTAL ACTUALIZADO
            System.out.println("\nClientes restantes: "
                    + colaClientes.size());
        }
    }

    // ===================================================
    // VER PROXIMO CLIENTE
    // ===================================================

    public static void verProximoCliente() {

        if (colaClientes.isEmpty()) {

            System.out.println("\nLa cola está vacía.");

        } else {

            System.out.println("\n===== PRÓXIMO CLIENTE =====");

            Cliente proximo = colaClientes.peek();

            System.out.println(proximo);

            // TOTAL MOSTRADO
            System.out.println("\nTotal clientes en espera: "
                    + colaClientes.size());
        }
    }

    // ===================================================
    // MOSTRAR FILA
    // ===================================================

    public static void mostrarFilaCompleta() {

        if (colaClientes.isEmpty()) {

            System.out.println("\nNo hay clientes en la fila.");

        } else {

            System.out.println("\n===== CLIENTES EN ESPERA =====");

            int contador = 1;

            for (Cliente c : colaClientes) {

                System.out.println("\nCliente #" + contador);

                System.out.println(c);

                System.out.println("----------------------------");

                contador++;
            }

            // TOTAL FINAL
            System.out.println("Total clientes registrados: "
                    + colaClientes.size());
        }
    }

    // ===================================================
    // MOSTRAR CANTIDAD
    // ===================================================

    public static void mostrarCantidadClientes() {

        System.out.println("\nClientes en espera: "
                + colaClientes.size());
    }

    // ===================================================
    // VACIAR COLA
    // ===================================================

    public static void vaciarCola() {

        if (colaClientes.isEmpty()) {

            System.out.println("\nLa cola ya está vacía.");

        } else {

            colaClientes.clear();

            System.out.println("\nLa cola fue vaciada correctamente.");
            System.out.println("Clientes en espera: 0");
        }
    }
}
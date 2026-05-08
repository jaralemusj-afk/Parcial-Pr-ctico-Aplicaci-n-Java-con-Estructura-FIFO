
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MenuPrincipal {

    static Queue<Cliente> colaClientes = new LinkedList<>();

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            int opcion;

            do {

                System.out.println("\n===== BANCOMLOMBIA =====");
                System.out.println("1. Agregar cliente");
                System.out.println("2. Atender siguiente cliente");
                System.out.println("3. Ver próximo cliente");
                System.out.println("4. Mostrar fila completa");
                System.out.println("5. Cantidad de clientes en espera");
                System.out.println("6. Vaciar cola");
                System.out.println("7. Salir");
                System.out.print("Seleccione una opción: ");

                while (!sc.hasNextInt()) {
                    System.out.println("Entrada inválida. Digite un número.");
                    sc.next();
                }

                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {

                    case 1 -> {
                        try {

                            System.out.print("Nombre: ");
                            String nombre = sc.nextLine();

                            System.out.print("Identificación: ");
                            String identificacion = sc.nextLine();

                            System.out.print("Tipo de transacción (Depósito, Retiro, Consulta, Pago): ");
                            String tipo = sc.nextLine();

                            System.out.print("¿Cliente prioritario? (true/false): ");
                            boolean prioridad = sc.nextBoolean();
                            sc.nextLine();

                            Cliente nuevoCliente = new Cliente(
                                    nombre,
                                    identificacion,
                                    tipo,
                                    prioridad
                            );

                            colaClientes.offer(nuevoCliente);

                            System.out.println("\nCliente agregado correctamente.");

                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }

                    case 2 -> {
                        if (colaClientes.isEmpty()) {
                            System.out.println("\nNo hay clientes en espera.");
                        } else {

                            Cliente atendido = colaClientes.poll();

                            System.out.println("\nCliente atendido:");
                            System.out.println(atendido);
                        }
                    }

                    case 3 -> {
                        if (colaClientes.isEmpty()) {
                            System.out.println("\nLa cola está vacía.");
                        } else {

                            System.out.println("\nPróximo cliente:");
                            System.out.println(colaClientes.peek());
                        }
                    }

                    case 4 -> {
                        if (colaClientes.isEmpty()) {
                            System.out.println("\nNo hay clientes en la fila.");
                        } else {

                            System.out.println("\n===== CLIENTES EN ESPERA =====");

                            for (Cliente c : colaClientes) {
                                System.out.println(c);
                                System.out.println("----------------------");
                            }
                        }
                    }

                    case 5 ->
                        System.out.println("\nClientes en espera: "
                                + colaClientes.size());

                    case 6 -> {
                        colaClientes.clear();

                        System.out.println("\nLa cola fue vaciada correctamente.");
                    }

                    case 7 ->
                        System.out.println("\nGracias por usar el sistema.");

                    default ->
                        System.out.println("\nOpción inválida.");
                }

            } while (opcion != 7);
        }
    }
}

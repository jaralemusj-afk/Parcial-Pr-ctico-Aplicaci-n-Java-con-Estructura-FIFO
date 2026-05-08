import java.io.Serializable;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Cliente implements Serializable {

    private String nombre;
    private String identificacion;
    private String tipoTransaccion;
    private LocalTime horaLlegada;
    private boolean prioridad;

    public Cliente(String nombre, String identificacion,
                   String tipoTransaccion, boolean prioridad) {

        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }

        if (identificacion == null || !identificacion.matches("\\d+")) {
            throw new IllegalArgumentException("La identificación debe contener solo números.");
        }

        tipoTransaccion = tipoTransaccion.trim();

        if (!tipoTransaccion.equalsIgnoreCase("Deposito")
                && !tipoTransaccion.equalsIgnoreCase("Retiro")
                && !tipoTransaccion.equalsIgnoreCase("Consulta")
                && !tipoTransaccion.equalsIgnoreCase("Pago")) {

            throw new IllegalArgumentException(
                    "Transacción inválida. Use: Deposito, Retiro, Consulta o Pago."
            );
        }

        this.nombre = nombre;
        this.identificacion = identificacion;
        this.tipoTransaccion = tipoTransaccion;
        this.horaLlegada = LocalTime.now();
        this.prioridad = prioridad;
    }

    public boolean isPrioridad() {
        return prioridad;
    }

    @Override
    public String toString() {

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");

        return """
               Nombre: %s
               Identificación: %s
               Transacción: %s
               Hora llegada: %s
               Prioritario: %s
               """.formatted(
                nombre,
                identificacion,
                tipoTransaccion,
                horaLlegada.format(formato),
                prioridad ? "Sí" : "No"
        );
    }
}
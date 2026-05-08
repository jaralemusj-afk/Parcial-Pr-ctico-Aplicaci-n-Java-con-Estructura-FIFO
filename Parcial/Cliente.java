
import java.io.Serializable;
import java.time.LocalTime;

public class Cliente implements Serializable {

    private String nombre;
    private String identificacion;
    private String tipoTransaccion;
    private LocalTime horaLlegada;
    private boolean prioridad;

    public Cliente(String nombre, String identificacion, String tipoTransaccion, boolean prioridad) {

        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }

        if (identificacion == null || !identificacion.matches("\\d+")) {
            throw new IllegalArgumentException("La identificación debe contener solo números");
        }

        if (!tipoTransaccion.equalsIgnoreCase("Depósito")
                && !tipoTransaccion.equalsIgnoreCase("Retiro")
                && !tipoTransaccion.equalsIgnoreCase("Consulta")
                && !tipoTransaccion.equalsIgnoreCase("Pago")) {

            throw new IllegalArgumentException("Tipo de transacción inválido");
        }

        this.nombre = nombre;
        this.identificacion = identificacion;
        this.tipoTransaccion = tipoTransaccion;
        this.horaLlegada = LocalTime.now();
        this.prioridad = prioridad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public LocalTime getHoraLlegada() {
        return horaLlegada;
    }

    public boolean isPrioridad() {
        return prioridad;
    }

    public void setPrioridad(boolean prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {
        return "\nNombre: " + nombre
                + "\nIdentificación: " + identificacion
                + "\nTipo de transacción: " + tipoTransaccion
                + "\nHora de llegada: " + horaLlegada
                + "\nPrioridad: " + (prioridad ? "Sí" : "No");
    }
}

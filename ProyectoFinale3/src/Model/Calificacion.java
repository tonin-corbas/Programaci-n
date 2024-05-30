package Model;

/**
 * Clase Calificacion para representar una calificación de un personaje.
 */
public class Calificacion {
    private int idPersonaje;
    private double puntuacion;

    /**
     * Constructor de Calificacion.
     *
     * @param idPersonaje ID del personaje.
     * @param puntuacion  Puntuación del personaje.
     */
    public Calificacion(int idPersonaje, double puntuacion) {
        this.idPersonaje = idPersonaje;
        this.puntuacion = puntuacion;
    }

    public int getIdPersonaje() {
        return idPersonaje;
    }

    public double getPuntuacion() {
        return puntuacion;
    }
}

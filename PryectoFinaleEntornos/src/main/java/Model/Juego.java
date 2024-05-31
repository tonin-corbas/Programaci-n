package Model;

/**
 * Clase Juego para representar un juego.
 */
public class Juego {
    private int id;
    private String nombre;
    private String anio;
    private String sede;
    private String epoca;

    /**
     * Constructor de Juego.
     *
     * @param id     ID del juego.
     * @param nombre Nombre del juego.
     * @param anio   Año del juego.
     * @param sede   Sede del juego.
     * @param epoca  Época del juego.
     */
    public Juego(int id, String nombre, String anio, String sede, String epoca) {
        this.id = id;
        this.nombre = nombre;
        this.anio = anio;
        this.sede = sede;
        this.epoca = epoca;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAnio() {
        return anio;
    }

    public String getSede() {
        return sede;
    }

    public String getEpoca() {
        return epoca;
    }
}
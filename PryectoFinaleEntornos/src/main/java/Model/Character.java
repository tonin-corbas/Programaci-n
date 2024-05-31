package Model;

/**
 * Clase Character para representar un personaje.
 */
public class Character {
    private int id;
    private String nombre;
    private String apellido;
    private String hermandad;
    private int idJuego;

    /**
     * Constructor de Character.
     *
     * @param id        ID del personaje.
     * @param nombre    Nombre del personaje.
     * @param apellido  Apellido del personaje.
     * @param hermandad Hermandad del personaje.
     * @param idJuego   ID del juego al que pertenece el personaje.
     */
    public Character(int id, String nombre, String apellido, String hermandad, int idJuego) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.hermandad = hermandad;
        this.idJuego = idJuego;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getHermandad() {
        return hermandad;
    }

    public int getIdJuego() {
        return idJuego;
    }
}

package Modelos;

public class Personaje {
    private int id;
    private String nombre;
    private String apellido;
    private String hermandad;
    private int idJuego;

    // Constructor, getters y setters
    public Personaje(int id, String nombre, String apellido, String hermandad, int idJuego) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.hermandad = hermandad;
        this.idJuego = idJuego;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getHermandad() {
        return hermandad;
    }

    public void setHermandad(String hermandad) {
        this.hermandad = hermandad;
    }

    public int getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(int idJuego) {
        this.idJuego = idJuego;
    }
}

package Modelos;

public class Juego {
    private int id;
    private String nombre;
    private String ano;
    private String sede;
    private int idEpoca;

    // Constructor, getters y setters
    public Juego(int id, String nombre, String ano, String sede, int idEpoca) {
        this.id = id;
        this.nombre = nombre;
        this.ano = ano;
        this.sede = sede;
        this.idEpoca = idEpoca;
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

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public int getIdEpoca() {
        return idEpoca;
    }

    public void setIdEpoca(int idEpoca) {
        this.idEpoca = idEpoca;
    }

    @Override
    public String toString() {
        return nombre;
    }
}

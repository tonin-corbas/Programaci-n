public class Artista {

    private String nombre;
    private EstiloMusical estilo;
    private String cancion;
    private int oyentes;
    private String pais;

    public Artista(String nombre, EstiloMusical estilo, String cancion, int oyentes, String pais) {
        this.nombre = nombre;
        this.estilo = estilo;
        this.cancion = cancion;
        this.oyentes = oyentes;
        this.pais = pais;
    }

    public void pintarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Estilo: " + estilo);
        System.out.println("Canción: " + cancion);
        System.out.println("Oyentes: " + oyentes);
    }

    public String getNombre() {
        return nombre;
    }

    public EstiloMusical getEstilo() {
        return estilo;
    }

    public String getCancion() {
        return cancion;
    }

    public int getOyentes() {
        return oyentes;
    }

    public String getPais() {
        return pais;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEstilo(EstiloMusical estilo) {
        this.estilo = estilo;
    }

    public void setCancion(String cancion) {
        this.cancion = cancion;
    }

    public void setOyentes(int oyentes) {
        this.oyentes = oyentes;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
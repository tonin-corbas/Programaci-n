import java.util.ArrayList;
import java.util.List;

public class ColeccionArtistas {

    List<Artista> artistas = new ArrayList<>();

    /* No modificar */
    public ColeccionArtistas(List<Artista> artistas){
        this.artistas = artistas;
    }

    /* No modificar */
    public ColeccionArtistas(){
        this.artistas = new ArrayList<>();
    }

    //Debeis implementar los siguientes métodos:

    /**
     * Añade un nuevo artista a la colección.
     * El nuevo artista vendrá dado por parámetros.
     */
    public void añadirArtista(Artista artista){
      artistas.add(artista);
    }

    /**
     * Pinta la información de todos los artistas de tu colección.
     * Pista: Utilizar artisa.pintarInformacion()
     */
    public void pintarColeccion(){
        for (Artista artista : artistas) {
            artista.pintarInformacion();
        }
    }

    /**
     * Pinta por consola la información de un artista a partir de su nombre.
     * Se supone que no habrá varios artistas con el mismo nombre.
     */
    public void pintarArtistaPorNombre(String nombre){
        for (Artista artista : artistas) {
            if (artista.getNombre().equals(nombre)) {
                artista.pintarInformacion();
            }
        }
    }

    /**
     * Encuentra y devuelve el Artista de tu colección,
     * a partir del nombre de su canción más destacada.
     * Si no encuentra la canción, debe devolver null.
     */
    public Artista artistaPorCancion(String cancion){
        for (Artista artista : artistas) {
            if (artista.getCancion().equals(cancion)) {
                return artista;
            }
        }
        return null;
    }

    /**
     * Devuelve todos los artistas de tu colección,
     * que coincidan con el estilo musical pasado por parámetros.
     * Si no encuentra ningún artista, debe devolver una lista vacia.
     */
    public List<Artista> artistasPorEstilo(EstiloMusical estilo) {
        List<Artista> artistasPorEstilo = new ArrayList<>();
        for (Artista artista : artistas) {
            if (artista.getEstilo() == estilo) {
                artistasPorEstilo.add(artista);
            }
        }
        return artistasPorEstilo;
    }

    /**
     * Devuelve el artista mas escuchado de tu colección.
     * Si no encuentra ningún artista, devolver null.
     */
    public Artista artistaMasEscuchado () {
        Artista masEscuchado = artistas.get(0);
        for (Artista artista : artistas) {
            if (artista.getOyentes() > masEscuchado.getOyentes()) {
                masEscuchado = artista;
            }
        }
        return masEscuchado;
    }

    /**
     * Imprime por pantalla todos los tipos de estilos musicales de la colección.
     * Importante: No deben aparecer repetidos.
     */
    public void pintarEstilosMusicales () {
        List<EstiloMusical> estilos = new ArrayList<>();
        for (Artista artista : artistas) {
            estilos.add(artista.getEstilo());
        }
        for (EstiloMusical estilo : estilos) {
            System.out.println(estilo);
        }
    }
}


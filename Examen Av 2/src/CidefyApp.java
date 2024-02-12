import java.util.ArrayList;
import java.util.List;

public class CidefyApp {

    /**
     * Aquesta classe vos permet comprovar si els mètodes
     * de ColeccionArtistas funcionen correctament,
     * no heu de modificar aquesta classe.
     */
    public static void main(String[] args) {
        System.out.println("----------------------");
        System.out.println("- BATERIA DE PRUEBAS -");
        System.out.println("----------------------");

        //Hasta 1,5 puntos por tener Artista OK
        ColeccionArtistas coleccion = creaColeccionArtistas();

        //Hasta 1 punto por pintar bien la colección
        System.out.println("----------------------");
        System.out.println("Pintamos nuestra colección: ");
        coleccion.pintarColeccion();

        //Hasta 1 punto por pintarArtistaPorNombre()
        System.out.println("----------------------");
        System.out.println("Buscamos el artista por su nombre: ");
        coleccion.pintarArtistaPorNombre("Nil Moliner");

        //Hasta 1 punto por artistaPorCancion()
        System.out.println("----------------------");
        System.out.println("Buscamos el artista por su canción: ");
        Artista artista1 = coleccion.artistaPorCancion("R U Mine?");
        if(artista1 != null){
            System.out.println("Hemos encontrado: ");
            artista1.pintarInformacion();
        } else {
            System.out.println("Error. No se ha encontrado el artista...");
        }

        //Hasta 1 punto por artistasPorEstilo()
        System.out.println("----------------------");
        System.out.println("Buscamos el artista por su estilo: ");
        List<Artista> rockeros = coleccion.artistasPorEstilo(EstiloMusical.ROCK);
        if(rockeros.size() == 6){
            System.out.println("Hemos encontrado a los 6 rockeros");
        } else {
            System.out.println("Error. No coincide el número de rockeros...");
        }

        //Hasta 1 punto por artistaMasEscuchado()
        System.out.println("----------------------");
        System.out.println("Buscamos el artista más escuchado: ");
        Artista top1 = coleccion.artistaMasEscuchado();
        top1.pintarInformacion();

        //Hasta 0.5 puntos por pintarEstilosMusicales()
        //Hasta 0.5 puntos si no aparecen repetidos
        System.out.println("----------------------");
        System.out.println("Estilos musicales de la aplicación: ");
        coleccion.pintarEstilosMusicales();

        //Hasta 1 punto por añadirArtista()
        System.out.println("----------------------");
        System.out.println("Añadimos un nuevo artista: ");
        int antes = coleccion.artistas.size();
        coleccion.añadirArtista(new Artista("Deluxe", EstiloMusical.POP, "Tum Rakak", 500000, "Francia"));
        int despues = coleccion.artistas.size();
        if(despues == antes + 1){
            System.out.println("Se ha añadido el artista correctamente!");
        } else {
            System.out.println("Error. No se ha añadido el artista...");
        }

        System.out.println("----------------------");
        System.out.println("-------- FIN ---------");
        System.out.println("----------------------");
    }

    /**
     * Crea la coleccion con la lista de artistas de nuestra aplicación.
     */
    private static ColeccionArtistas creaColeccionArtistas(){
        Artista halsey = new Artista("Halsey", EstiloMusical.POP, "Closer", 41000000, "America");
        Artista edSheeran = new Artista("EdSheeran", EstiloMusical.POP, "Perfect", 81000000, "Reino Unido");
        Artista izal = new Artista("Izal", EstiloMusical.POP, "La mujer de verde", 1500000, "España");
        Artista nilMoliner = new Artista("Nil Moliner", EstiloMusical.POP, "Esperando", 2000000, "España");
        Artista supersubmarina = new Artista("Supersubmarina", EstiloMusical.POP, "Supersubmarina", 500000, "España");
        Artista articMonkeys = new Artista("Artic Monkeys", EstiloMusical.POP, "R U Mine?", 50000000, "Reino Unido");

        Artista sabaton = new Artista("Sabaton", EstiloMusical.ROCK, "The last stand", 3000000, "Suecia");
        Artista muse = new Artista("Muse", EstiloMusical.ROCK, "Uprising", 13000000, "Reino Unido");
        Artista lepoka = new Artista("Lepoka", EstiloMusical.ROCK, "Goliardos", 200000, "España");
        Artista exceso = new Artista("Exceso", EstiloMusical.ROCK, "Nieblas y Hollin", 25000, "España");
        Artista riseAgainst = new Artista("Rise Against", EstiloMusical.ROCK, "Savior", 7500000, "America");
        Artista greenDay = new Artista("Green Day", EstiloMusical.ROCK, "American Idiot", 32000000, "America");

        Artista jonBellion = new Artista("Jon Bellion", EstiloMusical.RAP, "Stupid Deep", 0, "America");
        Artista diaSexto = new Artista("Dia Sexto", EstiloMusical.RAP, "Mas", 50000, "España");
        Artista rayden = new Artista("Rayden", EstiloMusical.RAP, "Haz de luz", 500000, "España");
        Artista eminem = new Artista("Eminem", EstiloMusical.RAP, "Lose Yourself", 70000000, "America");
        Artista ajr = new Artista("AJR", EstiloMusical.RAP, "Bang!", 10000000, "Reino Unido");
        Artista nf = new Artista("NF", EstiloMusical.RAP, "Let You Down", 15500000, "America");

        List<Artista> artistas = new ArrayList<>(List.of(halsey, edSheeran, izal, nilMoliner, supersubmarina, articMonkeys,
                sabaton, muse, lepoka, exceso, riseAgainst, greenDay,
                jonBellion, diaSexto, rayden, eminem, ajr, nf)
        );

        return new ColeccionArtistas(artistas);
    }

}

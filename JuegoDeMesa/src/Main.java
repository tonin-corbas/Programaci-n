import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Juego> juegos = new ArrayList<>();
        juegos = crearColeccionJuegos();
        pintarColleccionJuegos(juegos);

        Juego juego1 = buscarJuegoPorNombre(juegos, "Catan");
        juego1.pintarInfo();

        List<Juego> coop = buscarJuegosPorCategoria(CategoriaTipo.Coop, juegos);
        pintarColleccionJuegos(coop);

    }

    public static List<Juego> crearColeccionJuegos(){
        Juego game1 = new Juego("Game 1", 9.5, 2000);
        Juego game2 = new Juego("Game 2", 6.54, 2022);
        Juego game3 = new Juego("Game 3", 9.0, 2005);
        Juego game4 = new Juego("Game 4", 5.1, 2017);
        Juego game5 = new Juego("Game 5", 7.75, 1997);
        return Arrays.asList(game1, game2, game3, game4, game5);
    }

    public static Juego buscarJuegoPorNombre(List<Juego> juegos, String nombre){
        for (Juego juego : juegos){
            if (Juego.getNombre().equals(nombre)){
                return juego;
            }
        }
        return null ;
    }

    public static List<Juego> buscarJuegosPorCategoria(CategoriaTipo categoria, List<Juego> juegos){
        for (Juego juego : juegos){
            if (Juego.getNombre().equals(categoria)){
                return (List<Juego>) juego;
            }
        }
        return null ;
    }

    public static void pintarColleccionJuegos(List<Juego> juegos){
        for (Juego juego : juegos){
            System.out.println("Nombre: " + juego.getNombre());
            System.out.println("Valoración: " + juego.getValoracion());
            System.out.println("Publicación: " + juego.getPublicacion());
            System.out.println("Categorías: " + juego.getCategorias());
            System.out.println("-------------------------");
        }
    }
}
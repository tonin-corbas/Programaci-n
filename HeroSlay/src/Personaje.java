import java.util.List;

public class Personaje {
    private String NombreP;

    private int Vida;

    private List<Cartas> mazo;

    private boolean Aturdido;

    public Personaje(String nombre, int vida, List<Cartas> mazo) {
        this.NombreP = nombre;
        this.Vida = vida;
        this.mazo = mazo;
        this.Aturdido = false;
    }


}

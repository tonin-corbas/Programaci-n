import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Personaje {
    private String NombreP;

    int Vida;

    private List<Cartas> mazo;

    private boolean Aturdido;

    public Personaje(String nombre, int vida, List<Cartas> mazo) {
        this.NombreP = nombre;
        this.Vida = vida;
        this.mazo = mazo;
        this.Aturdido = false;
    }

    public String mostrarInfo(){
        return String.format("%s | Vida: %d", NombreP, Vida);
    }

    public boolean isAturdido() {
        return Aturdido;
    }

    public void aplicarEfect(Cartas cartas, Personaje aturdido){
        switch (cartas.getTipo()) {
            case Ataque:
                if (!Aturdido) {
                    aturdido.tomarloDePechito(cartas.getAtc());
                }
                break;
            case Curacion:
                if (!Aturdido) {
                    this.curasion(cartas.getAtc());
                }
                break;
            case Aturdir:
                aturdido.aturdidito(cartas.getAtc());
                break;
        }
    }
    public void tomarloDePechito(int cantidad){
        Vida -= cantidad;
        if (Vida < 0) {
            Vida = 0;
        }
    }

    public void curasion(int cantidad){
        Vida += cantidad;
    }

    public void aturdidito(int cantidad){
        Aturdido = true;
        Vida -= cantidad;
        if (Vida < 0) {
            Vida = 0;
        }
    }

    public void quitarAturdidito() {
        Aturdido = false;
    }

    public Cartas elegir2Cartas(){
        Scanner scan = new Scanner(System.in);
        Collections.shuffle(mazo);

        for (int i = 0; i < 2; i++) {
            System.out.print((i + 1) + ". ");
            mazo.get(i).mostrarInfo();
        }

        int elec;
        do {
            System.out.print("Elige una carta de entre las dadas (1-2): ");
            elec = scan.nextInt();
        } while (elec < 1 || elec > 2);


        return mazo.get(elec - 1);
    }
}

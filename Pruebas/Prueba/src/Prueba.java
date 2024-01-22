import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

enum CartaTipo {
    ATAQUE, CURA, ATURDIR
}

class Carta {
    private String nombre;
    private CartaTipo tipo;
    private int valor;

    public Carta(String nombre, CartaTipo tipo, int valor) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.valor = valor;
    }

    public void mostrarInfo() {
        System.out.printf("%s | %s| %d%n", nombre, tipo, valor);
    }

    public CartaTipo getTipo() {
        return tipo;
    }

    public int getValor() {
        return valor;
    }
}

class Personaje {
    private String nombre;
    int vida;
    private List<Carta> mazo;
    private boolean aturdido;

    public Personaje(String nombre, int vida, List<Carta> mazo) {
        this.nombre = nombre;
        this.vida = vida;
        this.mazo = mazo;
        this.aturdido = false;
    }

    public String mostrarInfo() {
        return String.format("%s | Vida: %d", nombre, vida);
    }

    public boolean estaAturdido() {
        return aturdido;
    }

    public void aplicarEfecto(Carta carta, Personaje objetivo) {
        switch (carta.getTipo()) {
            case ATAQUE:
                if (!aturdido) {
                    objetivo.recibirAtaque(carta.getValor());
                }
                break;
            case CURA:
                if (!aturdido) {
                    this.recibirCura(carta.getValor());
                }
                break;
            case ATURDIR:
                objetivo.serAturdido();
                break;
        }
    }

    public void recibirAtaque(int cantidad) {
        vida -= cantidad;
        vida = Math.max(0, vida);
    }

    public void recibirCura(int cantidad) {
        vida += cantidad;
    }

    public void serAturdido() {
        aturdido = true;
    }

    public void removerAturdimiento() {
        aturdido = false;
    }

    public Carta elegirCarta() {
        Scanner scanner = new Scanner(System.in);
        Collections.shuffle(mazo);

        for (int i = 0; i < 2; i++) {
            System.out.print((i + 1) + ". ");
            mazo.get(i).mostrarInfo();
        }

        int opcion;
        do {
            System.out.print("Elige una carta (1-2): ");
            opcion = scanner.nextInt();
        } while (opcion < 1 || opcion > 2);

        return mazo.get(opcion - 1);
    }
}

public class Prueba {
    public static void main(String[] args) {
        Carta cartaAtaque = new Carta("Espada Afilada", CartaTipo.ATAQUE, 10);
        Carta cartaCura = new Carta("Poción Curativa", CartaTipo.CURA, 8);
        Carta cartaAturdir = new Carta("Aturdir", CartaTipo.ATURDIR, 0);

        List<Carta> mazoBasico = new ArrayList<>();
        mazoBasico.add(cartaAtaque);
        mazoBasico.add(cartaCura);
        mazoBasico.add(cartaAturdir);

        Personaje heroe = new Personaje("Héroe", 30, new ArrayList<>(mazoBasico));
        Personaje villano = new Personaje("Villano", 30, new ArrayList<>(mazoBasico));

        int turno = 1;
        while (heroe.vida > 0 && villano.vida > 0) {
            System.out.println("╔══════════════════════════════╗");
            System.out.println("║      ¡¡¡ Ronda " + turno + " !!!         ║");
            System.out.println("╚══════════════════════════════╝");
            jugarRonda(heroe, villano);
            turno++;
        }

        System.out.println("╔══════════════════════════════╗");
        if (heroe.vida <= 0) {
            System.out.println("║   ¡El Villano ha ganado!  ║");
        } else {
            System.out.println("║   ¡El Héroe ha ganado!   ║");
        }
        System.out.println("╚══════════════════════════════╝");
    }

    private static void jugarRonda(Personaje jugador1, Personaje jugador2) {
        System.out.println("╭────────────────────────────╮");
        System.out.println("│   Turno de " + jugador1.mostrarInfo() + "   │");
        System.out.println("╰────────────────────────────╯");
        Carta cartaElegida1 = jugador1.elegirCarta();
        jugador1.aplicarEfecto(cartaElegida1, jugador2);

        if (cartaElegida1.getTipo() != CartaTipo.ATURDIR) {
            jugador2.removerAturdimiento();

            System.out.println("╭────────────────────────────╮");
            System.out.println("│   Turno de " + jugador2.mostrarInfo() + "   │");
            System.out.println("╰────────────────────────────╯");
            Carta cartaElegida2 = jugador2.elegirCarta();
            jugador2.aplicarEfecto(cartaElegida2, jugador1);
        }
    }
}

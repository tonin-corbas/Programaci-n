import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Cartas ataque = new Cartas("Laceración", Cartas.cartaTipo.Ataque, 15);

        Cartas ataque2 = new Cartas("Ataque básico", Cartas.cartaTipo.Ataque, 10);

        Cartas Curasion = new Cartas("Poción Curativa", Cartas.cartaTipo.Curacion, 8);

        Cartas Curasion2 = new Cartas("Poción Curativa Suprema", Cartas.cartaTipo.Curacion, 13);

        Cartas cartaAturdir = new Cartas("Dolor de cabeza", Cartas.cartaTipo.Aturdir, 0);

        Cartas cartaAturdir2 = new Cartas("Cancer", Cartas.cartaTipo.Aturdir, 7);

        List<Cartas> mazoCartas = new ArrayList<>();
        mazoCartas.add(ataque);
        mazoCartas.add(ataque2);
        mazoCartas.add(Curasion);
        mazoCartas.add(Curasion2);
        mazoCartas.add(cartaAturdir);
        mazoCartas.add(cartaAturdir2);

        Personaje heroe = new Personaje("Dark Urge", 30, new ArrayList<>(mazoCartas));
        Personaje villano = new Personaje("Cerebro Anciano", 30, new ArrayList<>(mazoCartas));

        int ronda = 1;
        while (heroe.Vida > 0 && villano.Vida > 0) {
            System.out.println("╔══════════════════════════════╗");
            System.out.println("║      ¡¡¡ Ronda " + ronda + " !!!         ║");
            System.out.println("╚══════════════════════════════╝");
            inicioP(heroe, villano);
            ronda++;
        }

        System.out.println("╔══════════════════════════════╗");
        if (heroe.Vida <= 0) {
            System.out.println("║   ¡El Cerebro Anciano ha ganado!  ║");
        } else {
            System.out.println("║   ¡Dark Urge ha ganado!   ║");
        }
        System.out.println("╚══════════════════════════════╝");
    }

    private static void inicioP(Personaje jugador1, Personaje jugador2) {
        Random r = new Random();
        int valorDado = r.nextInt(2); // 0 o 1

        // Seleccionar aleatoriamente el jugador que comienza
        Personaje jugadorActual = (valorDado == 0) ? jugador1 : jugador2;
        Personaje jugadorSiguiente = (valorDado == 0) ? jugador2 : jugador1;

        System.out.println("╭─────────────────────────────╮");
        System.out.println("│Turno de " + jugadorActual.mostrarInfo() + "│");
        System.out.println("╰─────────────────────────────╯");

        jugadorActual.quitarAturdidito();
        Cartas cartaElegida = jugadorActual.elegir2Cartas();
        jugadorActual.aplicarEfect(cartaElegida, jugadorSiguiente);

        if (cartaElegida.getTipo() != null && cartaElegida.getTipo().equals(Cartas.cartaTipo.Aturdir)) {
            return;
        }

        jugadorSiguiente.quitarAturdidito();
        System.out.println("╭──────────────────────────────────────╮");
        System.out.println("│Turno de " + jugadorSiguiente.mostrarInfo() + "   │");
        System.out.println("╰──────────────────────────────────────╯");
        Cartas cartaElegidaSiguiente = jugadorSiguiente.elegir2Cartas();
        jugadorSiguiente.aplicarEfect(cartaElegidaSiguiente, jugadorActual);
        jugadorSiguiente.quitarAturdidito();

        if (cartaElegidaSiguiente.getTipo() != null && cartaElegidaSiguiente.getTipo().equals(Cartas.cartaTipo.Aturdir)) {
            return;
        }
    }
}
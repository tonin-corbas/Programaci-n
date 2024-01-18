import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random r = new Random();
        int valorDado = r.nextInt(2)+1; //Para que comience desde el 1 y no el 0
        int valorDad = valorDado %2;
        if (valorDad == 0) {
            System.out.println("Turno del jugador 1.");
        }
    }
}
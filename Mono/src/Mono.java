import java.util.Random;
import java.util.Scanner;
public class Mono {
    public static void main(String[] args) {
        Random r = new Random();
        Scanner scan = new Scanner(System.in);
        int valorDado = r.nextInt(2)+1;
        System.out.println(valorDado);
        int valorDad = valorDado %2;
         String[] insultos = {"1. Espero que tengas un barco para una rápida huida.","2. Si tu hermano es como tú, mejor casarse con un cerdo.","3. Mi ultima pelea acabo con mis manos llenas de sangre.","4. ¡He hablado con simios más educados que tu!"};
        String[] respuesta = {"1. ¿Por qué? ¿Acaso querías pedir uno prestado?","2. Me haces pensar que alguien ya lo ha hecho.","3. Espero que ya hayas aprendido a no tocarte la nariz.","4. Me alegra que asistieras a tu reunión familiar diaria."};
        int turno = 0;
        int e = r.nextInt(respuesta.length);
        int a = r.nextInt(insultos.length);
        int vict = 0;
        int derr = 0;
        while (turno < 4){
            if (valorDad == 0){
                System.out.println("Turno del usuario.");
                System.out.println("Elige un isnulto del 1 al 4 ");
                for (String insulto : insultos) {
                    System.out.println(insulto);
                }
                int elec = scan.nextInt();
                System.out.println( "Has elegido:" + insultos[elec-1]);
                System.out.println("Ha elegido:" + respuesta[e]);
                        if (e == elec-1){
                            System.out.println("Has perdido.");
                            derr++;
                        }else {
                            System.out.println("Has ganado.");
                            vict++;
                        }
                valorDad++;
                e = r.nextInt(respuesta.length);
            }else{
                System.out.println("Turno de la IA.");
                System.out.println("Ha elegido:" + insultos[a]);
                System.out.println("Turno del usuario. Elige un isnulto del 1 al 4");
                for (int n = 0; n < insultos.length; n++){
                    System.out.println(respuesta[n]);
                }
                int elec = scan.nextInt();
                System.out.println( "Has elegido:" + respuesta[elec-1]);
                if (elec-1 == a){
                    System.out.println("Has ganado.");
                    vict++;
                    }else {
                        System.out.println("Has perdido.");
                        derr++;
                    }
                valorDad = 0;
                a = r.nextInt(insultos.length);
                }
            turno++;
        }
        System.out.println("Has ganado un total de:" + vict + " veces. Y has perdido un total de:" + derr + " veces.");
    }
}
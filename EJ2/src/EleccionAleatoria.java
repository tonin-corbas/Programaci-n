import java.util.Random;
import java.util.Scanner;

public class EleccionAleatoria {

    public static void main(String[] args) {
        Random r = new Random();
        int num = r.nextInt(0,50);
        int cont = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Elige un número del 1 al 50.");
        int elec = scan.nextInt();
        while (cont < 4){
            if (elec == num){
                System.out.println("Has acertado");
            }else {
                System.out.println("has fallado");
                System.out.println("Vuelve a elegir otro número");
                elec = scan.nextInt();
            }
            cont++;
         }
    }
}
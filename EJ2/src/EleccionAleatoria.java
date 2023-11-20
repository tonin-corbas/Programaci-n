import java.util.Random;
import java.util.Scanner;

public class EleccionAleatoria {

    public static void main(String[] args) {
        Random r = new Random();
        int num = r.nextInt(0,50);
        int cont = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Elige un número del 0 al 50.");
        int elec = scan.nextInt();

        boolean fin = false;
        while (cont < 4 && !fin){
            if (elec == num) {
                System.out.println("Has acertado");
                fin = true;
            } else if (elec > num) {
                System.out.println("has fallado");
                System.out.println("Vuelve a elegir otro número menor a " + elec);
                elec = scan.nextInt();
            } else if (elec < num) {
                System.out.println("has fallado");
                System.out.println("Vuelve a elegir otro número mayor a " + elec);
                elec = scan.nextInt();
            }cont++;
        }
        if (fin == false){
            System.out.println("El número elegido era " + num);
        }
    }
}
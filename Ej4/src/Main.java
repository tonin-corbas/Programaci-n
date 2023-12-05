import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nombres = {"Toñin", "Pepito", "Tomás", "El NANO"};
        System.out.println("Escribe un nombre");
        String nombre = sc.nextLine();

        boolean encontrado = false;
        for (String n : nombres){
            if(n.equals(nombre)){
                encontrado = true;
            }
        }
        if(encontrado == true){
             System.out.println("Se ha encontrado el nombre de " + nombre);
        }else {
            System.out.println("No se ha encontrado el nombre de " + nombre);
        }
    }
}
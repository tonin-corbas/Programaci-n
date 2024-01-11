import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static List<clases> parejasTorneo;
    public static Integer MaxIdParejas = 1;
        public static void main(String[] args) {
            System.out.println("----------------------");
            System.out.println("NUEVO TORNEO DE PADEL");
            System.out.println("----------------------");

            parejasTorneo = new ArrayList<>();

            final Scanner scaner = new Scanner(System.in);

            System.out.println("que deseas hacer?");
            System.out.println("1- -crear equipo");
            System.out.println("2- -eliminar equipo");
            System.out.println("3- -pintar equipos");
            System.out.print(">> ");

            int funcion = scaner.nextInt();

            while(funcion != 0){
                switch(funcion){
                    case 1:
                        inscribirPareja();
                        break;
                    case 2:
                        eliminarPareja();
                        break;
                    case 3:
                        System.out.println(parejasTorneo.toString());
                }

                System.out.println("seleciona una funcion");
                funcion = scaner.nextInt();
            }

        }
        private static void inscribirPareja(){
            final Scanner scaner = new Scanner(System.in);
            //crear una pareja con su constructor
            Integer numeroEquipo = MaxIdParejas; // autogenerado
            System.out.println("nombre jugador 1");
            String nombre1 = scaner.nextLine();
            System.out.println("nombre jugador 2");
            String nombre2 = scaner.nextLine();
            System.out.println("telefono");
            String telefono = scaner.nextLine();
            clases pareja = new clases(numeroEquipo, nombre2, nombre1, telefono);

            parejasTorneo.add(pareja);
            MaxIdParejas++;

        }
        private static void eliminarPareja(){
            final Scanner scaner = new Scanner(System.in);

            System.out.println("el id del equipo que quieres eliminar");
            Integer id = scaner.nextInt();

            parejasTorneo.stream().filter(pareja -> id.equals(pareja.GetID())).findFirst();
            clases parejaAEliminar = null;

            for(clases pareja : parejasTorneo){
                if(Objects.equals(pareja.numeroEquipo, id)){
                    parejaAEliminar = pareja;
                }
            }
            parejasTorneo.remove(parejaAEliminar);

        }
}
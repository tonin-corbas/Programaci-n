import java.util.Scanner;
public class clases {
    Integer numeroEquipo;
    private String nombre1;
    private String telefono;
    private String nombre2;

    //constructor//
    public clases(Integer numeroEquipo,String nombre2, String nombre1, String telefono){
        this.numeroEquipo = numeroEquipo;
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.telefono = telefono;
    }
    public void pintarInfo(){
        System.out.println(this.numeroEquipo);
    }
    public void pareja(){
        final Scanner scaner = new Scanner(System.in);
    }
    //geters
    public Integer GetID(){
        return numeroEquipo;
    }
}

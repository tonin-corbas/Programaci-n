public class ej1 {
    public static String superpoder;
    public Boolean rico;
    public static String nombre;
    public int poder;
    public int ranking;
    public String color;
    public static void main(String[] args){
       superpoder = "Volar";
        nombre = "Spiderman";
       String nomX = getNomComplet();
       nomX = nomX + " super";
       System.out.println(nomX);

    }

    public static String getNomComplet() {
        return nombre + " apellido";
    }


}

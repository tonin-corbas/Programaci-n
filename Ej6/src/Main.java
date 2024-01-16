import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> listaDias = new ArrayList<String>();
        listaDias.add("Lunes");
        listaDias.add("Martes");
        listaDias.add("Miercoles");
        listaDias.add("Jueves");
        listaDias.add("Viernes");
        listaDias.add("Sábado");
        listaDias.add("Domíngo");
        listaDias.set(4, "Juernes");
        ArrayList<String> listaDos = new ArrayList<String>(listaDias);
        System.out.println(listaDias.get(3) + ", " + listaDias.get(4));
        String primer = listaDias.get(0);
        String ultimo = listaDias.get(listaDias.size()-1);
        System.out.println(primer+ ", " + ultimo);
        String eliminar = listaDias.remove(4);
        if (eliminar != null){
            System.out.println("Eliminacion correcta");
        }else {
            System.out.println("No se ha podido eliminar");
        }
        System.out.println(listaDias);

        for (String dia : listaDias){
            System.out.println(dia);
        }

        System.out.println(listaDias.contains("Lunes"));
    }
}
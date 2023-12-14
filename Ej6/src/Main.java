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

    }
}
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<Integer>();
        numeros.add(30);
        numeros.add(13);
        numeros.add(69);
        numeros.add(67);
        numeros.add(14);
        numeros.add(26);
        numeros.add(43);
        numeros.add(54);
        numeros.add(32);

        for (int i : numeros) {
            System.out.println(i);
        }
    }
}
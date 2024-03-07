import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class ProductosApp {
    public static void main(String[] args) throws IOException {
        String pathAbsoluto = "C:\\Users\\alumne-DAM\\Desktop\\productos.txt";

        HashMap<String, Producto> productos = new HashMap<>();

        leerProductos(pathAbsoluto, productos);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Introduce el código del producto (0 para salir): ");
            String codigo = scanner.nextLine();

            if (codigo.equals("0")) {
                break;
            }

            Producto producto = productos.get(codigo);
            if (producto != null) {
                System.out.println("El producto con el código " + producto.getCodigo() + " és: " + producto.getNombre());
                System.out.println("El precio del producto con el código " + producto.getCodigo() + " és: " + producto.getPrecio());
            } else {
                System.out.println("Producto no encontrado.");
            }
        }
        scanner.close();
    }

    private static void leerProductos(String pathAbsoluto, HashMap<String, Producto> productos) {
        try (BufferedReader br = new BufferedReader(new FileReader(pathAbsoluto))) {
            String linia;
            while ((linia = br.readLine()) != null) {
                String[] prods = linia.split(",");
                String codigo = prods[0];
                String nombre = prods[1];
                double precio = Double.parseDouble(prods[2]);
                productos.put(codigo, new Producto(Integer.parseInt(codigo), nombre, precio));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
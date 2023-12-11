import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        // Ejemplo de uso
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre del usuario: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el email del usuario: ");
        String email = scanner.nextLine();

        System.out.println("Ingrese la contraseña del usuario: ");
        String contraseña = scanner.nextLine();

        Usuario usuario = new Usuario(nombre, email, contraseña);

        // Mostrar información antes de encriptar
        System.out.println("Contraseña antes de encriptar: " + usuario.getContraseña());

        // Encriptar la contraseña
        usuario.encriptarContraseña();

        // Mostrar información después de encriptar
        System.out.println("Contraseña después de encriptar: " + usuario.getContraseña());

        usuario.desencriptarContraseña();

        //Mostrar la contraseña desencriptada
        System.out.println("Contraseña después de desencriptar: " + usuario.getContraseña());


        scanner.close();
    }
}

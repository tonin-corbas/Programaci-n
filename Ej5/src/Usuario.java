import java.util.Scanner;

public class Usuario {
    private String nombre;
    private String email;
    private String contraseña;
    private boolean esEncriptada;

    // Constructor con parámetros
    public Usuario(String nombre, String email, String contraseña) {
        this.nombre = nombre;
        this.email = email;
        this.contraseña = contraseña;
        this.esEncriptada = false; // Inicialmente la contraseña no está encriptada
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public boolean isEsEncriptada() {
        return esEncriptada;
    }

    // Setters
    public void setEmail(String email) {
        this.email = email;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
        this.esEncriptada = false; // Al cambiar la contraseña, marcamos como no encriptada
    }

    // Método para encriptar la contraseña
    public void encriptarContraseña() {
        if (!esEncriptada) {
            char[] caracteres = contraseña.toCharArray();
            for (int i = 0; i < caracteres.length; i++) {
                caracteres[i] = (char) (caracteres[i] + 5);
            }
            contraseña = new String(caracteres);
            esEncriptada = true;
        }
    }

    // Método para desencriptar la contraseña
    public void desencriptarContraseña() {
        if (esEncriptada) {
            char[] caracteres = contraseña.toCharArray();
            for (int i = 0; i < caracteres.length; i++) {
                caracteres[i] = (char) (caracteres[i] - 5);
            }
            contraseña = new String(caracteres);
            esEncriptada = false;
        }
    }
}

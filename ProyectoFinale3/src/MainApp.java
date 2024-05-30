import Controladores.MainController;

/**
 * Clase principal para iniciar la aplicación.
 */
public class MainApp {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> new MainController());
    }
}

package Controladores;

import Model.BBDD;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Controlador para la pantalla de agregar un nuevo personaje.
 */
public class AddCharacterController {
    private JFrame frame;
    private JPanel panel;
    private JTextField nombreField;
    private JTextField apellidoField;
    private JTextField hermandadField;
    private JTextField idJuegoField;
    private JButton addButton;

    /**
     * Constructor de AddCharacterController.
     * Configura la interfaz gráfica y el listener del botón de agregar.
     */
    public AddCharacterController() {
        frame = new JFrame("Agregar Personaje");
        panel = new JPanel(new GridLayout(5, 2));

        nombreField = new JTextField();
        apellidoField = new JTextField();
        hermandadField = new JTextField();
        idJuegoField = new JTextField();
        addButton = new JButton("Agregar");

        panel.add(new JLabel("Nombre:"));
        panel.add(nombreField);
        panel.add(new JLabel("Apellido:"));
        panel.add(apellidoField);
        panel.add(new JLabel("Hermandad:"));
        panel.add(hermandadField);
        panel.add(new JLabel("ID del Juego:"));
        panel.add(idJuegoField);
        panel.add(addButton);

        frame.add(panel);
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

        addButton.addActionListener(e -> addCharacter());
    }

    /**
     * Agrega un nuevo personaje a la base de datos.
     */
    private void addCharacter() {
        try (Connection connection = BBDD.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO personajes (Nombre, Apellido, Hermandad, id_juego) VALUES (?, ?, ?, ?)")) {

            statement.setString(1, nombreField.getText());
            statement.setString(2, apellidoField.getText());
            statement.setString(3, hermandadField.getText());
            statement.setInt(4, Integer.parseInt(idJuegoField.getText()));

            statement.executeUpdate();
            JOptionPane.showMessageDialog(frame, "Personaje agregado exitosamente!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error al agregar personaje.");
        }
    }
}

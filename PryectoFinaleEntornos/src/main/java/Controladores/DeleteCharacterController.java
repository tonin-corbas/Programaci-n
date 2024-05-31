package Controladores;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/**
 * Controlador para borrar un personaje.
 */
public class DeleteCharacterController {

    private JFrame frame;
    private JComboBox<String> characterComboBox;
    private MainController mainController;

    /**
     * Constructor que inicializa el controlador para borrar un personaje.
     */
    public DeleteCharacterController(MainController mainController) {
        this.mainController = mainController;
        initialize();
    }

    /**
     * Inicializa los componentes de la ventana para borrar un personaje.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblCharacter = new JLabel("Seleccione Personaje:");
        lblCharacter.setBounds(50, 50, 150, 25);
        frame.getContentPane().add(lblCharacter);

        characterComboBox = new JComboBox<>();
        characterComboBox.setBounds(200, 50, 200, 25);
        frame.getContentPane().add(characterComboBox);

        JButton btnDeleteCharacter = new JButton("Borrar");
        btnDeleteCharacter.setBounds(150, 100, 100, 25);
        frame.getContentPane().add(btnDeleteCharacter);
        btnDeleteCharacter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteCharacter();
            }
        });

        loadCharacters();

        frame.setVisible(true);
    }

    /**
     * Carga los personajes en el combo box.
     */
    private void loadCharacters() {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectofinale", "root", "");
             PreparedStatement pstmt = conn.prepareStatement("SELECT id, Nombre, Apellido FROM personajes");
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String character = rs.getString("Nombre") + " " + rs.getString("Apellido");
                characterComboBox.addItem(character);
                characterComboBox.setActionCommand(rs.getString("id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Borra el personaje seleccionado de la base de datos.
     */
    private void deleteCharacter() {
        int selectedCharacterIndex = characterComboBox.getSelectedIndex();
        if (selectedCharacterIndex == -1) {
            JOptionPane.showMessageDialog(frame, "Por favor, seleccione un personaje para borrar.");
            return;
        }

        String selectedCharacterId = characterComboBox.getActionCommand();

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectofinale", "root", "")) {
            conn.setAutoCommit(false);

            try (PreparedStatement deleteCalificacionesStmt = conn.prepareStatement("DELETE FROM calificacion WHERE id_personaje = ?");
                 PreparedStatement deletePersonajeStmt = conn.prepareStatement("DELETE FROM personajes WHERE id = ?")) {

                deleteCalificacionesStmt.setInt(1, Integer.parseInt(selectedCharacterId));
                deleteCalificacionesStmt.executeUpdate();

                deletePersonajeStmt.setInt(1, Integer.parseInt(selectedCharacterId));
                deletePersonajeStmt.executeUpdate();

                conn.commit();

                JOptionPane.showMessageDialog(frame, "Personaje borrado exitosamente.");
                mainController.refreshCharacterList();
                frame.dispose();

            } catch (SQLException e) {
                conn.rollback();
                e.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Error al borrar el personaje.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

package Controladores;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Controlador para añadir un nuevo personaje.
 */
public class AddCharacterController {

    private JFrame frame;
    private JTextField nameField;
    private JTextField surnameField;
    private JTextField brotherhoodField;
    private JComboBox<String> gameComboBox;
    private MainController mainController;

    /**
     * Constructor que inicializa el controlador para añadir un nuevo personaje.
     */
    public AddCharacterController(MainController mainController) {
        this.mainController = mainController;
        initialize();
    }

    /**
     * Inicializa los componentes de la ventana para añadir un nuevo personaje.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblName = new JLabel("Nombre:");
        lblName.setBounds(50, 50, 100, 25);
        frame.getContentPane().add(lblName);

        nameField = new JTextField();
        nameField.setBounds(150, 50, 200, 25);
        frame.getContentPane().add(nameField);

        JLabel lblSurname = new JLabel("Apellido:");
        lblSurname.setBounds(50, 90, 100, 25);
        frame.getContentPane().add(lblSurname);

        surnameField = new JTextField();
        surnameField.setBounds(150, 90, 200, 25);
        frame.getContentPane().add(surnameField);

        JLabel lblBrotherhood = new JLabel("Hermandad:");
        lblBrotherhood.setBounds(50, 130, 100, 25);
        frame.getContentPane().add(lblBrotherhood);

        brotherhoodField = new JTextField();
        brotherhoodField.setBounds(150, 130, 200, 25);
        frame.getContentPane().add(brotherhoodField);

        JLabel lblGame = new JLabel("Juego:");
        lblGame.setBounds(50, 170, 100, 25);
        frame.getContentPane().add(lblGame);

        gameComboBox = new JComboBox<>(new String[]{"Assassin's Creed", "Assassin's Creed II", "Assassin's Creed III", "Assassin's Creed IV: Black Flag", "Assassin's Creed Unity", "Assassin's Creed Origins", "Assassin's Creed Odyssey", "Assassin's Creed Mirage", "Assassin's Creed Shadows"});
        gameComboBox.setBounds(150, 170, 200, 25);
        frame.getContentPane().add(gameComboBox);

        JButton btnAddCharacter = new JButton("Añadir");
        btnAddCharacter.setBounds(150, 210, 100, 25);
        frame.getContentPane().add(btnAddCharacter);
        btnAddCharacter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addCharacter();
            }
        });

        frame.setVisible(true);
    }

    /**
     * Añade un nuevo personaje a la base de datos.
     */
    private void addCharacter() {
        String name = nameField.getText();
        String surname = surnameField.getText();
        String brotherhood = brotherhoodField.getText();
        String game = (String) gameComboBox.getSelectedItem();

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectofinale", "root", "")) {
            String query = "INSERT INTO personajes (Nombre, Apellido, Hermandad, id_juego) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setString(2, surname);
            pstmt.setString(3, brotherhood);
            pstmt.setInt(4, getGameId(game));
            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(frame, "Personaje añadido exitosamente.");

            // Actualizar la lista de personajes en el controlador principal
            mainController.refreshCharacterList();

            frame.dispose();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error al añadir el personaje.");
        }
    }

    /**
     * Obtiene el ID del juego basado en el nombre del juego.
     * @param gameName El nombre del juego.
     * @return El ID del juego.
     * @throws SQLException Si ocurre un error de base de datos.
     */
    private int getGameId(String gameName) throws SQLException {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectofinale", "root", "");
             PreparedStatement pstmt = conn.prepareStatement("SELECT id FROM juego_al_que_pertenece WHERE Nombre = ?")) {
            pstmt.setString(1, gameName);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            } else {
                throw new SQLException("Juego no encontrado.");
            }
        }
    }
}

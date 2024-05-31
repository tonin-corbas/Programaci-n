package Controladores;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/**
 * Controlador principal de la aplicación.
 */
public class MainController {

    private JFrame frame;
    private JTable characterTable;
    private DefaultTableModel characterTableModel;

    /**
     * Constructor que inicializa el controlador principal.
     */
    public MainController() {
        initialize();
        refreshCharacterList();
    }

    /**
     * Inicializa los componentes de la ventana principal.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton btnAddCharacter = new JButton("Añadir Personaje");
        btnAddCharacter.setBounds(50, 30, 150, 25);
        frame.getContentPane().add(btnAddCharacter);
        btnAddCharacter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addCharacter();
            }
        });

        JButton btnViewGames = new JButton("Ver Juegos y Épocas");
        btnViewGames.setBounds(220, 30, 150, 25);
        frame.getContentPane().add(btnViewGames);
        btnViewGames.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viewGames();
            }
        });

        JButton btnViewTop10 = new JButton("Ver Top 10 Personajes");
        btnViewTop10.setBounds(390, 30, 150, 25);
        frame.getContentPane().add(btnViewTop10);
        btnViewTop10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viewTop10();
            }
        });

        JButton btnDeleteCharacter = new JButton("Borrar Personaje");
        btnDeleteCharacter.setBounds(50, 70, 150, 25);
        frame.getContentPane().add(btnDeleteCharacter);
        btnDeleteCharacter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteCharacter();
            }
        });

        characterTableModel = new DefaultTableModel();
        characterTableModel.setColumnIdentifiers(new String[]{"Nombre", "Apellido", "Hermandad", "Juego"});
        characterTable = new JTable(characterTableModel);
        JScrollPane scrollPane = new JScrollPane(characterTable);
        scrollPane.setBounds(50, 110, 500, 200);
        frame.getContentPane().add(scrollPane);

        frame.setVisible(true);
    }

    /**
     * Abre la ventana para añadir un nuevo personaje.
     */
    private void addCharacter() {
        new AddCharacterController(this);
    }

    /**
     * Abre la ventana para ver los juegos y épocas.
     */
    private void viewGames() {
        new GameDetailsController();
    }

    /**
     * Abre la ventana para ver el top 10 de personajes y filtrarlo de manera ascendente o descendente.
     */
    private void viewTop10() {
        new Top10Controller();
    }

    /**
     * Abre la ventana para borrar un personaje.
     */
    private void deleteCharacter() {
        new DeleteCharacterController(this);
    }


    /**
     * Refresca la lista de personajes en la ventana principal.
     */
    public void refreshCharacterList() {
        characterTableModel.setRowCount(0); // Limpiar la tabla

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectofinale", "root", "");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT p.Nombre, p.Apellido, p.Hermandad, j.Nombre AS Juego FROM personajes p JOIN juego_al_que_pertenece j ON p.id_juego = j.id")) {

            while (rs.next()) {
                characterTableModel.addRow(new Object[]{
                        rs.getString("Nombre"),
                        rs.getString("Apellido"),
                        rs.getString("Hermandad"),
                        rs.getString("Juego")
                });
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

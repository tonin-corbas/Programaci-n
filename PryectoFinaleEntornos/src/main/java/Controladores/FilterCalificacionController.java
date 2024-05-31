package Controladores;

import Model.BBDD;
import Model.Calificacion;
import Model.Character;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Controlador para filtrar las calificaciones.
 */
public class FilterCalificacionController {
    private JFrame frame;
    private JPanel panel;
    private JTable table;
    private JButton ascButton;
    private JButton descButton;

    public FilterCalificacionController() {
        frame = new JFrame("Filtrar Calificaciones");
        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        ascButton = new JButton("Orden Ascendente");
        descButton = new JButton("Orden Descendente");

        ascButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTable("ASC");
            }
        });

        descButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTable("DESC");
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));
        buttonPanel.add(ascButton);
        buttonPanel.add(descButton);

        panel.add(buttonPanel, BorderLayout.NORTH);

        frame.add(panel);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

        updateTable("ASC");
    }

    private void updateTable(String order) {
        if (table != null) {
            panel.remove(table);
        }

        String[] columnNames = {"Nombre", "Apellido", "Hermandad", "Puntuación"};
        List<Calificacion> ratings = getCalificacion(order);
        String[][] data = new String[ratings.size()][4];

        for (int i = 0; i < ratings.size(); i++) {
            Character character = getCharacterById(ratings.get(i).getIdPersonaje());
            data[i][0] = character.getNombre();
            data[i][1] = character.getApellido();
            data[i][2] = character.getHermandad();
            data[i][3] = String.valueOf(ratings.get(i).getPuntuacion());
        }

        table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        panel.add(scrollPane, BorderLayout.CENTER);
        panel.revalidate();
        panel.repaint();
    }

    private List<Calificacion> getCalificacion(String order) {
        List<Calificacion> ratings = new ArrayList<>();
        try (Connection connection = BBDD.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM calificacion ORDER BY Puntuacion " + order)) {

            while (resultSet.next()) {
                ratings.add(new Calificacion(
                        resultSet.getInt("id_personaje"),
                        resultSet.getDouble("Puntuacion")

                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ratings;
    }

    private Character getCharacterById(int id) {
        Character character = null;
        try (Connection connection = BBDD.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM personajes WHERE id = " + id)) {

            if (resultSet.next()) {
                character = new Character(
                        resultSet.getInt("id"),
                        resultSet.getString("Nombre"),
                        resultSet.getString("Apellido"),
                        resultSet.getString("Hermandad"),
                        resultSet.getInt("id_juego")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return character;
    }
}

package Controladores;

import Model.BBDD;
import Model.Calificacion;
import Model.Character;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Controlador para la pantalla de visualización del top 10 de personajes.
 */
public class Top10Controller {
    private JFrame frame;
    private JPanel panel;
    private JTable table;

    public Top10Controller() {
        frame = new JFrame("Top 10 de Personajes");
        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        String[] columnNames = {"Nombre", "Apellido", "Hermandad", "Puntuación"};
        List<Calificacion> topRatings = getTopRatings();
        String[][] data = new String[topRatings.size()][4];

        for (int i = 0; i < topRatings.size(); i++) {
            Character character = getCharacterById(topRatings.get(i).getIdPersonaje());
            data[i][0] = character.getNombre();
            data[i][1] = character.getApellido();
            data[i][2] = character.getHermandad();
            data[i][3] = String.valueOf(topRatings.get(i).getPuntuacion());
        }

        table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        panel.add(scrollPane, BorderLayout.CENTER);

        frame.add(panel);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    private List<Calificacion> getTopRatings() {
        List<Calificacion> ratings = new ArrayList<>();
        try (Connection connection = BBDD.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM calificacion ORDER BY Puntuacion DESC LIMIT 10")) {

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

package Controladores;

import Model.BBDD;
import Model.Juego;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Controlador para la pantalla de visualización de juegos y sus épocas.
 */
public class GameDetailsController {
    private JFrame frame;
    private JPanel panel;
    private JTable table;

    /**
     * Constructor de GameDetailsController.
     * Configura la interfaz gráfica y carga los datos de los juegos.
     */
    public GameDetailsController() {
        frame = new JFrame("Detalles de los Juegos");
        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        String[] columnNames = {"Nombre", "Año", "Sede", "Época"};
        List<Juego> juegos = getJuegos();
        String[][] data = new String[juegos.size()][4];

        for (int i = 0; i < juegos.size(); i++) {
            data[i][0] = juegos.get(i).getNombre();
            data[i][1] = juegos.get(i).getAnio();
            data[i][2] = juegos.get(i).getSede();
            data[i][3] = juegos.get(i).getEpoca();
        }

        table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        panel.add(scrollPane, BorderLayout.CENTER);

        frame.add(panel);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    /**
     * Obtiene la lista de juegos desde la base de datos.
     *
     * @return Lista de juegos.
     */
    private List<Juego> getJuegos() {
        List<Juego> juegos = new ArrayList<>();
        try (Connection connection = BBDD.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT j.id, j.Nombre, j.Año, j.sede, e.Epoca " +
                     "FROM juego_al_que_pertenece j " +
                     "JOIN epoca_del_personaje e ON j.id_epoca = e.id")) {

            while (resultSet.next()) {
                juegos.add(new Juego(
                        resultSet.getInt("id"),
                        resultSet.getString("Nombre"),
                        resultSet.getString("Año"),
                        resultSet.getString("sede"),
                        resultSet.getString("Epoca")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return juegos;
    }
}

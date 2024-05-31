package Controladores;

import Model.BBDD;
import Model.Era;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Controlador para ver las épocas individualmente.
 */
public class EraDetailsController {
    private JFrame frame;
    private JPanel panel;
    private JTable table;

    public EraDetailsController() {
        frame = new JFrame("Detalles de las Épocas");
        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        String[] columnNames = {"ID", "Época"};
        List<Era> eras = getEras();
        String[][] data = new String[eras.size()][2];

        for (int i = 0; i < eras.size(); i++) {
            data[i][0] = String.valueOf(eras.get(i).getId());
            data[i][1] = eras.get(i).getEpoca();
        }

        table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        panel.add(scrollPane, BorderLayout.CENTER);

        frame.add(panel);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    private List<Era> getEras() {
        List<Era> eras = new ArrayList<>();
        try (Connection connection = BBDD.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM epoca_del_personaje")) {

            while (resultSet.next()) {
                eras.add(new Era(
                        resultSet.getInt("id"),
                        resultSet.getString("Epoca")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return eras;
    }
}

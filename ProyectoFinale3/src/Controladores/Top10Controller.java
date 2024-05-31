package Controladores;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Controlador para ver y filtrar el top 10 de personajes.
 */
public class Top10Controller {

    private JFrame frame;
    private JTable table;
    private JComboBox<String> comboBox;

    /**
     * Constructor que inicializa el controlador para ver el top 10 de personajes.
     */
    public Top10Controller() {
        initialize();
    }

    /**
     * Inicializa los componentes de la ventana del top 10 de personajes.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        String[] columnNames = {"Nombre", "Apellido", "Puntuación"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 50, 500, 200);
        frame.getContentPane().add(scrollPane);

        comboBox = new JComboBox<>(new String[]{"Ascendente", "Descendente"});
        comboBox.setBounds(50, 10, 150, 25);
        frame.getContentPane().add(comboBox);
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                filterTop10();
            }
        });

        frame.setVisible(true);
        loadTop10("Ascendente");
    }

    /**
     * Carga los datos del top 10 de personajes en la tabla.
     * @param order El orden en que se deben mostrar los personajes (Ascendente o Descendente).
     */
    private void loadTop10(String order) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectofinale", "root", "");
             Statement stmt = conn.createStatement()) {

            String query = "SELECT p.Nombre, p.Apellido, c.Puntuacion " +
                    "FROM personajes p " +
                    "JOIN calificacion c ON p.id = c.id_personaje " +
                    "ORDER BY c.Puntuacion " + (order.equals("Ascendente") ? "ASC" : "DESC") + " LIMIT 10";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("Nombre"), rs.getString("Apellido"), rs.getDouble("Puntuacion")});
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Aplica el filtro para ordenar el top 10 de personajes.
     */
    private void filterTop10() {
        String order = (String) comboBox.getSelectedItem();
        loadTop10(order);
    }
}

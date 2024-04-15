import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/programacion2024";
        try {
            Connection myst = DriverManager.getConnection(url, "root", "");
            //Realizamos un SELECT de persona:
            PreparedStatement mystmt = myst.prepareStatement("select nombre from persona");
            ResultSet rs = mystmt.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println("Error de bbdd: " + e);
        } catch (Exception e) {
            System.out.println("Error desconocido: " + e);
        }
    }
}
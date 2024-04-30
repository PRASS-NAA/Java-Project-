import java.sql.*;

public class sqlconn {
    static final String DB_URL = "jdbc:mysql://localhost:3306/pets";
    static final String USER = "root";
    static final String PASS = "idk";
    static final String QUERY = "SELECT own_id,animal_id,cus_id,vacc FROM owner";

    public static void main(String[] args) {
        // Open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);) {
            // Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                System.out.print("ID: " + rs.getString("own_id"));
                System.out.print(", Age: " + rs.getString("animal_id"));
                System.out.print(", First: " + rs.getInt("cus_id"));
                System.out.println(", Last: " + rs.getString("vacc"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
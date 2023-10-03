import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private static Connection connection;

    public static Connection connect() {
        if (connection == null) {
            try {
                String url = "jdbc:sqlite:identifier.sqlite"; // Replace with your database file path
                connection = DriverManager.getConnection(url);
                System.out.println("Connected to the database.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}

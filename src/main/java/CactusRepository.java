import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CactusRepository {
    public static Cactus getCactusById(String cactusId) {
        Connection connection = DatabaseConnector.connect();
        String query = "SELECT * FROM cactus_inventory WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, cactusId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String id = resultSet.getString("id");
                String species = resultSet.getString("species");
                String genus = resultSet.getString("genus");
                String family = resultSet.getString("family");
                String subspecies = resultSet.getString("subspecies");
                String traits = resultSet.getString("traits");
                String sizeCm = resultSet.getString("size_cm");
                return new Cactus(id, species, genus, family, subspecies, traits, sizeCm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
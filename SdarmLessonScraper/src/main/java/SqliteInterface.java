import config.ConfigProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SqliteInterface {
    private final static String connectionString = ConfigProperties.INSTANCE.getDataBaseConnectionString();

    public static void executeStatement(String userStatement){
        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection(connectionString);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            statement.executeUpdate(userStatement);
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        finally
        {
            try
            {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

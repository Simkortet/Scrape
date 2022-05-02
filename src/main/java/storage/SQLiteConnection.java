package storage;

import config.ConfigProperties;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteConnection {

    // TODO: Implement general setup for H2 connection here and make it so that it can connect to a database etc.
    public static Connection connect(String connectionString) {
        Connection conn = null;
        try {
            // create a connection to the database
            conn = DriverManager.getConnection(connectionString);
            /*if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
            }*/
            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

}

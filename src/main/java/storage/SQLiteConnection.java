package storage;

import config.ConfigProperties;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class SQLiteConnection {
    private final String connectionString;
    protected Connection connection;


    public SQLiteConnection(String connectionString) {
        this.connectionString = connectionString;
        this.connection = connect(connectionString);
    }

    private Connection connect(String connectionString) {
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

    public abstract void createTables();

    public abstract void resetTables();

    public void close() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

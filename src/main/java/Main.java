import config.ConfigProperties;
import storage.SQLiteConnection;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {


    public static void main(String[] args) {
        System.out.println("Hello World!!!");

        Connection connection = SQLiteConnection.connect(ConfigProperties.INSTANCE.getConnectionString());

        //esbenMain();
        //simonMain();
    }


    private void esbenMain() {

    }

    private void simonMain() {

    }
}

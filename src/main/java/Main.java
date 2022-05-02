import config.ConfigProperties;
import housing.storage.HousingDataBaseConnection;
import storage.SQLiteConnection;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {


    public static void main(String[] args) {
        System.out.println("Hello World!!!");
        esbenMain();
        //simonMain();
    }


    private static void esbenMain() {
        SQLiteConnection connection = new HousingDataBaseConnection(ConfigProperties.INSTANCE.getHousingConnectionString());

        connection.close();
    }

    private static void simonMain() {

    }
}

package housing.storage;

import housing.records.House;
import storage.SQLiteConnection;

public class HousingDataBaseConnection extends SQLiteConnection {

    public HousingDataBaseConnection(String connectionString) {
        super(connectionString);
    }

    // TODO: implement specific methods in here i.e. insert statements for:
    // Houses
    // Prices
    public void insertHouse(House house) {
        throw new RuntimeException("Not implemented");
    }


    // Todo:
    // make createTablesMethod
    //
    @Override
    public void createTables() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void resetTables() {
        throw new RuntimeException("Not implemented");
    }
}

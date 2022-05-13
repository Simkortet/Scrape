package sdarm.db;

import storage.SQLiteConnection;

public class SdarmDataBaseConnection extends SQLiteConnection {

    public SdarmDataBaseConnection(String connectionString) {
        super(connectionString);
    }

    @Override
    public void createTables() {

    }

    @Override
    public void resetTables() {

    }

    @Override
    public void close() {
        super.close();
    }
}

import config.ConfigProperties;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!!!");

        String connectionString = ConfigProperties.INSTANCE.getConnectionString();
        System.out.println(connectionString);
    }
}

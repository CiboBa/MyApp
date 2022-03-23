package program.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String url = "jdbc:mysql://localhost:3306/app_database";
    private static final String username = "root";
    private static final String password = "0000";
    private static Connection connection;

    @SuppressWarnings("finally")
    public static Connection createNewDBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection successful: " + url);

        } catch (
                ClassNotFoundException e) {
            System.out.println("Cannot create: " + e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Cannot create: " + e.getMessage());
            e.printStackTrace();
        } finally {
            return connection;
        }
    }

}

package program.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Deprecated
public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/app_database";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "0000";
    private static Connection connection;

    @SuppressWarnings("finally")
    public static Connection createNewDBConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connection successful: " + URL);

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

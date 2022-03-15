package program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AppJDBC {

    public static void main(String[] args) {
        String url = "jdbc:sqlserver://BTN3472\\SQLEXPRESS;databaseName=AdventureWorks2019";
        String username = "BTN3472\\bartlomiej.ciborowsk";
        String password = "";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected");
        } catch (SQLException e) {
            System.out.println("Error: ");
            e.printStackTrace();
        }
    }
}

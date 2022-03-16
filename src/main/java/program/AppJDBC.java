package program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AppJDBC {

    public static void main(String[] args) {
        String url = "jdbc:sqlserver://;databaseName=AdventureWorks2019";//dodać adres serwera
        String username = "";
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

package program.database;

import java.sql.*;

public abstract class DAO {

    protected static final String DB_URL = "jdbc:mysql://localhost:3306/app_database";
    protected static final String DB_USERNAME = "root";
    protected static final String DB_PASSWORD = "0000";
    protected static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";

    protected Connection connection;

    protected Statement statement;

    protected String query;

    protected void executeQuery() {
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            statement = connection.createStatement();
            statement.executeQuery(query);

            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    protected void executeUpdate() {
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            statement = connection.createStatement();
            statement.executeUpdate(query);

            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

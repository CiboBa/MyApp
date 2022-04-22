package program.users;

import program.database.DAO;
import program.users.models.User;
import program.users.models.UserRole;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersDAO extends DAO {

    private final SqlUserParser sqlUserParser;

    public UsersDAO() {
        sqlUserParser = new SqlUserParser();
    }

    public void save(User user) {
        query = sqlUserParser.createSaveQuery(user);
        executeUpdate();
    }

    public void search(String username) {
        query = sqlUserParser.createSearchQuery(username);
        executeQuery();
    }

    public void update(String currentUsername, String newUsername, String newPassword) {
        query = sqlUserParser.createUpdateQuery(currentUsername, newUsername, newPassword);
        executeUpdate();
    }

    public void delete(String username) {
        query = sqlUserParser.createDeleteQuery(username);
        executeUpdate();
    }

    public boolean authenticate(User user) {
        query = sqlUserParser.createFindUserQuery(user.getUsername());
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String name = resultSet.getString("username");
                String password = resultSet.getString("user_password");
                if (name.equals(user.getUsername()) && password.equals(user.getPassword())) {
                    return true;
                }
            }

            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean authorize(User user) {
        query = sqlUserParser.createFindUserQuery(user.getUsername());
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                UserRole userRole = UserRole.valueOf(resultSet.getString("user_role"));
                if (userRole.equals(UserRole.ADMIN)) {
                    return true;
                }
            }
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean exists(String username) {
        query = sqlUserParser.createUserExistsQuery(username);
        int result = 0;
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                result = resultSet.getInt("isEmpty");
            }
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return result != 0;
    }

    public boolean hasOrders(String username) {
        query = sqlUserParser.createHasOrdersQuery(username);
        int result = 0;
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                result = resultSet.getInt("isEmpty");
            }
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return result != 0;
    }
}

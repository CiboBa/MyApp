package program.users;

import org.jetbrains.annotations.NotNull;
import program.users.models.User;

public class SqlUserParser {

    public String createSaveQuery(@NotNull User user) {
        return "INSERT INTO users\n" +
                "SELECT * FROM (SELECT null,'" + user.getUsername() + "', '" + user.getPassword() + "', 'STANDARD') AS temp\n" +
                "WHERE NOT EXISTS (\n" +
                "\tSELECT username FROM users WHERE username = '" + user.getUsername() + " ')\n" +
                "LIMIT 1;";
    }

    public String createSearchQuery(String username) {
        return "SELECT username FROM users WHERE username='" + username + "';";
    }

    public String createUpdateQuery(String currentUsername, String newUsername, String newPassword) {
        return "UPDATE users SET username = '" + newUsername + "', user_password = '" + newPassword + "'" +
                "WHERE username ='" + currentUsername + "';";
    }

    public String createDeleteQuery(String username) {
        return "DELETE FROM users WHERE username = '" + username + "';";
    }

    public String createFindUserQuery(String username) {
        return "SELECT username, user_password, user_role FROM users WHERE username='" + username + "';";
    }

    public String createUserExistsQuery(String username) {
        return "SELECT EXISTS (SELECT * FROM users WHERE username = '" + username + "') AS isEmpty;";
    }

    public String createHasOrdersQuery(String username) {
        return "SELECT EXISTS (SELECT u.user_id, o.order_id\n" +
                "FROM users u\n" +
                "JOIN orders o ON u.user_id=o.user_id\n" +
                "WHERE username = '" + username + "') AS isEmpty;";
    }
}

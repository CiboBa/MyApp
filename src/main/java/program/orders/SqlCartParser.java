package program.orders;

import program.database.SqlParser;

public class SqlCartParser implements SqlParser {

    public String createSaveQuery(int userId, int itemId) {
        return "INSERT INTO cart\n" +
                "VALUES (" + userId + ", " + itemId + ");";
    }

    public String createViewCartQuery(int userId) {
//        return "SELECT * FROM cart\n"+
        return "SELECT i.product, i.quantity, p.price, (i.quantity * p.price)\n" +
                "AS value\n" +
                "FROM cart c\n" +
                "JOIN users u ON u.user_id = c.user_id\n" +
                "JOIN items i ON c.item_id = i.item_id\n" +
                "JOIN products p ON p.product = i.product\n" +
                "WHERE c.user_id = " + userId + ";";
    }

    public String createDeleteQuery(int userId) {
        return "DELETE FROM cart WHERE user_id = " + userId + ";";
    }

    public String createGetUserIdQuery(String username) {
        return "SELECT user_id\n" +
                "FROM users\n" +
                "WHERE username = '" + username + "';";
    }

    public String createGetItemIdQuery(String product) {
        return "SELECT item_id\n" +
                "FROM items\n" +
                "WHERE product = '" + product + "';";
    }
}

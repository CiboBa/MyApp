package program.orders;

import program.database.SqlParser;

public class SqlOrderParser implements SqlParser {

    public String createSaveQuery(int userId) {
        return "INSERT INTO orders\n" +
                "VALUES (null, " + userId + ", 'PENDING');";
    }

    public String createGetUserIdQuery(String username) {
        return "SELECT user_id\n" +
                "FROM users\n" +
                "WHERE username = '" + username + "';";
    }

    public String createSaveFromCartQuery(int userId) {
        return "INSERT INTO orders (user_id, order_status)\n" +
                "SELECT user_id, 'PENDING' FROM cart WHERE user_id = " + userId + " LIMIT 1;";
    }

    public String createFindUserOrdersQuery(int userId) {
        return "SELECT order_id, order_status FROM orders WHERE user_id = " + userId + ";";
    }

    public String createGetOrderDetailsQuery(int orderId) {
        return "SELECT i.product, i.quantity, p.price\n" +
                "FROM orders o\n" +
                "JOIN items i ON o.order_id = i.order_id\n" +
                "JOIN products p ON i.product = p.product\n" +
                "WHERE o.order_id = " + orderId + ";";
    }

    public String createGetLastOrderIdQuery() {
        return "SELECT order_id\n" +
                "FROM orders\n" +
                "ORDER BY order_id DESC\n" +
                "LIMIT 1;";
    }

    public String createListOrdersQuery(int userId) {
        return "SELECT * FROM orders WHERE user_id = " + userId + ";";
    }

    public String createIsEmptyQuery(int userId) {
        return "SELECT EXISTS (SELECT * FROM orders WHERE user_id = " + userId + ") AS isEmpty;";
    }

    public String createOrderExistsQuery(int orderId) {
        return "SELECT EXISTS (SELECT * FROM orders WHERE order_id = " + orderId + ") AS isEmpty;";
    }

    //nie implementuję
    public String createDeleteOrderByIdQuery(int orderId) {
        return "DELETE FROM orders WHERE order_id = " + orderId + ";";
    }

    //nie implementuję
    public String createDeleteOrderIdQuery(int orderId) {
        return "UPDATE items SET order_id = null WHERE order_id = " + orderId + ";";
    }

    public String createChangeStatusPending(int orderId) {
        return "UPDATE orders SET order_status = 'PENDING' WHERE order_id = " + orderId + ";";
    }

    public String createCancelOrderQuery(int orderId) {
        return "UPDATE orders SET order_status = 'CANCELLED' WHERE order_id = " + orderId + ";";
    }

    public String createChangeStatusInProgress(int orderId) {
        return "UPDATE orders SET order_status = 'IN_PROGRESS' WHERE order_id = " + orderId + ";";
    }

    public String createChangeStatusReady(int orderId) {
        return "UPDATE orders SET order_status = 'READY' WHERE order_id = " + orderId + ";";
    }

    public String createChangeStatusShipped(int orderId) {
        return "UPDATE orders SET order_status = 'SHIPPED' WHERE order_id = " + orderId + ";";
    }
}

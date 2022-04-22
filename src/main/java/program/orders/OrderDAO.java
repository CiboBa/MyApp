package program.orders;

import program.database.DAO;
import program.orders.models.Item;
import program.orders.models.Order;
import program.products.models.Product;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static program.ui.InitialView.ITEM_DAO;

public class OrderDAO extends DAO {

    private final SqlOrderParser sqlOrderParser;

    public OrderDAO() {
        sqlOrderParser = new SqlOrderParser();
    }

    public void save(String usernameLogged, int itemId) {
        int userId = getUserId(usernameLogged);
        query = sqlOrderParser.createSaveQuery(userId);
        executeUpdate();

        int orderId = getLastOrderId();

        List<String> itemIds = new ArrayList<>();
        itemIds.add(String.valueOf(itemId));
        ITEM_DAO.update(orderId, itemIds);
    }

    public void saveFromCart(String usernameLogged) {
        int userId = getUserId(usernameLogged);
        query = sqlOrderParser.createSaveFromCartQuery(userId);
        executeUpdate();

        int orderId = getLastOrderId();

        List<String> itemIds = ITEM_DAO.getItemIdList();
        ITEM_DAO.update(orderId, itemIds);
    }

    public int getLastOrderId() {
        query = sqlOrderParser.createGetLastOrderIdQuery();
        int orderId = 0;

        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                orderId = resultSet.getInt("order_id");
            }
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return orderId;
    }

    public double getTotalPrice(int orderId) {
        query = sqlOrderParser.createGetOrderDetailsQuery(orderId);
        double sum = 0;

        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int quantity = resultSet.getInt("quantity");
                double price = resultSet.getDouble("price");
                double value = quantity * price;
                sum += value;
            }
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return sum;
    }

    public int getUserId(String usernameLogged) {
        query = sqlOrderParser.createGetUserIdQuery(usernameLogged);

        int id = 0;
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                id = resultSet.getInt("user_id");
            }
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public void listOrders(String usernameLogged) {
        int userId = getUserId(usernameLogged);

        query = sqlOrderParser.createListOrdersQuery(userId);
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            List<Order> orders = new ArrayList<>();

            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt("order_id"));
                order.setUserId(resultSet.getInt("user_id"));
                order.setOrderStatus(resultSet.getString("order_status"));
                orders.add(order);
            }
            for (Order o : orders) {
                System.out.println("");
                System.out.printf("%2d - %s", orders.indexOf(o) + 1, o.toString());
            }
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean hasOrders(String usernameLogged) {
        int userId = getUserId(usernameLogged);
        query = sqlOrderParser.createIsEmptyQuery(userId);
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

    public void showOrder(int orderId) {
        query = sqlOrderParser.createGetOrderDetailsQuery(orderId);
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            List<Item> items = new ArrayList<>();

            while (resultSet.next()) {
                Item item = new Item(new Product(), 0);

                item.product.setProductName(resultSet.getString("product"));
                item.product.setProductPrice(resultSet.getDouble("price"));
                item.setQuantity(resultSet.getInt("quantity"));

                items.add(item);
            }
            for (Item i : items) {
                System.out.println("");
                System.out.printf("%2d - %s", items.indexOf(i) + 1, i.toString());
            }
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean exists(int orderId) {
        query = sqlOrderParser.createOrderExistsQuery(orderId);
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

    public void cancelOrderById(int orderId) {
        query = sqlOrderParser.createCancelOrderQuery(orderId);
        executeUpdate();
//        //hard delete
//        query = sqlOrderParser.createDeleteOrderIdQuery(orderId);
//        executeUpdate();
//        query = sqlOrderParser.createDeleteOrderByIdQuery(orderId);
//        executeUpdate();
    }

    public void changeStatusPending(int orderId) {
        query = sqlOrderParser.createChangeStatusPending(orderId);
        executeUpdate();
    }

    public void changeStatusInProgress(int orderId) {
        query = sqlOrderParser.createChangeStatusInProgress(orderId);
        executeUpdate();
    }

    public void changeStatusReady(int orderId) {
        query = sqlOrderParser.createChangeStatusReady(orderId);
        executeUpdate();
    }

    public void changeStatusShipped(int orderId) {
        query = sqlOrderParser.createChangeStatusShipped(orderId);
        executeUpdate();
    }
}

package program.orders;

import program.database.DAO;
import program.orders.models.Item;
import program.products.models.Product;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDAO extends DAO {

    private final SqlCartParser sqlCartParser;

    public CartDAO() {
        sqlCartParser = new SqlCartParser();
    }

    public void save(String username, int itemId) {
        int userId = getUserId(username);
        query = sqlCartParser.createSaveQuery(userId, itemId);
        executeUpdate();
    }

    public void viewCart(String username) {
        int userId = getUserId(username);
        query = sqlCartParser.createViewCartQuery(userId);

        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            List<Item> cart = new ArrayList<>();
            double cartSum = 0;

            while (resultSet.next()) {
                Item item = new Item(new Product(), 0);

                item.product.setProductName(resultSet.getString("product"));
                item.product.setProductQuantity(resultSet.getInt("quantity"));
                item.product.setProductPrice(resultSet.getDouble("price"));
                item.setQuantity(resultSet.getInt("quantity"));

                cart.add(item);
            }

            for (Item i : cart) {
                System.out.println("");
                System.out.printf("%2d - %s", cart.indexOf(i) + 1, i.toString());
                cartSum += i.getQuantity() * i.product.getProductPrice();
            }
            System.out.println("\n\nTotal cart: " + cartSum);
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String usernameLogged) {
        int userId = getUserId(usernameLogged);
        query = sqlCartParser.createDeleteQuery(userId);
        executeUpdate();
    }

    protected int getUserId(String usernameLogged) {
        query = sqlCartParser.createGetUserIdQuery(usernameLogged);

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
}

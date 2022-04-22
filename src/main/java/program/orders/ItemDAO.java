package program.orders;

import program.database.DAO;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO extends DAO {


    private final SqlItemParser sqlItemParser;

    public ItemDAO() {
        sqlItemParser = new SqlItemParser();
    }

    public int save(String product, int qty) {
        query = sqlItemParser.createSaveQuery(product, qty);
        executeUpdate();

        return getItemId();
    }

    public int getItemId() {
        query = sqlItemParser.createGetItemIdQuery();
        int itemId = 0;
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                itemId = resultSet.getInt("item_id");
            }
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return itemId;
    }

    public List<String> getItemIdList() {
        query = sqlItemParser.createGetMultipleItemIdQuery();
        List<String> ids = new ArrayList<>();

        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String itemId = String.valueOf(resultSet.getInt("item_id"));
                ids.add(itemId);
            }
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return ids;
    }

    public void update(int orderId, List<String> itemIds) {
        query = sqlItemParser.createUpdateQuery(orderId, itemIds);
        executeUpdate();
    }
}

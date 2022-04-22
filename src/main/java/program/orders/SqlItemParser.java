package program.orders;

import program.database.SqlParser;

import java.util.List;

public class SqlItemParser implements SqlParser {

    String createSaveQuery(String product, int qty) {
        return "INSERT INTO items (product, quantity)\n" +
                "VALUES ('" + product + "', " + qty + ");";
    }

    String createGetItemIdQuery() {
        return "SELECT item_id\n" +
                "FROM items\n" +
                "ORDER BY item_id DESC\n" +
                "LIMIT 1;";
    }

    String createGetMultipleItemIdQuery() {
        return "SELECT item_id\n" +
                "FROM cart";
    }

    public String createUpdateQuery(int orderId, List<String> itemIds) {
        String ids;
        if (itemIds.size() > 1) {
            ids = String.join(",", itemIds);
        } else ids = itemIds.get(0);

        return "UPDATE items\n" +
                "SET order_id = " + orderId + "\n"+
                "WHERE item_id IN (" + ids + ");";
    }
}

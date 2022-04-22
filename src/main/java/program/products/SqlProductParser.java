package program.products;

import program.database.SqlParser;
import program.products.models.Product;

public class SqlProductParser implements SqlParser {

    public String createSaveQuery(Product product) {
        return "INSERT INTO products\n" +
                "SELECT * FROM (SELECT '" + product.getProductName() + "', '" + product.getProductQuantity() + "', '" + product.getProductPrice() + "', '" + product.getProductCategory() +
                "') AS temp\n" +
                "WHERE NOT EXISTS (\n" +
                "SELECT product FROM products WHERE product = '" + product.getProductName() + "')\n" +
                "LIMIT 1;";
    }

    public String createFindByNameQuery(String input) {
        return "SELECT * FROM products " +
                "WHERE product LIKE'%" + input + "%';";
    }

    public String createFindByCategoryQuery(String category) {
        return "SELECT * FROM products WHERE category='" + category + "';";
    }

    public String createUpdateQuery(String currentName, String name, int quantity, double price, String category) {
        return "UPDATE products SET product = '" + name + "', quantity = " + quantity + ", price = " + price + ", category = '" + category + "'" +
                "WHERE product ='" + currentName + "';";
    }

    public String createDeleteQuery(String name) {
        return "DELETE FROM products WHERE product = '" + name + "';";
    }


    public String createDeleteByIdQuery(String ids) {
        String idSet = ids.replace(" ", ",");
        return "DELETE col FROM products col JOIN(\n" +
                "SELECT col.*, ROW_NUMBER() OVER (ORDER BY product) AS seq_num\n" +
                "FROM products col\n" +
                ") col2\n" +
                "ON col2.product = col.product\n" +
                "WHERE col2.seq_num IN (" + idSet + ");";
    }

    public String createSelectAllQuery() {
        return "SELECT * FROM products";
    }

    public String createSelectProductQuery(String name) {
        return "SELECT product, quantity, price, category" +
                "FROM products " +
                "WHERE product LIKE'%" + name + "%';";
    }
}

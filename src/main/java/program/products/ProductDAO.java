package program.products;

import program.database.DAO;
import program.products.models.Product;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ProductDAO extends DAO {

    private final SqlProductParser sqlProductParser;

    public ProductDAO() {
        sqlProductParser = new SqlProductParser();
    }

    public void save(Product product) {
        query = sqlProductParser.createSaveQuery(product);
        executeUpdate();
    }

    public void findByName(String name) {
        query = sqlProductParser.createFindByNameQuery(name);
        printProductList();
    }

    public void findByCategory(String category) {
        query = sqlProductParser.createFindByCategoryQuery(category);
        printProductList();
    }

    private void printProductList() {
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            List<Product> products = new ArrayList<>();

            while (resultSet.next()) {
                Product product = new Product();

                product.setProductName(resultSet.getString("product"));
                product.setProductQuantity(resultSet.getInt("quantity"));
                product.setProductPrice(resultSet.getDouble("price"));
                product.setProductCategory(resultSet.getString("category").toUpperCase(Locale.ROOT));

                products.add(product);
            }

            for (Product p : products) {
                System.out.printf("%2d - %s", products.indexOf(p) + 1, p.toString());
            }

            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(String currentName, String name, int quantity, double price, String category) {
        query = sqlProductParser.createUpdateQuery(currentName, name, quantity, price, category);
        executeUpdate();
    }

    public void delete(String name) {
        query = sqlProductParser.createDeleteQuery(name);
        executeUpdate();
    }

    public void deleteMultiple(String ids) {
        query = sqlProductParser.createDeleteByIdQuery(ids);
        executeUpdate();
    }
//
//    public Product select(String name) {
//        query = sqlProductParser.createSelectProductQuery(name);
//        Product product = new Product();
//
//        try {
//            Class.forName(DB_DRIVER);
//            connection = DriverManager.getConnection(DB_URL);
//            statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(query);
//
//            while (resultSet.next()) {
//
//                product.setProductName(resultSet.getString("product"));
//                product.setProductQuantity(resultSet.getInt("quantity"));
//                product.setProductPrice(resultSet.getDouble("price"));
//                product.setProductCategory(resultSet.getString("category"));
//            }
//
//            statement.close();
//            connection.close();
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
//        return product;
//    }
}

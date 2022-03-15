package program.products;

import program.products.models.Product;

public interface ProductManager {

    void addProduct(Product newProduct);

    void updateProduct(Product product, String newName, int newQuantity, double newPrice, String newCategory);

    void findProductByCategory(String category);

    void findProductByName(String nameSubstring);

    boolean deleteProduct(Product product);

    boolean deleteProductById(String ids);

    boolean isPresent(Product product);

    Product selectProduct(String productName);

    Product selectProductById(int productId);
}

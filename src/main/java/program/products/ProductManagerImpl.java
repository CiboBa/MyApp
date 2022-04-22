package program.products;

import program.products.models.Product;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Deprecated
public class ProductManagerImpl implements ProductManager {

    public static final List<Product> products = new ArrayList<>();

    public ProductManagerImpl() {
        products.add(new Product("Banana", 1, 1.00, "FRUIT"));
        products.add(new Product("Apple", 5, 12.00, "FRUIT"));
        products.add(new Product("Pear", 3, 5.00, "FRUIT"));
        products.add(new Product("Carrot", 6, 54.00, "VEGETABLE"));
        products.add(new Product("Vodka", 10, 23.00, "DRINK"));
        products.add(new Product("Juice", 34, 67.00, "DRINK"));
        products.add(new Product("Cucumber", 6, 2.00, "VEGETABLE"));
        products.add(new Product("Water", 67, 56.60, "DRINK"));
        products.add(new Product("Tomato", 32, 134.00, "VEGETABLE"));
        products.add(new Product("Peach", 2, 1.00, "FRUIT"));
    }

    @Override
    public void addProduct(Product newProduct) {
        products.add(newProduct);
    }

    @Override
    public void updateProduct(Product product, String newName, int newQuantity, double newPrice, String newCategory) {
        product.setProductName(newName);
        product.setProductQuantity(newQuantity);
        product.setProductPrice(newPrice);
        product.setProductCategory(newCategory);
    }

    @Override
    public void findProductByCategory(String category) {
        AtomicInteger index = new AtomicInteger(0);
        Collection<Product> collection = products.stream()
                .filter(p -> p.getProductCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
        collection.forEach(i -> System.out.printf("%2d - %s", index.incrementAndGet(), i));
    }

    @Override
    public void findProductByName(String nameSubstring) {
        AtomicInteger index = new AtomicInteger(0);
        Collection<Product> collection = products.stream()
                .filter(p -> p.getProductName().toLowerCase(Locale.ROOT).contains(nameSubstring))
                .collect(Collectors.toList());
        collection.forEach(i -> System.out.printf("%2d - %s", index.incrementAndGet(), i));
    }

    public Product selectProduct(String productName) {
        return products.stream()
                .filter(p -> p.getProductName().equalsIgnoreCase(productName))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Product selectProductById(int productId) {
        return products.get(productId - 1);
    }


    @Override
    public boolean deleteProduct(Product product) {
        return products.remove(product);
    }

    @Override
    public boolean deleteProductById(String ids) {
        String[] numberInArray = ids.split(" ");

        for (String s : numberInArray) {
            int deleteId = Integer.parseInt(s);
            products.remove(deleteId);
        }
        return false;
    }

    @Override
    public boolean isPresent(Product product) {
        return products.stream()
                .anyMatch(p -> p.getProductName().equals(product.getProductName()));
    }
}

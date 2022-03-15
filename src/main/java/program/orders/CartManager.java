package program.orders;

import program.orders.models.Order;
import program.products.models.Product;

import java.util.List;

public interface CartManager {

    boolean deleteFromCart();

    Order copyCartAndEmpty(String username, Order order);

    void addToCartByName(Product selectProduct);

    void toString(List<Object> asList);

}

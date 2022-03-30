package program.orders.models;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    public List<Item> cartItems = new ArrayList<>();

    public Order copyCartAndEmpty(String username) {
        Order newOrder = new Order();
        newOrder.setId();
        newOrder.setUserName(username);
        newOrder.setOrderItems(cartItems);
        newOrder.setOrderStatusPending();
        emptyCart();
        System.out.println("New order created:\n" + newOrder);
        return newOrder;
    }

    private void emptyCart() {
        cartItems.clear();
    }
}

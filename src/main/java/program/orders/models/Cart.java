package program.orders.models;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    public List<Item> cartItems = new ArrayList<>();

    public Order copyCartAndEmpty(String username) {
        //zaimplementować kopiowanie produktów z Arraya 'cart' do setProductList;
        System.out.println("kopiujemy!!!!");
        Order newOrder = new Order();
        newOrder.setId();
        newOrder.setUserName(username);
        newOrder.setOrderItems(cartItems);
        emptyCart();
        System.out.println("Skopiowalim " + newOrder);
        for (Item i : cartItems) {
            System.out.println("W koszu nie ma nic " + i);
        }
        return newOrder;
    }

    private void emptyCart() {
        cartItems.clear();
    }
}

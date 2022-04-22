package program.users.models;

import program.orders.models.Order;

import java.util.ArrayList;
import java.util.List;

public class StandardUser extends User {

//    public Cart cart = new Cart();

    public List<Order> orders = new ArrayList<>();

    public StandardUser() {
    }

    public StandardUser(String username, String password) {
        super(username, password);
    }
}

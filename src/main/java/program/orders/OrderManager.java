package program.orders;

import program.orders.models.Item;
import program.orders.models.Order;

public interface OrderManager {

    Order createOrder();

    Order changeStatus(int orderNumber);

    void viewOrder();

    Order createNew(Item item, String username);

    void viewAll(String username);
}

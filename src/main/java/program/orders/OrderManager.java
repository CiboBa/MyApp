package program.orders;

import program.orders.models.Item;
import program.orders.models.Order;

public interface OrderManager {

    Order changeStatus(int orderNumber);

    void viewOrder();

    Order createNew(Item item, String username);

    boolean isEmpty();
}

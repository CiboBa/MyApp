package program.orders;

import program.orders.models.Order;

public interface OrdersManager {

    void addOrderToList(Order order);

    void viewOrderList(String userName);

    Order findOrderByName(String userName);

    Order findOrderById(int id);

    boolean deleteOrder(int orderId);
}

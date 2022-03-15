package program.orders;

import program.orders.models.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class OrdersManagerImpl implements OrdersManager {
//lista orderów przypisana do Usera
    public List<Order> orders = new ArrayList<>();

    public OrdersManagerImpl() {
//        orders.add(new Order(1001, UsersManagerImpl.user1.getUsername(), OrderManagerImpl.mockList));
    }

    @Override
    public void addOrderToList(Order order) {
        orders.add(order);
        System.out.println("dodano do listy");
    }

    @Override
    public void viewOrderList(String userName) {
        System.out.println(orders.stream()
                .filter(o -> o.getUserName().equals(userName))
                .collect(Collectors.toList()));
    }

    @Override
    public Order findOrderByName(String userName) {
        return orders.stream()
                .filter(o -> o.getUserName().equalsIgnoreCase(userName))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Order findOrderById(int id) {
        for (Order o : orders) {
            if (o.getId() == id) {
                return o;
            } else System.out.println("No such order");
        }
        return null;
    }

    @Override
    public boolean deleteOrder(int orderId) {
        for (Order o : orders) {
            if (o.getId() == orderId) {
                orders.remove(o);
                return true;
            }
        }
        return false;
    }


}

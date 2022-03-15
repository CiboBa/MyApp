package program.orders;

import program.orders.models.Item;
import program.orders.models.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderManagerImpl implements OrderManager {

    public static final List<program.products.models.Product> mockList = List.of(
            new program.products.models.Product("Banana", 1, 10.00, "FRUIT"),
            new program.products.models.Product("Milk", 2, 12.50, "DIARY"),
            new program.products.models.Product("Crisps", 5, 4.69, "ALIMENTARY")
    );

    public List<Item> items = new ArrayList<>();

    public OrderManagerImpl() {
//        new Order(1001, UsersManagerImpl.user1.getUsername(), mockList);
    }

    @Override
    public Order createOrder() {
//        Order order = new Order();
//        order.setId();
//        System.out.println("New order created");
        return null;
    }

    @Override
    public Order changeStatus(int orderNumber) {

        return null;
    }

    @Override
    public void viewOrder() {
        double orderPriceSum = 0;
        for (program.products.models.Product p : mockList) {
            double productPriceSum = p.getProductPrice() * p.getProductQuantity();
            orderPriceSum += productPriceSum;
            System.out.print(("\n" + (mockList.indexOf(p) + 1)) + ". " + p);
            System.out.printf(" Value: %.2f", productPriceSum);
        }
        System.out.println("\nTOTAL: " + orderPriceSum);
    }

    public Order createNew(Item item, String username) {
        items.add(item);
        Order newOrder = new Order();
        newOrder.setId();
        newOrder.setUserName(username);
        newOrder.setProductList(items);
        newOrder.setOrderStatusPending();
        return newOrder;
    }

    public void viewAll(String username){

    }
}

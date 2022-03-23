package program.orders;

import program.orders.models.Item;
import program.orders.models.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderManagerImpl implements OrderManager {

    public List<Item> items = new ArrayList<>();

    public OrderManagerImpl() {
    }

    @Override
    public Order changeStatus(int orderNumber) {

        return null;
    }

    @Override
    public void viewOrder() {
        double orderPriceSum = 0;
        for (Item i : items) {
            double productPriceSum = i.product.getProductPrice() * i.getQuantity();
            orderPriceSum += productPriceSum;
            System.out.print(("\n" + (items.indexOf(i) + 1)) + ". " + i);
        }
        double discount = 0;
        for (int i = 0; i < DiscountManager.getInstance().discountList.size(); i++) {
            discount += DiscountManager.getInstance().discountList.get(i).calculateDiscount(items);
        }
        System.out.printf("\nDiscounted: %.2f", discount);
        System.out.printf("\nTOTAL: %.2f", orderPriceSum - discount);
        System.out.println("\n\n\n");
        System.out.println();
    }

    @Override
    public Order createNew(program.orders.models.Item item, String username) {
        items.add(item);
        Order newOrder = new Order();
        newOrder.setId();
        newOrder.setUserName(username);
        newOrder.setOrderItems(items);
        newOrder.setOrderStatusPending();
        return newOrder;
    }

    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }
}

package program.orders.models;

import java.util.ArrayList;
import java.util.List;

public class Order {

    public int id;
    public String userName;
    public List<Item> orderItems = new ArrayList<>();
    public OrderStatus orderStatus;

    public Order() {
    }

    public Order(int id, String userName, List<Item> orderItems) {
        this.id = id;
        this.userName = userName;
        this.orderItems = new ArrayList<>(orderItems);
        this.setOrderStatusPending();

    }

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = id + 1;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Item> getOrderItems() {
        return orderItems;
    }

    public void setProductList(List<Item> listToCopy) {
        this.orderItems.addAll(listToCopy);
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatusPending() {
        this.orderStatus = OrderStatus.PENDING;
    }

    public void setOrderStatusInProgress() {
        this.orderStatus = OrderStatus.IN_PROGRESS;
    }

    public void setOrderStatusReady() {
        this.orderStatus = OrderStatus.READY;
    }

    public void setOrderStatusShipped() {
        this.orderStatus = OrderStatus.SHIPPED;
    }

    public void setOrderStatusCancelled() {
        this.orderStatus = OrderStatus.CANCELLED;
    }

    public double getOrderValue() {
        double orderValue = 0;
        for (Item item : orderItems) {
            double productValue = item.product.getProductPrice() * item.getQuantity();
            orderValue += productValue;
        }
        return orderValue;
    }

    @Override
    public String toString() {
        String str1 = String.format("Order: %2d ", id);
        String str2 = String.format("Status:  %-10s", orderStatus);
        String str3 = String.format("Total: %8.2f ", getOrderValue());
        return str1 + str2 + str3;

    }
}

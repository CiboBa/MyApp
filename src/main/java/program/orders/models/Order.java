package program.orders.models;

import program.orders.DiscountManager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Order {

    private static int count = 1;
    public int id;
    public String userName;
    public List<Item> orderItems = new ArrayList<>();
    public OrderStatus orderStatus;

    public Order() {
    }

    public Order(String userName, List<Item> orderItems) {
        setId();
        this.userName = userName;
        this.orderItems = new ArrayList<>(orderItems);
        this.orderStatus = OrderStatus.PENDING;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = count;
        count++;
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

    public void setOrderItems(List<Item> listToCopy) {
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

    public void showOrderSum() {
        double orderValue = getOrderValue();
        double discount = 0;
        for (Discount d : DiscountManager.getInstance().discountList) {
            discount += d.calculateDiscount(orderItems);
        }
        System.out.printf("\nDiscounted: %.2f", discount);
        System.out.printf("\nTOTAL: %.2f", orderValue - discount);
    }

    @Override
    public String toString() {
        String str1 = String.format("Order: %2d ", getId());
        String str2 = String.format("\nStatus:  %-10s", getOrderStatus());
        String str3 = String.format("\nTotal: %8.2f ", getOrderValue());
        return str1 + str2 + str3;

    }
}

package program.orders.models;

import com.thoughtworks.qdox.model.expression.Or;
import program.orders.DiscountManager;
import program.orders.OrderDAO;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private static int count = 1;
    public int id;
    public int userId;
    //    public String userName;
    public List<Item> orderItems = new ArrayList<>();
    public String orderStatus;
//    public OrderStatus orderStatus;

    public Order() {
    }

    public Order(int id, int userId, List<Item> orderItems, String status) {
//        setId();
        this.id = id;
        this.userId = userId;
//        this.userName = userName;
        this.orderItems = new ArrayList<>(orderItems);
        this.orderStatus = status;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Item> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<Item> listToCopy) {
        this.orderItems.addAll(listToCopy);
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public double getOrderValue() {
        OrderDAO orderDAO = new OrderDAO();
        return orderDAO.getTotalPrice(getId());
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
        String str1 = String.format("Order No: %2d ", getId());
        String str2 = String.format("| Status:  %-10s", getOrderStatus());
        String str3 = String.format("| Total: %8.2f ", getOrderValue());
        return str1 + str2 + str3;

    }
}

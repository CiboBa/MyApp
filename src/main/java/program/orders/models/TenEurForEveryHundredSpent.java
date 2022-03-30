package program.orders.models;

import java.util.List;

public class TenEurForEveryHundredSpent implements Discount {

    @Override
    public double calculateDiscount(List<Item> itemList) {
        double orderValue = 0;
        for (Item i : itemList) {
            orderValue += i.product.getProductPrice() * i.getQuantity();
        }
        double discount;
        if (orderValue < 100) {
            discount = 0;
        } else {
            discount = (orderValue - orderValue % 100) / 100 * 10;
        }
        return discount;
    }


    @Override
    public void viewDiscount() {
        System.out.println("10 euro for every 100 euro spent");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

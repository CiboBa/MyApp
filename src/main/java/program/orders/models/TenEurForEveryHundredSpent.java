package program.orders.models;

import program.products.models.Product;

import java.util.List;

public class TenEurForEveryHundredSpent implements Discount {

    @Override
    public double calculateDiscount(List<Item> itemList) {
        //nie działa!!!
        double orderValue = 0;
        for (Item i : itemList) {
            orderValue += i.product.getProductPrice() * i.getQuantity();
        }
        double discount = 0;
        if (orderValue % 100 == 0) {
            return discount * 10;
        } else {
            discount = (int) (orderValue / 100);
            return discount * 10;
        }
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

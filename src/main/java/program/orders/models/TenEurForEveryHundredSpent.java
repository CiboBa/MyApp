package program.orders.models;

import program.products.models.Product;

import java.util.List;

public class TenEurForEveryHundredSpent implements Discount {

    @Override
    public double calculateDiscount(List<Product> productsList) {
        double orderValue = 0;
        for (Product p : productsList) {
            orderValue += p.getProductPrice() * p.getProductQuantity();
        }
        double discount = orderValue / 100;
        return discount * 10;
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

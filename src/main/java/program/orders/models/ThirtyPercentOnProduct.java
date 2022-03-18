package program.orders.models;

import program.products.models.Product;

import java.util.List;
import java.util.Scanner;

public class ThirtyPercentOnProduct implements Discount {

    public String productName;

    public ThirtyPercentOnProduct() {
        System.out.println("Choose product to discount:");
        Scanner scanner = new Scanner(System.in);
        productName = scanner.nextLine();
    }

    @Override
    public double calculateDiscount(List<Item> itemList) {
        double discount = 0;
        for (Item i : itemList) {
            if (i.product.getProductName().equals(productName)) {
                discount = i.product.getProductPrice() * i.getQuantity() * 0.3;
            }
        }
        return discount;
    }

    @Override
    public void viewDiscount() {
        System.out.println("30% on " + productName);
    }

    @Override
    public String toString() {
        return "ThirtyPercentOnProduct{" +
                "productName='" + productName + '\'' +
                '}';
    }
}

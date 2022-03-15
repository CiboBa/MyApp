package program.orders.models;

import program.products.models.Product;

import java.util.List;
import java.util.Scanner;

public class FiftyPercentOnSecondItem implements Discount {

    public String productName;

    public FiftyPercentOnSecondItem() {
        System.out.println("Choose product to discount:");
        Scanner scanner = new Scanner(System.in);
        productName = scanner.nextLine();
    }

    @Override
    public double calculateDiscount(List<Product> productsList) {
        int count;
        double discount = 0;
        for (Product p : productsList) {
            if (p.getProductName().equals(productName)) {
                count = p.getProductQuantity();
                if (count >= 2) {
                    discount = p.getProductPrice() * 0.5;
                }
            }
        }
        return discount;
    }

    @Override
    public void viewDiscount() {
        System.out.println("50% on second item");
    }

    @Override
    public String toString() {
        return "FiftyPercentForSecondItem{" +
                "productName='" + productName + '\'' +
                '}';
    }
}

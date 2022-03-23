package program.orders.models;

import program.products.ProductManagerImpl;
import program.products.models.Product;

import java.util.List;
import java.util.Scanner;

public class FiftyPercentOnSecondItem implements Discount {

    public String productName;

    public FiftyPercentOnSecondItem() {
        System.out.println("Choose product to discount:");
        Scanner scanner = new Scanner(System.in);
        productName = scanner.nextLine();
        if (productName.isEmpty() || productName.isBlank()) {
            System.out.println("You must choose discounted product! Choose between:");
            for (Product p:ProductManagerImpl.products){
                System.out.println(p.getProductName());
            }
            productName = scanner.nextLine();
        }
    }

    @Override
    public double calculateDiscount(List<Item> itemList) {
        int quantity;
        double discount = 0;
        for (Item i : itemList) {
            if (i.product.getProductName().equals(productName)) {
                quantity = i.getQuantity();
                if (quantity % 2 >= 0) {
                    discount = i.product.getProductPrice() * 0.5 * (0.5 * quantity);
                } else
                    discount = i.product.getProductPrice() * 0.5 + (0.5 * (quantity - 1));
            }
        }
        return discount;
    }

    @Override
    public void viewDiscount() {
        System.out.println("50% on second item: " + productName);
    }

    @Override
    public String toString() {
        return "FiftyPercentForSecondItem{" +
                "productName='" + productName + '\'' +
                '}';
    }
}

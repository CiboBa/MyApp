package program.orders.models;

import program.products.models.Product;

import java.util.List;

public interface Discount {

    double calculateDiscount(List<Item> itemList);

    void viewDiscount();
}

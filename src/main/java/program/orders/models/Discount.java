package program.orders.models;

import program.products.models.Product;

import java.util.List;

public interface Discount {

    double calculateDiscount(List<Product> productsList);

    void viewDiscount();
}

package program.orders.models;

import program.products.models.Product;

public class Item {

    public Product product;
    public int quantity;

    public Item(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Item() {

    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        String str1 = String.format("%-10s", product.getProductName());
        String str2 = String.format("%6.2f", product.getProductPrice());
        String str3 = String.format("%6d", quantity);
        String str4 = String.format("%8.2f", (product.getProductPrice() * quantity));
        return str1 + str2 + str3 + str4;
    }
}

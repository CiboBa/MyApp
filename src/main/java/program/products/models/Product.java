package program.products.models;

public class Product {

    private String productName;
    private int productQuantity;
    private double productPrice;
    private String productCategory;

    public Product() {

    }

    public Product(String productName, int productQuantity, double productPrice, String productCategory) {
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
        this.productCategory = productCategory;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    @Override
    public String toString() {
        String str1 = String.format("%-10s", productName);
        String str2 = String.format("%2d ", productQuantity);
        String str3 = String.format("%6.2f ", productPrice);
        String str4 = String.format("%-10s", productCategory);
        return str1 + str2 + str3 + str4 + "\n";
    }
}

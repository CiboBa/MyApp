package program.ui;

import program.products.models.Product;
import program.ui.models.View;

import static program.ui.InitialView.*;

public class AddProductView implements View {

    @Override
    public void init() {
        System.out.print("\nAdd product:\nSet NAME: ");
        String productName = SCANNER.nextLine();
        System.out.print("Set QUANTITY: ");
        int quantity = Integer.parseInt(SCANNER.nextLine());
        System.out.print("Set PRICE: ");
        double price = Double.parseDouble(SCANNER.nextLine());
        System.out.print("Set CATEGORY: ");
        String category = SCANNER.nextLine();

        Product product = new Product(productName, quantity, price, category);

        PRODUCT_DAO.save(product);

        System.out.println(
                "Product added successfully: \n" +
                        "Name: " + product.getProductName() +
                        ", Qty: " + quantity +
                        ", Price: " + price +
                        ", Cat.: " + category);

        View manageProductsView = new ManageProductsView();
        manageProductsView.init();
    }
}

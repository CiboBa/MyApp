package program.ui;

import program.products.models.Product;
import program.ui.models.View;

import static program.ui.InitialView.PRODUCT_MANAGER;
import static program.ui.InitialView.SCANNER;
import static program.ui.SelectProductView.selectedProduct;

public class EditProductView implements View {

    @Override
    public void init() {

        System.out.print("Set NEW NAME: ");
        String newName = SCANNER.nextLine();
        System.out.print("Set NEW QUANTITY: ");
        int newQuantity = Integer.parseInt(SCANNER.nextLine());
        System.out.print("Set NEW PRICE: ");
        double newPrice = Double.parseDouble(SCANNER.nextLine());
        System.out.print("Set NEW CATEGORY: ");
        String newCategory = SCANNER.nextLine();

        PRODUCT_MANAGER.updateProduct(selectedProduct, newName, newQuantity, newPrice, newCategory);

        System.out.println("Product has been updated");
        View manageProductsView = new ManageProductsView();
        manageProductsView.init();
    }
}

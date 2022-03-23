package program.ui;

import program.products.models.Product;
import program.ui.models.View;

import static program.ui.InitialView.PRODUCT_MANAGER;
import static program.ui.InitialView.SCANNER;

public class SelectProductView implements View {

    public static Product selectedProduct;

    @Override
    public void init() {
        System.out.println("\nType product name to select or press ENTER to go back");

        String productName = SCANNER.nextLine();

        while (!productName.isEmpty()) {
            selectedProduct = PRODUCT_MANAGER.selectProduct(productName);

            View editOrDeleteProductView = new EditOrDeleteProductView();
            editOrDeleteProductView.init();
        }
        View manageProductsView = new ManageProductsView();
        manageProductsView.init();
    }
}

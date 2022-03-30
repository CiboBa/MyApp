package program.ui;

import program.ui.models.View;

import static program.ui.InitialView.PRODUCT_MANAGER;
import static program.ui.InitialView.SCANNER;
import static program.ui.SelectProductView.selectedProduct;

public class EditOrDeleteProductView implements View {

    @Override
    public void init() {
        System.out.println("1. Edit product");
        System.out.println("2. Delete product");
        System.out.println("0. Back");

        int option = Integer.parseInt(SCANNER.nextLine());
        View manageProductsView;

        switch (option) {
            case 1:
                View editProductView = new EditProductView();
                editProductView.init();
            case 2:
                PRODUCT_MANAGER.deleteProduct(selectedProduct);
                System.out.println("Product deleted successfully");
                manageProductsView = new ManageProductsView();
                manageProductsView.init();
            case 0:
                manageProductsView = new ManageProductsView();
                manageProductsView.init();
            default:
                System.out.println("It is NOT a VALID COMMAND");
        }
    }
}

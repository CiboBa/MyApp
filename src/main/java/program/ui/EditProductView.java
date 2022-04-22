package program.ui;

import program.ui.models.View;

import static program.ui.InitialView.PRODUCT_DAO;
import static program.ui.InitialView.SCANNER;

public class EditProductView implements View {

    @Override
    public void init() {

        System.out.print("Choose product name to update:");
        String selectedProduct = SCANNER.nextLine();
        System.out.print("Set NEW NAME: ");
        String newName = SCANNER.nextLine();
        System.out.print("Set NEW QUANTITY: ");
        int newQuantity = Integer.parseInt(SCANNER.nextLine());
        System.out.print("Set NEW PRICE: ");
        double newPrice = Double.parseDouble(SCANNER.nextLine());
        System.out.print("Set NEW CATEGORY: ");
        String newCategory = SCANNER.nextLine();

        PRODUCT_DAO.update(selectedProduct, newName, newQuantity, newPrice, newCategory);

        System.out.println("Product has been updated");
        View manageProductsView = new ManageProductsView();
        manageProductsView.init();
    }
}

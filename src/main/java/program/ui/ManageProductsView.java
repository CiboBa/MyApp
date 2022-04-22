package program.ui;

import program.ui.models.View;

import static program.ui.InitialView.SCANNER;

public class ManageProductsView implements View {
    @Override
    public void init() {

        System.out.println("\nManage products:");
        System.out.println("1. Add product");
        System.out.println("2. Search product by Name");
        System.out.println("3. Search product by Category");
        System.out.println("4. Edit product");
        System.out.println("5. Delete by ID");
        System.out.println("0. Back");

        int option = Integer.parseInt(SCANNER.nextLine());

        switch (option) {
            case 1:
                View addProductView = new AddProductView();
                addProductView.init();
            case 2:
                View searchProductByNameView = new SearchProductByNameView();
                searchProductByNameView.init();
                break;
            case 3:
                View searchProductByCategoryView = new SearchProductByCategoryView();
                searchProductByCategoryView.init();
                break;
            case 4:
                View editProduct = new EditProductView();
                editProduct.init();
            case 5:
                View deleteByIdView = new DeleteByIdView();
                deleteByIdView.init();
            case 0:
                View loginAdminView = new LoginAdminView();
                loginAdminView.init();
            default:
                System.out.println("It is NOT a VALID COMMAND");
        }
    }
}

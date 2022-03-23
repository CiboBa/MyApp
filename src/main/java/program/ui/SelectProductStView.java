package program.ui;

import program.products.models.Product;
import program.ui.models.View;

import static program.ui.InitialView.PRODUCT_MANAGER;
import static program.ui.InitialView.SCANNER;

public class SelectProductStView implements View {

    public static Product selectedProductSt;

    @Override
    public void init() {
        System.out.println("\nType product ID to select or press ENTER to go back");

        try {
            int productId = Integer.parseInt(SCANNER.nextLine());
            selectedProductSt = PRODUCT_MANAGER.selectProductById(productId);
            View addToCartOrBuy = new AddToCartOrBuy();
            addToCartOrBuy.init();
        } catch (NumberFormatException e) {
            View loginStandardView = new LoginStandardView();
            loginStandardView.init();
        }
    }
}

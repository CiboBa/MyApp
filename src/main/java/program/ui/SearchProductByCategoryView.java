package program.ui;

import program.ui.models.View;

import static program.ui.InitialView.PRODUCT_MANAGER;
import static program.ui.InitialView.SCANNER;

public class SearchProductByCategoryView implements View {

    @Override
    public void init() {
        System.out.println("List products from category: ");
        String category = SCANNER.nextLine();

        System.out.printf("%3s %-8s %3s %5s %-10s\n", "No.", "Name:", "Qty:", "Price:", "Category:");
        PRODUCT_MANAGER.findProductByCategory(category);

        View selectProductView = new SelectProductView();
        selectProductView.init();
    }
}

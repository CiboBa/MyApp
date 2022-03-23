package program.ui;

import program.ui.models.View;

import static program.ui.InitialView.PRODUCT_MANAGER;
import static program.ui.InitialView.SCANNER;

public class SearchProductByNameView implements View {

    @Override
    public void init() {
        System.out.println("List products containing: ");
        String nameSubstring = SCANNER.nextLine();

        System.out.printf("%3s %-8s %3s %5s %-10s\n", "No.", "Name:", "Qty:", "Price:", "Category:");
        PRODUCT_MANAGER.findProductByName(nameSubstring);

        View selectProductView = new SelectProductView();
        selectProductView.init();
    }
}

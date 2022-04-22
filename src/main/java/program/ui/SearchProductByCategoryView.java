package program.ui;

import program.ui.models.View;
import program.users.models.User;
import program.users.models.UserRole;

import static program.ui.InitialView.*;
import static program.ui.LoginView.usernameLogged;

public class SearchProductByCategoryView implements View {

    @Override
    public void init() {
        System.out.println("List products from category: ");
        String category = SCANNER.nextLine();

        System.out.printf("%3s %-8s %3s %5s %-10s\n", "No.", "Name:", "Qty:", "Price:", "Category:");
        PRODUCT_DAO.findByCategory(category);

        System.out.println("");

        if (authorized) {
            View manageProductsView = new ManageProductsView();
            manageProductsView.init();
        } else {
            View loginStandardView = new LoginStandardView();
            loginStandardView.init();
        }
    }
}

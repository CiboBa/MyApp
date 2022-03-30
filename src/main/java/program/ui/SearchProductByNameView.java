package program.ui;

import program.ui.models.View;
import program.users.models.UserRole;

import static program.ui.InitialView.*;
import static program.ui.LoginView.usernameLogged;

public class SearchProductByNameView implements View {

    @Override
    public void init() {
        System.out.println("List products containing: ");
        String nameSubstring = SCANNER.nextLine();

        System.out.printf("%3s %-8s %3s %5s %-10s\n", "No.", "Name:", "Qty:", "Price:", "Category:");
        PRODUCT_MANAGER.findProductByName(nameSubstring);

        if (USERS_MANAGER.findUser(usernameLogged).getRole().equals(UserRole.ADMIN)) {
            View selectProductView = new SelectProductView();
            selectProductView.init();
        } else {
            View selectProductStView = new SelectProductStView();
            selectProductStView.init();
        }
    }
}

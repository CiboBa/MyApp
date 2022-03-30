package program.ui;

import program.orders.models.Item;
import program.ui.models.View;
import program.users.models.StandardUser;

import static program.ui.InitialView.SCANNER;
import static program.ui.InitialView.USERS_MANAGER;
import static program.ui.LoginView.usernameLogged;

public class CartView implements View {

    @Override
    public void init() {
        System.out.println("Your cart:");
        StandardUser user = (StandardUser) USERS_MANAGER.findUser(usernameLogged);
        int id = 0;
        for (Item i : user.cart.cartItems) {
            System.out.println(++id + ". " + i);
        }
        System.out.println("--------------------------------------------");
        System.out.println("\n1. Add product by ID");
        System.out.println("2. Checkout cart");
        System.out.println("0. Back");
        int option = Integer.parseInt(SCANNER.nextLine());

        switch (option) {
            case 1:
                View selectProductStView = new SelectProductStView();
                selectProductStView.init();
            case 2:
                System.out.println("CHECKOUT!");
                //zaimplementować !!!
            case 0:
                View loginStandardView = new LoginStandardView();
                loginStandardView.init();
        }
    }
}

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
        for (Item i : user.cart.cartItems
        ) {
            System.out.println(++id + ". " + i);
        }
        System.out.println("--------------------------------------------");
        System.out.println("\n1. Add another by ID");
        System.out.println("0. Back");
        int option = Integer.parseInt(SCANNER.nextLine());

        switch (option) {
            case 1:
                View selectProductStView = new SelectProductStView();
                selectProductStView.init();
            case 0:
                View loginStandardView = new LoginStandardView();
                loginStandardView.init();
        }

//        System.out.println("1. Checkout");
//        System.out.println("0. Back");
//
//        int option = Integer.parseInt(SCANNER.nextLine());
//
//        switch (option) {
//            case 1:
//                checkoutCart();
//                break;
//            case 0:
//                afterLoginStandard();
//            default:
//                System.out.println("It is NOT a VALID COMMAND");
//        }
    }
}

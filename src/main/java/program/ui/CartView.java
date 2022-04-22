package program.ui;

import program.ui.models.View;

import static program.ui.InitialView.CART_DAO;
import static program.ui.InitialView.SCANNER;
import static program.ui.LoginView.usernameLogged;

public class CartView implements View {

    @Override
    public void init() {
        System.out.println("Your cart:");

        CART_DAO.viewCart(usernameLogged);

        System.out.println("---------------------------------");
        System.out.println("1. Checkout cart");
        System.out.println("2. Add another product");
        System.out.println("0. Back");
        int option = Integer.parseInt(SCANNER.nextLine());

        switch (option) {
            case 1:
                View checkOutView = new CheckOutView();
                checkOutView.init();
            case 2:
                View addToCartView = new AddToCartView();
                addToCartView.init();
            case 0:
                View loginStandardView = new LoginStandardView();
                loginStandardView.init();
        }
    }
}

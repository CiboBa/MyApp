package program.ui;

import program.ui.models.View;

import static program.ui.InitialView.*;
import static program.ui.LoginView.usernameLogged;

public class CheckOutView implements View {

    @Override
    public void init() {
        System.out.println("Are you sure to checkout?");
        System.out.println("1. YES");
        System.out.println("0. NO");
        int option = Integer.parseInt(SCANNER.nextLine());

        switch (option) {
            case 1:
                ORDER_DAO.saveFromCart(usernameLogged);
                CART_DAO.delete(usernameLogged);
            case 0:
                View cartView = new CartView();
                cartView.init();
        }
    }
}

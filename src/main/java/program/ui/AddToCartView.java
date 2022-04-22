package program.ui;

import program.ui.models.View;

import static program.ui.InitialView.*;
import static program.ui.LoginView.usernameLogged;

public class AddToCartView implements View {

    public void init(){
        System.out.println("What product would you like to order?");
        String product = SCANNER.nextLine();
        System.out.println("Quantity you'd like to order: ");
        int qty = Integer.parseInt(SCANNER.nextLine());

        int itemId = ITEM_DAO.save(product, qty);
        try {
            CART_DAO.save(usernameLogged, itemId);
        }catch (NullPointerException e){
            System.out.println("NULL");
        }
        View cartView = new CartView();
        cartView.init();
    }
}

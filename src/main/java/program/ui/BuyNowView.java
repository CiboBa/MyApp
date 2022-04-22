package program.ui;

import program.ui.models.View;

import static program.ui.InitialView.*;
import static program.ui.LoginView.usernameLogged;

public class BuyNowView implements View {

    @Override
    public void init() {
        System.out.println("What product would you like to order?");
        String product = SCANNER.nextLine();
        System.out.println("Type quantity you'd like to order: ");
        int qty = Integer.parseInt(SCANNER.nextLine());

        int itemId = ITEM_DAO.save(product, qty);
        try {
            ORDER_DAO.save(usernameLogged, itemId);
        }catch (NullPointerException e){
            System.out.println("NULL");
        }


        View orderView = new OrderView();
        orderView.init();
    }
}

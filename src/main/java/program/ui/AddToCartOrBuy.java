package program.ui;

import program.orders.models.Item;
import program.orders.models.Order;
import program.products.models.Product;
import program.ui.models.View;
import program.users.models.StandardUser;

import static program.ui.InitialView.*;
import static program.ui.LoginView.usernameLogged;
import static program.ui.SelectProductStView.selectedProductSt;

public class AddToCartOrBuy implements View {

    @Override
    public void init() {
        System.out.println("\n1. Add to cart");
        System.out.println("2. Buy now");
        System.out.println("0. Back");
        int option = Integer.parseInt(SCANNER.nextLine());

        switch (option) {
            case 1:
                addToCartByID(selectedProductSt);
            case 2:
                buyNow(selectedProductSt);
            case 0:
                View orderView = new OrderView();
                orderView.init();
        }
    }

    private void addToCartByID(Product product) {
        System.out.println("Type quantity you'd like to order: ");
        int qty = Integer.parseInt(SCANNER.nextLine());

        StandardUser user = (StandardUser) USERS_MANAGER.findUser(usernameLogged);
        user.cart.cartItems.add(new Item(product, qty));

        View cartView = new CartView();
        cartView.init();
    }

    private void buyNow(Product product) {
        System.out.println("Type quantity you'd like to order: ");
        int qty = Integer.parseInt(SCANNER.nextLine());

        StandardUser user = (StandardUser) USERS_MANAGER.findUser(usernameLogged);
        Item item = new Item(product, qty);
        Order order = ORDER_MANAGER.createNew(item, user.getUsername());

        user.orders.add(order);

        View loginStandardView = new LoginStandardView();
        loginStandardView.init();
    }
}

package program.ui;

import program.orders.models.Order;
import program.ui.models.View;
import program.users.models.StandardUser;

import static program.ui.InitialView.SCANNER;
import static program.ui.InitialView.USERS_MANAGER;
import static program.ui.LoginView.usernameLogged;

public class UserOrderHistory implements View {

    @Override
    public void init() {
        StandardUser user = (StandardUser) USERS_MANAGER.findUser(usernameLogged);
        for (Order order : user.orders
        ) {
            System.out.println(order);
        }

        System.out.println("1. View order");
        System.out.println("0. Back");
        int option = Integer.parseInt(SCANNER.nextLine());

        switch (option) {
            case 1:
                View orderView = new OrderView();
                orderView.init();
            case 0:
                View loginStandardView = new LoginStandardView();
                loginStandardView.init();
        }
    }
}

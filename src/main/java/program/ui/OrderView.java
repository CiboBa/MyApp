package program.ui;

import program.orders.models.Item;
import program.orders.models.Order;
import program.ui.models.View;
import program.users.models.StandardUser;

import static program.ui.InitialView.SCANNER;
import static program.ui.InitialView.USERS_MANAGER;
import static program.ui.LoginView.usernameLogged;

public class OrderView implements View {

    @Override
    public void init() {
        System.out.println("\nEnter order ID");
        int orderId = Integer.parseInt(SCANNER.nextLine());
        StandardUser user = (StandardUser) USERS_MANAGER.findUser(usernameLogged);
        Order viewedOrder = null;

        try {
            viewedOrder = user.orders.get(orderId - 1);
            int id = 0;
            System.out.println("\n" + viewedOrder);
            for (Item item : viewedOrder.getOrderItems()) {
                System.out.println(++id + " " + item);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("No such order!");
            View loginStandardView = new LoginStandardView();
            loginStandardView.init();
        }

        System.out.println("\n0. Back");
        System.out.println("1. Cancel order");
        int option = Integer.parseInt(SCANNER.nextLine());

        switch (option) {
            case 1:
                assert viewedOrder != null;
                cancelOrderById(viewedOrder);
                View userOrderHistory = new UserOrderHistory();
                userOrderHistory.init();
            case 0:
                View loginStandardView = new LoginStandardView();
                loginStandardView.init();
        }
    }

    private void cancelOrderById(Order viewedOrder) {
        viewedOrder.setOrderStatusCancelled();
        System.out.println("Order cancelled");
    }


}

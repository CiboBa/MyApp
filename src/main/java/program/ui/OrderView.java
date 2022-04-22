package program.ui;

import program.ui.models.View;

import static program.ui.InitialView.*;

public class OrderView implements View {

    @Override
    public void init() {

        System.out.println("\nEnter order ID:");
        int orderId = Integer.parseInt(SCANNER.nextLine());

        if (!ORDER_DAO.exists(orderId)) {
            System.out.println("No such order!");
            View loginStandardView = new LoginStandardView();
            loginStandardView.init();
        } else {
            ORDER_DAO.showOrder(orderId);
        }

        System.out.println("\n\n0. Back");
        System.out.println("1. Cancel order");
        int option = Integer.parseInt(SCANNER.nextLine());

        switch (option) {
            case 1:
                ORDER_DAO.cancelOrderById(orderId);
                View userOrderHistory = new UserOrderHistory();
                userOrderHistory.init();
            case 0:
                View loginStandardView = new LoginStandardView();
                loginStandardView.init();
        }
    }

//    private void listProducts(Order viewedOrder, int id) {
//        System.out.println("\nProduct List:");
//        for (Item item : viewedOrder.getOrderItems()) {
//            System.out.println(++id + " " + item);
//        }
//    }
//
//    private void showOrders(StandardUser user) {
//        System.out.println("============================");
//        for (Order o : user.orders) {
//            System.out.println(o.toString());
//            System.out.println("-----------------------------");
//        }
//    }
//
//    private void cancelOrderById(Order viewedOrder) {
//        viewedOrder.setOrderStatusCancelled();
//        System.out.println("Order cancelled");
//    }

}

package program.ui;

import program.ui.models.View;

import static program.ui.InitialView.ORDER_DAO;
import static program.ui.InitialView.SCANNER;


public class EditOrderStatusView implements View {

    @Override
    public void init() {

        System.out.println("Select order:");
        int orderId = Integer.parseInt(SCANNER.nextLine());

        ORDER_DAO.showOrder(orderId);

        System.out.println("\n\n1. Change status to: PENDING");
        System.out.println("2. Change status to: IN_PROGRESS");
        System.out.println("3. Change status to: READY");
        System.out.println("4. Change status to: SHIPPED");
        System.out.println("5. Cancel order");
        System.out.println("0. Back");

        int changeStatus = Integer.parseInt(SCANNER.nextLine());
        View userPreview = new UserPreview();

        switch (changeStatus) {
            case 1:
                ORDER_DAO.changeStatusPending(orderId);
                System.out.println("Order status has been changed!");
                userPreview.init();
            case 2:
                ORDER_DAO.changeStatusInProgress(orderId);
                System.out.println("Order status has been changed!");
                userPreview.init();
            case 3:
                ORDER_DAO.changeStatusReady(orderId);
                System.out.println("Order status has been changed!");
                userPreview.init();
            case 4:
                ORDER_DAO.changeStatusShipped(orderId);
                System.out.println("Order status has been changed!");
                userPreview.init();
            case 5:
                ORDER_DAO.cancelOrderById(orderId);
                System.out.println("Order cancelled!!");
                userPreview.init();
            case 0:
                break;
            default:
                System.out.println("It is NOT a VALID COMMAND");
        }
    }
}

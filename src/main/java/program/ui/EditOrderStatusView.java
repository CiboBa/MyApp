package program.ui;

import program.orders.models.Order;
import program.ui.models.View;
import program.users.models.StandardUser;

import static program.ui.FindOrderView.orderId;
import static program.ui.InitialView.SCANNER;
import static program.ui.InitialView.USERS_MANAGER;
import static program.ui.SearchUserView.searchedUsername;


public class EditOrderStatusView implements View {

    @Override
    public void init() {

        System.out.println("\n\n1. Change status to: PENDING");
        System.out.println("2. Change status to: IN_PROGRESS");
        System.out.println("3. Change status to: READY");
        System.out.println("4. Delete order");
        System.out.println("0. Back");

        StandardUser user = (StandardUser) USERS_MANAGER.findUser(searchedUsername);
        Order order = user.orders.get(orderId);

        int changeStatus = Integer.parseInt(SCANNER.nextLine());

        switch (changeStatus) {
            case 1:
                order.setOrderStatusPending();
            case 2:
                order.setOrderStatusInProgress();
            case 3:
                order.setOrderStatusReady();
            case 4:
                user.orders.remove(orderId);
            case 0:
                break;
            default:
                System.out.println("It is NOT a VALID COMMAND");
        }
    }
}

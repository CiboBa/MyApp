package program.ui;

import program.ui.models.View;
import program.users.models.StandardUser;

import static program.ui.InitialView.*;
import static program.ui.SearchUserView.searchedUsername;

public class FindOrderView implements View {

    public static int orderId;

    @Override
    public void init() {
        StandardUser user = (StandardUser) USERS_MANAGER.findUser(searchedUsername);
        if (user.orders.size() <= 0) {
            System.out.println("This user has no orders yet");
        } else if (user.orders.size() == 1) {
            System.out.println("This user has got only one order. Type '1' for preview");
        } else {
            System.out.println("Type order number to select: ");
            orderId = Integer.parseInt(SCANNER.nextLine()) - 1;
            View editOrderStatusView = new EditOrderStatusView();

            try {
                ORDER_MANAGER.viewOrder();
                editOrderStatusView.init();
            } catch (NumberFormatException e) {
                System.out.println("No such number");
                init();
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Number not assigned");
                init();
                if (orderId > user.orders.size() - 1) {
                    System.out.println("Choose number from 1 to " + user.orders.size());
                    init();
                }
            }
        }
    }
}

package program.ui;

import program.ui.models.View;

import static program.ui.InitialView.*;
import static program.ui.SearchUserView.searchedUsername;

public class UserPreview implements View {

    @Override
    public void init() {

        System.out.println("\n\n1. View user orders");
        System.out.println("2. Edit order status");
        System.out.println("3. Edit user");
        System.out.println("4. Delete user");
        System.out.println("0. Back\n");

        int option = Integer.parseInt(SCANNER.nextLine());

        switch (option) {
            case 1:
                try {
                    ORDER_DAO.listOrders(searchedUsername);
                    init();
                } catch (NullPointerException e) {
                    System.out.println("This user has no orders yet!");
                    break;
                }
            case 2:
                View editOrderStatusView = new EditOrderStatusView();
                editOrderStatusView.init();
                break;
            case 3:
                View editUserView = new EditUserView();
                editUserView.init();
                break;
            case 4:
                if (USERS_DAO.hasOrders(searchedUsername)) {
                    System.out.println("Cannot delete active user");
                } else {
                    USERS_DAO.delete(searchedUsername);
                    System.out.println("User deleted successfully");
                }
                View manageUsersView = new ManageUsersView();
                manageUsersView.init();
                break;
            case 0:
                View loginAdminView = new LoginAdminView();
                loginAdminView.init();
                break;
            default:
                System.out.println("It is NOT a VALID COMMAND");
        }
    }
}

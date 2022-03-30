package program.ui;

import program.orders.models.Order;
import program.ui.models.View;
import program.users.models.StandardUser;

import static program.ui.InitialView.SCANNER;
import static program.ui.InitialView.USERS_MANAGER;
import static program.ui.SearchUserView.searchedUsername;

public class UserPreview implements View {

    @Override
    public void init() {

        System.out.println("\n1. View user orders");
        System.out.println("2. Edit user");
        System.out.println("3. Delete user");
        System.out.println("0. Back\n");

        int option = Integer.parseInt(SCANNER.nextLine());

        switch (option) {
            case 1:
                try {
                    StandardUser user = (StandardUser) USERS_MANAGER.findUser(searchedUsername);
                    for (Order order : user.orders) {
                        System.out.println(order);
                    }
                    View findOrderView = new FindOrderView();
                    findOrderView.init();
                } catch (ClassCastException e) {
                    System.out.println("Admin must not have orders");
                }
                break;
            case 2:
                View editUserView = new EditUserView();
                editUserView.init();
            case 3:
                USERS_MANAGER.deleteUser(searchedUsername);
                System.out.println("User deleted successfully");
                View manageUsersView = new ManageUsersView();
                manageUsersView.init();
            case 0:
                View loginAdminView = new LoginAdminView();
                loginAdminView.init();
            default:
                System.out.println("It is NOT a VALID COMMAND");
        }
    }
}

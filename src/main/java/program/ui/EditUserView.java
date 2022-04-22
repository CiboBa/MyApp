package program.ui;

import program.ui.models.View;

import static program.ui.InitialView.*;
import static program.ui.SearchUserView.searchedUsername;


public class EditUserView implements View {

    @Override
    public void init() {
        System.out.println("Edit user:");
        System.out.println("Set NEW USERNAME: ");
        String newUsername = SCANNER.nextLine();
        System.out.println("Set NEW PASSWORD: ");
        String newPassword = SCANNER.nextLine();

        USERS_DAO.update(searchedUsername, newUsername, newPassword);
        System.out.println("User updated: " + newUsername);

        View manageUsersView = new ManageUsersView();
        manageUsersView.init();
    }
}

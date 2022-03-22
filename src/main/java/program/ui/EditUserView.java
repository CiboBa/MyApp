package program.ui;

import program.ui.models.View;

import static program.ui.InitialView.SCANNER;
import static program.ui.InitialView.USERS_MANAGER;
import static program.ui.SearchUserView.searchedUsername;


public class EditUserView implements View {

    @Override
    public void init() {
        System.out.print("\nEdit user:\nSet NEW USERNAME: ");
        String newUsername = SCANNER.nextLine();
        System.out.print("Set NEW PASSWORD: ");
        String newPassword = SCANNER.nextLine();

        USERS_MANAGER.updateUser(searchedUsername, newUsername, newPassword);
    }
}

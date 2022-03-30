package program.ui;

import program.ui.models.View;

import java.util.NoSuchElementException;

import static program.ui.InitialView.SCANNER;
import static program.ui.InitialView.USERS_MANAGER;

public class SearchUserView implements View {

    public static String searchedUsername;

    @Override
    public void init() {
        System.out.println("\nSearch user:");
        searchedUsername = SCANNER.nextLine();

        try {
            USERS_MANAGER.findUser(searchedUsername);
            System.out.println("User found: " + USERS_MANAGER.findUser(searchedUsername).getUsername());
            View userPreview = new UserPreview();
            userPreview.init();
        } catch (NoSuchElementException e) {
            System.out.println("User does not exist!");
            View manageUsersView = new ManageUsersView();
            manageUsersView.init();
        }
    }
}

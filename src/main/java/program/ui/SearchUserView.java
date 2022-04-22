package program.ui;

import program.ui.models.View;

import java.util.NoSuchElementException;

import static program.ui.InitialView.SCANNER;
import static program.ui.InitialView.USERS_DAO;

public class SearchUserView implements View {

    public static String searchedUsername;

    @Override
    public void init() {
        System.out.println("\nSearch user:");
        searchedUsername = SCANNER.nextLine();

        if (!USERS_DAO.exists(searchedUsername)) {
            System.out.println("User does not exist!");
            View manageUsersView = new ManageUsersView();
            manageUsersView.init();
        } else {
            USERS_DAO.search(searchedUsername);
            System.out.println("User found- " + searchedUsername);
            View userPreview = new UserPreview();
            userPreview.init();
        }
    }
}

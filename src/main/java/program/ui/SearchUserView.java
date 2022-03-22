package program.ui;

import program.ui.models.View;

import static program.ui.InitialView.SCANNER;

public class SearchUserView implements View {

    public static String searchedUsername;

    @Override
    public void init() {
        System.out.println("\nSearch user:");
        searchedUsername = SCANNER.nextLine();

        UserPreview userPreview = new UserPreview();
        userPreview.init();
    }
}

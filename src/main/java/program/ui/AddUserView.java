package program.ui;

import program.ui.models.View;

import static program.ui.InitialView.SCANNER;
import static program.ui.InitialView.USERS_MANAGER;

public class AddUserView implements View {

    @Override
    public void init() {
        System.out.print("\nAdd user:\nSet USERNAME: ");
        String username = SCANNER.nextLine();
        System.out.print("Set PASSWORD: ");
        String password = SCANNER.nextLine();

        USERS_MANAGER.createUser(username, password);
    }
}

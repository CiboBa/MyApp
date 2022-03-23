package program.ui;

import program.ui.models.View;
import program.users.models.StandardUser;
import program.users.models.User;

import static program.ui.InitialView.SCANNER;
import static program.ui.InitialView.USERS_MANAGER;

public class AddUserView implements View {

    @Override
    public void init() {
        System.out.print("\nAdd user:\nSet USERNAME: ");
        String username = SCANNER.nextLine();
        System.out.print("Set PASSWORD: ");
        String password = SCANNER.nextLine();

        User user = createUser(username, password);
        USERS_MANAGER.addUser(user);

        View manageUsersView = new ManageUsersView();
        manageUsersView.init();
    }

    User createUser(String username, String password) {
        User user = new StandardUser(username, password);

        if (USERS_MANAGER.isPresent(user)) {
            System.out.println("User already exists!!!");
        } else {
            USERS_MANAGER.addUser(user);
        }
        System.out.println("\nUser added successfully: \nUsername: " + user.getUsername() + "\nPassword: " + user.getPassword());
        return user;
    }
}

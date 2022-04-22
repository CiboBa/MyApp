package program.ui;

import program.ui.models.View;
import program.users.models.StandardUser;
import program.users.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static program.ui.InitialView.*;

public class AddUserView implements View {

    @Override
    public void init() {
        System.out.print("\nAdd user:\nSet USERNAME: ");
        String username = SCANNER.nextLine();
        System.out.print("Set PASSWORD: ");
        String password = SCANNER.nextLine();

        USERS_DAO.save(createUser(username, password));

        View manageUsersView = new ManageUsersView();
        manageUsersView.init();
    }

    User createUser(String username, String password) {
        User user = new StandardUser(username, password);

        if (USERS_DAO.authenticate(user)) {
            System.out.println("User already exists!!!");
        } else {
            USERS_DAO.save(user);
        }
        System.out.println("\nUser added successfully: \nUsername: " + user.getUsername() + "\nPassword: " + user.getPassword());
        return user;
    }
}

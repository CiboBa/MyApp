package program.ui;

import program.ui.models.View;
import program.users.models.StandardUser;
import program.users.models.User;

import static program.ui.InitialView.*;

public class LoginView implements View {

    public static String usernameLogged;

    @Override
    public void init() {

        System.out.print("\nPlease enter:\nUSERNAME:");
        String username = SCANNER.nextLine();
        System.out.print("PASSWORD:");
        String password = SCANNER.nextLine();

        User user = new StandardUser(username, password);

        if (USERS_DAO.authenticate(user) && USERS_DAO.authorize(user)) {
            usernameLogged = username;
            authorized = true;
            System.out.println("\nYou have been logged in.");
            View loginAdminView = new LoginAdminView();
            loginAdminView.init();
        } else if (USERS_DAO.authenticate(user) && !USERS_DAO.authorize(user)) {
            usernameLogged = username;
            System.out.println("\nYou logged in as standard user\n");
            View loginStandardView = new LoginStandardView();
            loginStandardView.init();
        } else
            System.out.println("Wrong username or password!!!\n");
    }
}

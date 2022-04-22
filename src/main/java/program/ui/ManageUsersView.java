package program.ui;

import program.ui.models.View;

import static program.ui.InitialView.SCANNER;

public class ManageUsersView implements View {

    @Override
    public void init() {

        System.out.println("\n\nManage users:");
        System.out.println("1. Add user");
        System.out.println("2. Search user");
        System.out.println("0. Back");

        int option = Integer.parseInt(SCANNER.nextLine());

        switch (option) {
            case 1:
                View addUserView = new AddUserView();
                addUserView.init();
            case 2:
                View searchUserView = new SearchUserView();
                searchUserView.init();
            case 0:
                View loginAdminView = new LoginAdminView();
                loginAdminView.init();
            default:
                System.out.println("It is NOT a VALID COMMAND");
        }
    }
}

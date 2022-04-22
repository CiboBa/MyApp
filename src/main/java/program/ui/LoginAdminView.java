package program.ui;

import program.ui.models.View;

import static program.ui.InitialView.SCANNER;

public class LoginAdminView implements View {

    @Override
    public void init() {

        int option;

        while (true) {
            System.out.println("1. Manage users");
            System.out.println("2. Manage products");
            System.out.println("3. Logout");
//            System.out.println("4. Manage discounts ");
            System.out.println("0. Quit");
            option = Integer.parseInt(SCANNER.nextLine());

            switch (option) {
                case 1:
                    View manageUsersView = new ManageUsersView();
                    manageUsersView.init();
                case 2:
                    View manageProductsView = new ManageProductsView();
                    manageProductsView.init();
                case 3:
                    View initialView = new InitialView();
                    initialView.init();
//                case 4:
//                    View manageDiscountsView = new ManageDiscountsView();
//                    manageDiscountsView.init();
                case 0:
                    System.out.println("BYE!");
                    System.exit(0);
                default:
                    System.out.println("It is NOT a VALID COMMAND");
            }
        }
    }
}

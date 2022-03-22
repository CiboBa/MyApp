package program.ui;

import program.orders.OrderManager;
import program.orders.OrderManagerImpl;
import program.ui.models.View;
import program.users.UsersManager;
import program.users.UsersManagerImpl;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class InitialView implements View {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static final UsersManager USERS_MANAGER = new UsersManagerImpl();

    public static final OrderManager ORDER_MANAGER = new OrderManagerImpl();

    public void init() {

        int option = 9;
        System.out.println("Welcome to the program.App. What would you like to do?");

        while (true) {
            System.out.println("1. Login");
            System.out.println("0. Quit");

            option = Integer.parseInt(SCANNER.nextLine());

            switch (option) {
                case 1:
                    try {
                        LoginView loginView = new LoginView();
                        loginView.init();
                    } catch (NoSuchElementException ex) {
                        System.out.println(ex.getMessage());
                        option = 9;
                    }
                    break;
                case 0:
                    System.out.println("BYE!");
                    System.exit(0);
                default:
                    System.out.println("It is NOT a VALID COMMAND");
            }
        }
    }
}

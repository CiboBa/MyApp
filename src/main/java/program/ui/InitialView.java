package program.ui;

import program.orders.CartDAO;
import program.orders.DiscountManager;
import program.orders.ItemDAO;
import program.orders.OrderDAO;
import program.products.ProductDAO;
import program.ui.models.View;
import program.users.UsersDAO;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class InitialView implements View {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static final UsersDAO USERS_DAO = new UsersDAO();

    public static final ProductDAO PRODUCT_DAO = new ProductDAO();

    public static final ItemDAO ITEM_DAO = new ItemDAO();
    public static final CartDAO CART_DAO = new CartDAO();
    public static final OrderDAO ORDER_DAO = new OrderDAO();

    public static final DiscountManager DISCOUNT_MANAGER = DiscountManager.getInstance();
//    public static final DiscountDAO DISCOUNT_DAO = new DiscountDAO();

    public static boolean authorized = false;


    public void init() {

        int option;
        System.out.println("Welcome to the App. What would you like to do?");

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

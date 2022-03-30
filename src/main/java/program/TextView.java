package program;

import program.orders.DiscountManager;
import program.orders.models.*;
import program.products.ProductManager;
import program.products.ProductManagerImpl;
import program.products.models.Product;
import program.users.UsersManager;
import program.users.UsersManagerImpl;
import program.users.models.StandardUser;
import program.users.models.User;

import java.util.NoSuchElementException;
import java.util.Scanner;

@Deprecated
public class TextView {

    private static DiscountManager DISCOUNT_MANAGER;

    private final int END = 0;

    private final Scanner SCANNER = new Scanner(System.in);

    private final UsersManager USER_MANAGER = new UsersManagerImpl();

    private final ProductManager PRODUCT_MANAGER = new ProductManagerImpl();

    private static String usernameLogged;

    public void init() {

        DISCOUNT_MANAGER = DiscountManager.getInstance();

        int option = 9;
        System.out.println("Welcome to the program.App. What would you like to do?");

        while (option != END) {
            System.out.println("1. Login");
            System.out.println("0. Quit");

            option = Integer.parseInt(SCANNER.nextLine());

            switch (option) {
                case 1:
                    System.out.println("You chose to LOGIN");
                    try {
                        login();
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

    private void login() {
        System.out.print("\nPlease enter:\nUSERNAME:");
        String username = SCANNER.nextLine();
        System.out.print("PASSWORD:");
        String password = SCANNER.nextLine();

        User user = new StandardUser(username, password);

        if (USER_MANAGER.authorize(user) && USER_MANAGER.authentication(user)) {
            usernameLogged = username;
            System.out.println("\nYou have been logged in.");
            afterLogin(username);
        } else if (USER_MANAGER.authentication(user) && !USER_MANAGER.authorize(user)) {
            usernameLogged = username;
            System.out.println("\nYou logged in as standard user\n");
            afterLoginStandard();
        } else
            System.out.println("Wrong username or password!!!\n");

        init();
    }

    private void afterLoginStandard() {
        System.out.println("1. Product search by NAME");
        System.out.println("2. Product search by CATEGORY");
        System.out.println("3. Order history");
        System.out.println("4. View cart");
        System.out.println("0. Logout");
        int option = Integer.parseInt(SCANNER.nextLine());

        switch (option) {
            case 1:
                searchProductByNameSt();
            case 2:
                searchProductByCategorySt();
            case 3:
                userOrderHistory();
            case 4:
                viewCart();
            case 0:
                init();
                break;
        }
    }

    private void searchProductByCategorySt() {
        System.out.println("List products from category: ");
        String category = SCANNER.nextLine();

        System.out.printf("%3s %-8s %3s %5s %-10s\n", "No.", "Name:", "Qty:", "Price:", "Category:");
        PRODUCT_MANAGER.findProductByCategory(category);

        selectProductSt();
    }

    private void searchProductByNameSt() {
        System.out.println("List products containing: ");
        String nameSubstring = SCANNER.nextLine();

        System.out.printf("%3s %-8s %3s %5s %-10s\n", "No.", "Name:", "Qty:", "Price:", "Category:");
        PRODUCT_MANAGER.findProductByName(nameSubstring);

        selectProductSt();
    }

    private void userOrderHistory() {
        StandardUser user = (StandardUser) USER_MANAGER.findUser(usernameLogged);
        for (Order order : user.orders
        ) {
            System.out.println(order);
        }

        System.out.println("1. View order");
        System.out.println("0. Back");
        int option = Integer.parseInt(SCANNER.nextLine());

        switch (option) {
            case 1:
                viewOrder();
            case 0:
                afterLoginStandard();
        }
    }

    private void viewOrder() {
        System.out.println("\nEnter order ID");
        int orderId = Integer.parseInt(SCANNER.nextLine());
        StandardUser user = (StandardUser) USER_MANAGER.findUser(usernameLogged);
        Order viewedOrder = null;

        try {
            viewedOrder = user.orders.get(orderId - 1);
            int id = 0;
            System.out.println("\n" + viewedOrder);
            for (Item item : viewedOrder.getOrderItems()) {
                System.out.println(++id + " " + item);
            }

        } catch (IndexOutOfBoundsException e) {
            System.out.println("No such order!");
            afterLoginStandard();
        }

        System.out.println("\n0. Back");
        System.out.println("1. Cancel order");
        int option = Integer.parseInt(SCANNER.nextLine());

        switch (option) {
            case 1:
                assert viewedOrder != null;
                cancelOrderById(viewedOrder);
            case 0:
                afterLoginStandard();
        }
    }

    private void cancelOrderById(Order viewedOrder) {
        viewedOrder.setOrderStatusCancelled();
        System.out.println("Order cancelled");
        userOrderHistory();
    }


    private void afterLogin(String username) {
        int option;
        User user = USER_MANAGER.findUser(usernameLogged);
        System.out.println("\nPlease choose a command.");

        while (true) {
            System.out.println("1. Manage users");
            System.out.println("2. Manage discounts");
            System.out.println("3. Manage products");
            System.out.println("4. Logout");
            System.out.println("0. Quit");
            option = Integer.parseInt(SCANNER.nextLine());

            switch (option) {
                case 1:
                    manageUsers(username);
                case 2:
                    manageDiscounts();
                case 3:
                    manageProducts();
                    break;
                case 4:
                    init();
                    break;
                case 0:
                    System.out.println("BYE!");
                    System.exit(0);
                default:
                    System.out.println("It is NOT a VALID COMMAND");
            }
        }
    }

    private void manageDiscounts() {
        System.out.println("\nManage discounts:");
        System.out.println("1. Add discount");
        System.out.println("2. Remove discount");
        System.out.println("3. View discounts");
        System.out.println("0. Back");

        int option = Integer.parseInt(SCANNER.nextLine());

        switch (option) {
            case 1:
                addDiscount();
            case 2:
                System.out.println("Remove discount");
                removeDiscount();
            case 3:
                System.out.println("View discounts:");
                viewDiscount();
            case 0:
                afterLogin(usernameLogged);
            default:
                System.out.println("It is NOT a VALID COMMAND");
        }
    }

    private void viewDiscount() {
        DISCOUNT_MANAGER.viewDiscountList();
    }

    private void removeDiscount() {
        DISCOUNT_MANAGER.viewDiscountList();

        System.out.println("Choose discount to remove:");
        int discountId = Integer.parseInt(SCANNER.nextLine());

        Discount discount = DISCOUNT_MANAGER.selectDiscount(discountId - 1);
        DISCOUNT_MANAGER.deleteDiscount(discount);

        manageDiscounts();
    }

    private void addDiscount() {
        System.out.println("\nAdd discount:");
        System.out.println("1. 50% on second item");
        System.out.println("2. 10 euro for every 100 euro spent");
        System.out.println("3. 30% on product ");
        System.out.println("0. Back");

        int option = Integer.parseInt(SCANNER.nextLine());

        switch (option) {
            case 1:
                Discount fiftyPercentOnSecondItem = new FiftyPercentOnSecondItem();
                DISCOUNT_MANAGER.addDiscount(fiftyPercentOnSecondItem);
                manageDiscounts();
            case 2:
                Discount tenEurForEveryHundredSpent = new TenEurForEveryHundredSpent();
                DISCOUNT_MANAGER.addDiscount(tenEurForEveryHundredSpent);
                manageDiscounts();
            case 3:
                Discount thirtyPercentOnProduct = new ThirtyPercentOnProduct();
                DISCOUNT_MANAGER.addDiscount(thirtyPercentOnProduct);
                manageDiscounts();
            case 0:
                manageDiscounts();
            default:
                System.out.println("It is NOT a VALID COMMAND");
        }
    }

    private void manageUsers(String username) {
        System.out.println("\nManage users:");
        System.out.println("1. Add user");
        System.out.println("2. Search user");
        System.out.println("0. Back");

        int option = Integer.parseInt(SCANNER.nextLine());

        switch (option) {
            case 1:
                addUser();
            case 2:
                searchUser();
            case 0:
                afterLogin(username);
            default:
                System.out.println("It is NOT a VALID COMMAND");
        }
    }

    private void searchUser() {
        System.out.println("\nSearch user:");
        String username = SCANNER.nextLine();

        try {
            USER_MANAGER.findUser(username);
            userPreview(username);
        } catch (NoSuchElementException ex) {
            System.out.println("User not found - " + username);
            manageUsers(username);
        }
    }

    private void userPreview(String username) {
        System.out.println("\n1. View user orders");
        System.out.println("2. Edit user");
        System.out.println("3. Delete user");
        System.out.println("0. Back\n");

        int option = Integer.parseInt(SCANNER.nextLine());

        switch (option) {
            case 1:
                try {
                    StandardUser user = (StandardUser) USER_MANAGER.findUser(username);
                    for (Order order : user.orders
                    ) {
                        System.out.println(order);
                    }
                    findOrder(username);
                } catch (ClassCastException e) {
                    System.out.println("Admin must not have orders");
                }
                break;
            case 2:
                editUser(username);
                System.out.println("User updated: " + username);
                manageUsers(username);
            case 3:
                USER_MANAGER.deleteUser(username);
                System.out.println("User deleted successfully");
                manageUsers(username);
            case 0:
                afterLogin(usernameLogged);
            default:
                System.out.println("It is NOT a VALID COMMAND");
        }
    }

    private void findOrder(String username) {
        System.out.println("Type order number to select: ");
        int orderId = Integer.parseInt(SCANNER.nextLine()) - 1;
        StandardUser user = (StandardUser) USER_MANAGER.findUser(username);

        try {
//            ORDER_MANAGER.viewOrder();
//            System.out.println(user.orders.get(orderId).getOrderItems());
            editOrder(user, orderId);
        } catch (NumberFormatException e) {
            System.out.println("No such number");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Number not assigned");
            if (user.orders.size() <= 0) {
                System.out.println("This user has no orders yet");
                userPreview(user.getUsername());
            } else if (user.orders.size() == 1) {
                System.out.println("This user has got only one order. Type '1' for preview");
                findOrder(user.getUsername());
            } else {
                System.out.println("Choose number from 1 to " + user.orders.size());
                findOrder(user.getUsername());
            }
        }
        userPreview(user.getUsername());

    }

    private void editOrder(StandardUser user, int orderId) {
        System.out.println("\n\n1. Change status to: PENDING");
        System.out.println("2. Change status to: IN_PROGRESS");
        System.out.println("3. Change status to: READY");
        System.out.println("4. Delete order");
        System.out.println("0. Back");

        Order order = user.orders.get(orderId);

        int changeStatus = Integer.parseInt(SCANNER.nextLine());

        switch (changeStatus) {
            case 1:
                order.setOrderStatusPending();
                userPreview(user.getUsername());
            case 2:
                order.setOrderStatusInProgress();
                userPreview(user.getUsername());
            case 3:
                order.setOrderStatusReady();
                userPreview(user.getUsername());
            case 4:
                user.orders.remove(orderId);
                userPreview(user.getUsername());
            case 0:
                break;
            default:
                System.out.println("It is NOT a VALID COMMAND");
        }
    }

    private void editUser(String user) {
        System.out.print("\nEdit user:\nSet NEW USERNAME: ");
        String newUsername = SCANNER.nextLine();
        System.out.print("Set NEW PASSWORD: ");
        String newPassword = SCANNER.nextLine();

        USER_MANAGER.updateUser(user, newUsername, newPassword);

    }

    private void addUser() {

        System.out.print("\nAdd user:\nSet USERNAME: ");
        String username = SCANNER.nextLine();
        System.out.print("Set PASSWORD: ");
        String password = SCANNER.nextLine();

        User user = new StandardUser(username, password);

        if (USER_MANAGER.isPresent(user)) {
            System.out.println("User already exists!!!");
        } else {
            USER_MANAGER.addUser(user);
        }

        System.out.println("\nUser added successfully: \nUsername: " + user.getUsername() + "\nPassword: " + user.getPassword());
        manageUsers(username);
    }

    private void manageProducts() {
        System.out.println("\nManage products:");
        System.out.println("1. Add product");
        System.out.println("2. Search product by Name");
        System.out.println("3. Search product by Category");
        System.out.println("4. Edit product");
        System.out.println("5. Delete by ID");
        System.out.println("0. Back");

        int option = Integer.parseInt(SCANNER.nextLine());

        switch (option) {
            case 1:
                addProduct();
            case 2:
                searchProductByName();
            case 3:
                searchProductByCategory();
            case 4:
                selectProduct();
            case 5:
                deleteById();
            case 0:
                afterLogin(usernameLogged);
            default:
                System.out.println("It is NOT a VALID COMMAND");
        }
    }

    private void buyNow(Product product) {
        System.out.println("Type quantity you'd like to order: ");
        int qty = Integer.parseInt(SCANNER.nextLine());

        StandardUser user = (StandardUser) USER_MANAGER.findUser(usernameLogged);
        Item item = new Item(product, qty);
//        Order order = ORDER_MANAGER.createNew(item, user.getUsername());

//        user.orders.add(order);

        afterLoginStandard();

    }

    private void viewCart() {
        System.out.println("Your cart:");
        StandardUser user = (StandardUser) USER_MANAGER.findUser(usernameLogged);
        int id = 0;
        for (Item i : user.cart.cartItems
        ) {
            System.out.println(++id + ". " + i);
        }
        System.out.println("--------------------------------------------");
        System.out.println("\n1. Add another by ID");
        System.out.println("0. Back");
        int option = Integer.parseInt(SCANNER.nextLine());

        switch (option) {
            case 1:
                selectProductSt();
            case 0:
                afterLoginStandard();
        }

//        System.out.println("1. Checkout");
//        System.out.println("0. Back");
//
//        int option = Integer.parseInt(SCANNER.nextLine());
//
//        switch (option) {
//            case 1:
//                checkoutCart();
//                break;
//            case 0:
//                afterLoginStandard();
//            default:
//                System.out.println("It is NOT a VALID COMMAND");
//        }
    }

    private void checkoutCart() {
        //tworzy obiekt Order z obiektu Cart
        System.out.println("jeszcze nie działa :)");
        afterLoginStandard();
//        Order order = ORDER_MANAGER.createOrder();
//        CART.copyCartAndEmpty(usernameLogged, order);
//        ORDERS_MANAGER.addOrderToList(order);
    }

    private void deleteById() {
        System.out.println("Type number to delete");
        String ids = SCANNER.nextLine();

        PRODUCT_MANAGER.deleteProductById(ids);

        manageProducts();
    }

    private void searchProductByCategory() {
        System.out.println("List products from category: ");
        String category = SCANNER.nextLine();

        System.out.printf("%3s %-8s %3s %5s %-10s\n", "No.", "Name:", "Qty:", "Price:", "Category:");
        PRODUCT_MANAGER.findProductByCategory(category);

        selectProduct();
    }

    private void selectProductSt() {
        System.out.println("\nType product ID to select or press ENTER to go back");
        Product product;

        try {
            int productId = Integer.parseInt(SCANNER.nextLine());
            product = PRODUCT_MANAGER.selectProductById(productId);
            addToCartOrBuyNow(product);
        } catch (NumberFormatException e) {
            afterLoginStandard();
        }

    }

    private void addToCartOrBuyNow(Product product) {
        System.out.println("\n1. Add to cart");
        System.out.println("2. Buy now");
        System.out.println("0. Back");
        int option = Integer.parseInt(SCANNER.nextLine());

        switch (option) {
            case 1:
                addToCartByID(product);
            case 2:
                buyNow(product);
            case 0:
                break;
        }

        afterLoginStandard();
    }

    private void addToCartByID(Product product) {
        System.out.println("Type quantity you'd like to order: ");
        int qty = Integer.parseInt(SCANNER.nextLine());

        StandardUser user = (StandardUser) USER_MANAGER.findUser(usernameLogged);
        user.cart.cartItems.add(new Item(product, qty));

        viewCart();
    }

    private void selectProduct() {
        System.out.println("\nType product name to select or press ENTER to go back");

        String productName = SCANNER.nextLine();

        while (!productName.isEmpty()) {
            Product product = PRODUCT_MANAGER.selectProduct(productName);

            editOrDeleteProduct(product);
        }
        manageProducts();

    }


    private void editOrDeleteProduct(Product product) {
        System.out.println("1. Edit product");
        System.out.println("2. Delete product");
        System.out.println("0. Back");

        int option = Integer.parseInt(SCANNER.nextLine());

        switch (option) {
            case 1:
                editProduct(product);
            case 2:
                PRODUCT_MANAGER.deleteProduct(product);
                System.out.println("Product deleted successfully");
                manageProducts();
            case 0:
                manageProducts();
            default:
                System.out.println("It is NOT a VALID COMMAND");
        }
    }

    private void editProduct(Product product) {
        System.out.print("Set NEW NAME: ");
        String newName = SCANNER.nextLine();
        System.out.print("Set NEW QUANTITY: ");
        int newQuantity = Integer.parseInt(SCANNER.nextLine());
        System.out.print("Set NEW PRICE: ");
        double newPrice = Double.parseDouble(SCANNER.nextLine());
        System.out.print("Set NEW CATEGORY: ");
        String newCategory = SCANNER.nextLine();

        PRODUCT_MANAGER.updateProduct(product, newName, newQuantity, newPrice, newCategory);


        System.out.println("Product has been updated");
        manageProducts();
    }

    private void searchProductByName() {
        System.out.println("List products containing: ");
        String nameSubstring = SCANNER.nextLine();

        System.out.printf("%3s %-8s %3s %5s %-10s\n", "No.", "Name:", "Qty:", "Price:", "Category:");
        PRODUCT_MANAGER.findProductByName(nameSubstring);

        selectProduct();
    }


    private void addProduct() {
        System.out.print("\nAdd product:\nSet NAME: ");
        String productName = SCANNER.nextLine();
        System.out.print("Set QUANTITY: ");
        int quantity = Integer.parseInt(SCANNER.nextLine());
        System.out.print("Set PRICE: ");
        double price = Double.parseDouble(SCANNER.nextLine());
        System.out.print("Set CATEGORY: ");
        String category = SCANNER.nextLine();

        Product product = new Product(productName, quantity, price, category);

        if (PRODUCT_MANAGER.isPresent(product)) {
            System.out.println("Product already exists!!!");
        } else {
            PRODUCT_MANAGER.addProduct(product);
        }

        System.out.println(
                "Product added successfully: \n" +
                        "Name: " + product.getProductName() +
                        ", Qty: " + quantity +
                        ", Price: " + price +
                        ", Cat.: " + category);
        manageProducts();
    }
}
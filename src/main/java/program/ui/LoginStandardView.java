package program.ui;

import program.ui.models.View;

import static program.ui.InitialView.SCANNER;

public class LoginStandardView implements View {

    @Override
    public void init() {
        System.out.println("1. Product search by NAME");
        System.out.println("2. Product search by CATEGORY");
        System.out.println("3. Order history");
        System.out.println("4. View cart");
        System.out.println("0. Logout");
        int option = Integer.parseInt(SCANNER.nextLine());

        switch (option) {
            case 1:
                View searchProductByNameView = new SearchProductByNameView();
                searchProductByNameView.init();
            case 2:
                View searchProductByCategoryView = new SearchProductByCategoryView();
                searchProductByCategoryView.init();
            case 3:
                View userOrderHistory = new UserOrderHistory();
                userOrderHistory.init();
            case 4:
                View cartView = new CartView();
                cartView.init();
            case 0:
                View initialView = new InitialView();
                initialView.init();
        }
    }
}

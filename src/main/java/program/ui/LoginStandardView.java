package program.ui;

import program.ui.models.View;

import static program.ui.InitialView.SCANNER;

public class LoginStandardView implements View {

    @Override
    public void init() {
        System.out.println("1. Product search by NAME");
        System.out.println("2. Product search by CATEGORY");
        System.out.println("3. Add product to cart");
        System.out.println("4. Buy now");
        System.out.println("5. Order history");
        System.out.println("6. View cart");
        System.out.println("0. Logout");
        int option = Integer.parseInt(SCANNER.nextLine());

        switch (option) {
            case 1:
                View searchProductByNameView = new SearchProductByNameView();
                searchProductByNameView.init();
                break;
            case 2:
                View searchProductByCategoryView = new SearchProductByCategoryView();
                searchProductByCategoryView.init();
                break;
            case 3:
                View addToCartView = new AddToCartView();
                addToCartView.init();
            case 4:
                View buyNowView = new BuyNowView();
                buyNowView.init();
            case 5:
                View userOrderHistory = new UserOrderHistory();
                userOrderHistory.init();
            case 6:
                View cartView = new CartView();
                cartView.init();
            case 0:
                View initialView = new InitialView();
                initialView.init();
        }
    }
}

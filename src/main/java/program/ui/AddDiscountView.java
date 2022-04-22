package program.ui;

import program.orders.models.Discount;
import program.orders.models.FiftyPercentOnSecondItem;
import program.orders.models.TenEurForEveryHundredSpent;
import program.orders.models.ThirtyPercentOnProduct;
import program.ui.models.View;

import static program.ui.InitialView.DISCOUNT_MANAGER;
import static program.ui.InitialView.SCANNER;

//nie zaimplementowane
public class AddDiscountView implements View {

    @Override
    public void init() {
        System.out.println("\nAdd discount:");
        System.out.println("1. 50% on second item");
        System.out.println("2. 10 euro for every 100 euro spent");
        System.out.println("3. 30% on product ");
        System.out.println("0. Back");

        int option = Integer.parseInt(SCANNER.nextLine());
        View manageDiscountsView = new ManageDiscountsView();

        switch (option) {
            case 1:
                Discount fiftyPercentOnSecondItem = new FiftyPercentOnSecondItem();
                DISCOUNT_MANAGER.addDiscount(fiftyPercentOnSecondItem);
                manageDiscountsView.init();
            case 2:
                Discount tenEurForEveryHundredSpent = new TenEurForEveryHundredSpent();
                DISCOUNT_MANAGER.addDiscount(tenEurForEveryHundredSpent);
                manageDiscountsView.init();
            case 3:
                Discount thirtyPercentOnProduct = new ThirtyPercentOnProduct();
                DISCOUNT_MANAGER.addDiscount(thirtyPercentOnProduct);
                manageDiscountsView.init();
            case 0:
                manageDiscountsView.init();
            default:
                System.out.println("It is NOT a VALID COMMAND");
        }
    }
}

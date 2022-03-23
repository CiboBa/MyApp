package program.ui;

import program.ui.models.View;

import static program.ui.InitialView.DISCOUNT_MANAGER;
import static program.ui.InitialView.SCANNER;

public class ManageDiscountsView implements View {

    @Override
    public void init() {
        System.out.println("\nManage discounts:");
        System.out.println("1. Add discount");
        System.out.println("2. Remove discount");
        System.out.println("3. View discounts");
        System.out.println("0. Back");

        int option = Integer.parseInt(SCANNER.nextLine());

        switch (option) {
            case 1:
                View addDiscountView = new AddDiscountView();
                addDiscountView.init();
            case 2:
                View removeDiscountView = new RemoveDiscountView();
                removeDiscountView.init();
            case 3:
                DISCOUNT_MANAGER.viewDiscountList();
            case 0:
                View loginAdminView = new LoginAdminView();
                loginAdminView.init();
            default:
                System.out.println("It is NOT a VALID COMMAND");
        }
    }
}

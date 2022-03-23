package program.ui;

import program.orders.DiscountManager;
import program.orders.models.Discount;
import program.ui.models.View;

import static program.ui.InitialView.DISCOUNT_MANAGER;
import static program.ui.InitialView.SCANNER;

public class RemoveDiscountView implements View {

    @Override
    public void init() {
        DISCOUNT_MANAGER.viewDiscountList();

        System.out.println("Choose discount to delete from list:");
        int discountId = Integer.parseInt(SCANNER.nextLine());

        Discount discount = DISCOUNT_MANAGER.selectDiscount(discountId - 1);
        DISCOUNT_MANAGER.deleteDiscount(discount);

        View manageDiscountsView = new ManageDiscountsView();
        manageDiscountsView.init();
    }
}

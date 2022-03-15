package program.orders;

import program.orders.models.Discount;
import program.orders.models.FiftyPercentOnSecondItem;
import program.orders.models.TenEurForEveryHundredSpent;

import java.util.ArrayList;

public class DiscountManager {

    private static DiscountManager INSTANCE;

    public ArrayList<Discount> discountList;

    public DiscountManager() {
        discountList = new ArrayList<>();
        discountList.add(new TenEurForEveryHundredSpent());
    }

    public void addDiscount(Discount discount) {
        discountList.add(discount);
    }

    public void viewDiscountList() {
        for (Discount discount : discountList) {
            discount.viewDiscount();
            System.out.println("");
        }
        if (discountList.size() == 0)
            System.out.println("No added discounts" + "\n");
        else
            System.out.println("");
    }

    public Discount selectDiscount(int discountId) {
        return discountList.get(discountId);
    }

    public void deleteDiscount(Discount discount) {
        discountList.remove(discount);
    }

    public static DiscountManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DiscountManager();
        }
        return INSTANCE;
    }
}
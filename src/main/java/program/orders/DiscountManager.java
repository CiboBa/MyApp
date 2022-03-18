package program.orders;

import program.orders.models.Discount;

import java.util.ArrayList;

public class DiscountManager {

    private static DiscountManager instance;

    public ArrayList<Discount> discountList;

    public DiscountManager() {
        discountList = new ArrayList<>();
    }

    public void addDiscount(Discount discount) {
        discountList.add(discount);
    }

    public void viewDiscountList() {
        if (discountList.isEmpty()) System.out.println("No added discounts" + "\n");
        for (Discount discount : discountList) {
            discount.viewDiscount();
        }
    }

    public Discount selectDiscount(int discountId) {
        return discountList.get(discountId);
    }

    public void deleteDiscount(Discount discount) {
        discountList.remove(discount);
    }

    public static DiscountManager getInstance() {
        if (instance == null) {
            instance = new DiscountManager();
        }
        return instance;
    }
}
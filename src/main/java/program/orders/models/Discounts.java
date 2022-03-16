package program.orders.models;

public class Discounts {

    static Discounts INSTANCE;

    public Discounts() {
    }

    public static Discounts getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Discounts();
        }
        return INSTANCE;
    }
}

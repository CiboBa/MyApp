package program.orders;

import program.orders.models.Order;
import program.products.models.Product;

import java.util.ArrayList;
import java.util.List;

public class CartManagerImpl implements CartManager {

    public List<Product> cart = new ArrayList<>();

    public CartManagerImpl() {
    }

    @Override
    public boolean deleteFromCart() {
        return false;
    }

    @Override
    public Order copyCartAndEmpty(String username, Order order) {
        //zaimplementować kopiowanie produktów z Arraya 'cart' do setProductList;
        System.out.println("kopiujemy!!!!");

        System.out.println("Skopiowalim " +order);
        return null;
    }

    @Override
    public void addToCartByName(Product selectProduct) {
        cart.add(selectProduct);
    }

    @Override
    public void toString(List<Object> asList) {
        System.out.println(new ArrayList<>(cart));
    }
}

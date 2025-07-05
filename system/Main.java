package system;

import java.time.LocalDate;

import products.Cheese;
import products.TV;
public class Main {

    public static void main(String[] args) {
        Cheese cheese = new Cheese("cheese", 300, 5, 200, LocalDate.of(2026, 1, 1));
        TV tv = new TV("Samsung", 2000, 5, 200);
        Cart cart = new Cart();
        Customer customer = new Customer("ahmed", 5000);
        cart.addItem(cheese, 2);
        cart.addItem(tv, 1);
        Checkout checkout = new Checkout(customer, cart);
        checkout.processCheckout();
        System.out.println(cheese.getQuantity());
        System.out.println(tv.getQuantity());

    }

}
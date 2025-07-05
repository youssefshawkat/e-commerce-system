package system;

import java.time.LocalDate;

import products.Cheese;
import products.Mobile;
import products.MobileScratchCard;
import products.TV;
public class Main {

    public static void main(String[] args) {
        Cheese cheese = new Cheese("cheese", 300, 5, 200, LocalDate.of(2025, 8, 1));
        TV tv = new TV("Samsung", 2000, 5, 200);
        Mobile mobile = new Mobile("iPhone 15", 500, 10, 300);
        MobileScratchCard scratchCard = new MobileScratchCard("credit", 20, 10);
        Customer customer = new Customer("Ahmed", 10000);
        Cart cart = new Cart();
        cart.addItem(cheese, 5);
        cart.addItem(scratchCard,5);
        cart.removeItem(cheese);
        Checkout checkout = new Checkout(customer, cart);
        checkout.processCheckout();



    }

}
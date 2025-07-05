package system;

import products.*;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        /*
         * ─────────────────────────────
         * 1. SET‑UP PRODUCTS
         * ─────────────────────────────
         */
        Cheese cheese = new Cheese("Cheese", 100, 10, 200, LocalDate.of(2025, 12, 1));
        Biscuits biscuits = new Biscuits("Biscuits", 150, 5, 700, LocalDate.of(2025, 12, 1));
        TV tv = new TV("Samsung TV", 8000, 3, 10000);
        MobileScratchCard card = new MobileScratchCard("Scratch-Card", 50, 100);

        /*
         * ─────────────────────────────
         * 2. HAPPY‑PATH CHECKOUT
         * (matches PDF example)
         * ─────────────────────────────
         */
        // ================Happy-Scenario================
        Customer customer = new Customer("Ahmed", 10_000);
        Cart normalCart = new Cart();

        normalCart.addItem(cheese, 2); 
        normalCart.addItem(biscuits, 1); 
        normalCart.addItem(card, 3);

        new Checkout(customer, normalCart).processCheckout();

        // ================Cart-Is-Empty================

        System.out.println("\n=== EMPTY CART SCENARIO ===");
        try {
            Cart emptyCart = new Cart();
            new Checkout(customer, emptyCart).processCheckout();
        } catch (IllegalStateException e) {
            System.out.println("Expected error  " + e.getMessage());
        }

        // ================OUT-OF-STOCK================

        System.out.println("\n=== OUT-OF-STOCK ===");
        try {
            Cart outOfStockCart = new Cart();
            outOfStockCart.addItem(tv, 5); 
        } catch (IllegalStateException e) {
            System.out.println("Expected error  " + e.getMessage());
        }

        // ================Expired-Product================

        System.out.println("\n=== EXPIRED PRODUCT ===");
        try {
            Cheese oldCheese = new Cheese("Old Cheese", 90, 4, 200,
                    LocalDate.of(2024, 1, 1));
            Cart expiredCart = new Cart();
            expiredCart.addItem(oldCheese, 1);
        } catch (IllegalStateException e) {
            System.out.println("Expected error  " + e.getMessage());
        }

        // ================INSUFFICIENT-BALANCE================

        System.out.println("\n=== INSUFFICIENT BALANCE ===");
        try {
            Customer poorCustomer = new Customer("Mostafa", 200); 
            Cart expensiveCart = new Cart();
            expensiveCart.addItem(cheese, 2);
            new Checkout(poorCustomer, expensiveCart).processCheckout();
        } catch (IllegalStateException e) {
            System.out.println("Expected error  " + e.getMessage());
        }
    }
}

package system;

import products.*;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        /* ─────────────────────────────
         * 1.  SET‑UP  PRODUCTS
         * ───────────────────────────── */
        Cheese   cheese        = new Cheese  ("Cheese",        100, 10, 200,  LocalDate.of(2025, 12, 1));
        Biscuits biscuits      = new Biscuits("Biscuits",      150,  5, 700,  LocalDate.of(2025, 12, 1));
        TV       tv            = new TV      ("Samsung TV",   8000,  3, 10000);
        MobileScratchCard card = new MobileScratchCard("Scratch-Card", 50, 100);

        /* ─────────────────────────────
         * 2.  HAPPY‑PATH CHECKOUT
         *     (matches PDF example)
         * ───────────────────────────── */
        System.out.println("\n=== HAPPY-PATH CHECKOUT ===");
        Customer rich = new Customer("Ahmed", 10_000);
        Cart cartOK   = new Cart();

        cartOK.addItem(cheese,   2);   // shippable
        cartOK.addItem(biscuits, 1);   // shippable
        cartOK.addItem(card,     3);   // non‑shippable

        new Checkout(rich, cartOK).processCheckout();

        /* ─────────────────────────────
         * 3.  CART IS EMPTY
         * ───────────────────────────── */
        System.out.println("\n=== EMPTY CART SCENARIO ===");
        try {
            Cart emptyCart = new Cart();
            new Checkout(rich, emptyCart).processCheckout();
        } catch (IllegalStateException e) {
            System.out.println("Expected error  " + e.getMessage());
        }

        /* ─────────────────────────────
         * 4.  OUT‑OF‑STOCK ADD
         * ───────────────────────────── */
        System.out.println("\n=== OUT-OF-STOCK ADD ===");
        try {
            Cart cartStock = new Cart();
            cartStock.addItem(tv, 5);   // TV only has qty 3
        } catch (IllegalStateException e) {
            System.out.println("Expected error  " + e.getMessage());
        }

        /* ─────────────────────────────
         * 5.  EXPIRED PRODUCT
         * ───────────────────────────── */
        System.out.println("\n=== EXPIRED PRODUCT ===");
        try {
            Cheese oldCheese = new Cheese("Old Cheese", 90, 4, 200,
                                          LocalDate.of(2024, 1, 1)); // already expired
            Cart cartExpired = new Cart();
            cartExpired.addItem(oldCheese, 1);
        } catch (IllegalStateException e) {
            System.out.println("Expected error  " + e.getMessage());
        }

        /* ─────────────────────────────
         * 6.  INSUFFICIENT BALANCE
         * ───────────────────────────── */
        System.out.println("\n=== INSUFFICIENT BALANCE ===");
        try {
            Customer poor = new Customer("Mostafa", 200);   // not enough funds
            Cart cartPoor = new Cart();
            cartPoor.addItem(cheese, 2);
            new Checkout(poor, cartPoor).processCheckout();
        } catch (IllegalStateException e) {
            System.out.println("Expected error  " + e.getMessage());
        }
    }
}

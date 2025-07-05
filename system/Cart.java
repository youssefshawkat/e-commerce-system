package system;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    Map<Product, Integer> productQuantityMap = new HashMap<>();

    public void addItem(Product product, int quantity) {
        if (quantity > product.getQuantity()) {
            throw new IllegalStateException("Sorry we only have " + product.getQuantity() + " in Stock");
        } else if (product instanceof Expirable && ((Expirable) product).isExpired()) {
            throw new IllegalStateException("Sorry " + product.getName() + " is Expired!");

        }

        productQuantityMap.put(product, quantity);
        System.out.println("item added successfully");

    }

    public void removeItem(Product product) {
        if (productQuantityMap.containsKey(product)) {
            productQuantityMap.remove(product);
            System.out.println("item removed successfully");
        } else {
            System.out.println("item is not in the cart!");
        }

    public Map<Product, Integer> getAllitems() {
        return productQuantityMap;
    }

}
package system;
import java.util.HashMap;
import java.util.Map;

public class Checkout {
    private Customer customer;
    private Cart cart;
    private Map<Product, Integer> products;
    private Map<Product, Integer> shippableProducts;
    private double totalPrice;
    private ShippingService shippingService;
    private StringBuilder reciept;

    public Checkout(Customer customer, Cart cart) {
        this.customer = customer;
        this.cart = cart;
        shippableProducts = new HashMap<>();
        products = new HashMap<>(cart.getAllitems());
        reciept = new StringBuilder("** Checkout receipt **\n");
    }

    public void processCheckout() {
        int quantity;
        double currentItemTotalPrice;
        
        if (cart.getAllitems().isEmpty()) {
             throw new IllegalStateException("Cart is Empty!");
        }

        for (Product product : products.keySet()) {
            if (product instanceof Expirable && ((Expirable) product).isExpired()) {
                 throw new IllegalStateException(product.getName() + " is Expired!");
            }
            if (product instanceof Shippable) {
                shippableProducts.put(product, products.get(product));
            }
            quantity = products.get(product);
            currentItemTotalPrice = quantity * product.getPrice();
            totalPrice += currentItemTotalPrice;
            reciept.append(quantity + "x " + product.getName() + "       " + currentItemTotalPrice + "\n");

        }
        
        reciept.append("-----------------\n");
        reciept.append("Subtotal:      " + totalPrice + "\n");
        if (!shippableProducts.isEmpty()) {
            shippingService = new ShippingService(shippableProducts);
            shippingService.processShipment();
            reciept.append("Shipping:      " + shippingService.getShippingCost() + "\n");
            totalPrice += shippingService.getShippingCost();
        }
        reciept.append("Amount:        " + totalPrice);
        System.out.println(reciept);
        if (customer.getBalance() < totalPrice) {
             throw new IllegalStateException("Error insufficient funds!");
        } else {
            customer.makePayment(totalPrice);
            for (Product product : products.keySet()) {
                product.setQuantity(product.getQuantity()-products.get(product));
            }
        }
    }

    public Customer getCustomer() {
        return customer;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}

package system;

import java.util.Map;

public class ShippingService {
    private double totalShippingCost = 0;
    private double totalWeight = 0;
    private StringBuilder shippingNotice;
    private Map<Product, Integer> shippableProducts;

    ShippingService(Map<Product, Integer> products) {
        shippingNotice = new StringBuilder("** Shipment notice ** \n");
        shippableProducts = products;
    }

    public double processShipment() {
        int quantity;
        double weight;
        for (Product product : shippableProducts.keySet()) {
            quantity = shippableProducts.get(product);
            weight = quantity * ((Shippable) product).getWeight();
            totalWeight += weight;
            shippingNotice.append(quantity + "x " + product.getName() + "      " + weight + "g\n");
        }
        shippingNotice.append("Total package weight " + totalWeight / 1000.0 + "kg\n");
        totalShippingCost = totalWeight * 0.027;
        System.out.println(shippingNotice);
        return totalShippingCost;
    }

    public double getShippingCost() {
        return totalShippingCost;
    }
}

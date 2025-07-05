package products;

import java.time.LocalDate;
import system.*;

public class Biscuits extends Product implements Expirable, Shippable {
    private double weight;
    private LocalDate expiryDate;

    public Biscuits(String name, double price, int quantity, double weight, LocalDate expireyDate) {
        super(name, price, quantity);
        this.weight = weight;
        this.expiryDate = expireyDate;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public LocalDate getExpirationDate() {
        return expiryDate;
    }

    @Override
    public void setExpirationDate(LocalDate expirationDate) {
        expiryDate = expirationDate;
    }

    @Override
    public Boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }

}

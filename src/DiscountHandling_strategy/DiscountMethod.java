package DiscountHandling_strategy;

public class DiscountMethod {
    private final DiscountStrategy discount;
    public DiscountMethod(DiscountStrategy discount) {
        this.discount = discount;
    }

    public double calculateDiscount(double amount) {
        return discount.calculateDiscount(amount);
    }
}

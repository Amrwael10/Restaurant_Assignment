package DiscountHandling_strategy;

public class NoDiscount implements DiscountStrategy{
    @Override
    public double calculateDiscount(double amount) {
        return amount;
    }
}

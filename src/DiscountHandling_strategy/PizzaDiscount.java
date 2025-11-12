package DiscountHandling_strategy;

public class PizzaDiscount implements DiscountStrategy{
    @Override
    public double calculateDiscount(double amount) {
        return amount * 0.4; // 40% discount on pizza
    }
}

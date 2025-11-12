package DiscountHandling_strategy;

public class ChickenDiscount implements DiscountStrategy{

    @Override
    public double calculateDiscount(double amount) {
        return amount * 0.5; // 50% discount on chicken
    }
}

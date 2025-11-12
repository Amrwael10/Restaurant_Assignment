package DiscountHandling_strategy;

public class MeatDiscount implements DiscountStrategy{

    @Override
    public double calculateDiscount(double amount) {
        return amount * 0.2; // 20% discount on meat
    }
}

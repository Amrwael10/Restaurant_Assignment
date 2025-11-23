package DiscountHandling_strategy;

import Order.WorkFlow_Template.OrderDetails;

public class NoDiscount implements DiscountStrategy{
    @Override
    public double calculateDiscount(OrderDetails order) {
        return 0.0;
    }
}

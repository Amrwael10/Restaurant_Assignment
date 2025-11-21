package DiscountHandling_strategy;

import Order.WorkFlow_Template.Order;

public class MeatDiscount implements DiscountStrategy{

    @Override
    public double calculateDiscount(Order order) {
        return order.getTotal()* 0.2; // 20% discount on meat
    }
}

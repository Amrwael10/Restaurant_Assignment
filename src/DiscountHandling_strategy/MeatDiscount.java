package DiscountHandling_strategy;

import Order.WorkFlow_Template.OrderDetails;

public class MeatDiscount implements DiscountStrategy{

    @Override
    public double calculateDiscount(OrderDetails order) {
        return order.getTotal()* 0.2; // 20% discount on meat
    }
}

package Billing;
import Order.WorkFlow_Template.OrderDetails;
import DiscountHandling_strategy.*;
import PaymentSystem_straegy.PaymentStrategy;

public class BillGenerator {
    private PaymentStrategy paymentStrategy;
    private DiscountStrategy discountStrategy;

    public void setPaymentStrategy(PaymentStrategy p) {
        this.paymentStrategy = p;
    }

    public void setDiscountStrategy(DiscountStrategy d) {
        this.discountStrategy = d;
    }

    public boolean checkout(OrderDetails order) {
        if (paymentStrategy == null)
            throw new IllegalStateException("Payment strategy not set");

        if (discountStrategy == null)
            discountStrategy = new NoDiscount();

        double total = order.getTotal();
        double discount = discountStrategy.calculateDiscount(order);
        double finalAmount = total - discount;

        return paymentStrategy.pay(finalAmount);
    }
}


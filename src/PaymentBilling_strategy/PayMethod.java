package PaymentBilling_strategy;

public class PayMethod {
    private final PaymentStrategy payment;
    public PayMethod(PaymentStrategy payment) {
        this.payment = payment;
    }

    public void pay(double amount) {
        payment.pay(amount);
    }
}

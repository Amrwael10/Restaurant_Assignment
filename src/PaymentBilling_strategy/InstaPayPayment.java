package PaymentBilling_strategy;

public class InstaPayPayment implements PaymentStrategy{
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " in InstaPay.");
    }
}

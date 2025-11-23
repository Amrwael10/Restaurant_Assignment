package PaymentSystem_straegy;

public class InstaPayPayment implements PaymentStrategy {
    @Override
    public boolean pay(double amount) {
        System.out.println("Paid $" + amount + " in InstaPay.");
        return true;
    }
}

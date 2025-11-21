package Order.WorkFlow_Template;
import Order.Notification_Observer.OrderNotification;
import Billing.BillGenerator;
import Billing.CashPayment;
import Menu.MenuItemVariations_AbstractFactory.*;
public class DineInOrder extends OrderWorkflow {
private BillGenerator billing;
private OrderNotification manager;


public void DineInWorkflow(BillGenerator b, OrderNotification m) { this.billing = b; this.manager = m; }
protected void displayMenu() { System.out.println("Display dine-in menu"); }
protected void selectItems() { order = new OrderBuilder().addItem(new MenuItem("Sample",5)).build(); }
protected void chooseOrderType() { order.setOrderType("DINE-IN"); }
protected void processPayment() { billing.setPaymentStrategy(new CashPayment()); billing.checkout(order); }
protected void placeOrder() { manager.notifyObservers(order); }
}
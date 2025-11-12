package Billing;

public class BillGenerator {
    public void generateBill(String itemName, double total) {
        System.out.println("\n--- BILL ---");
        System.out.println("Item: " + itemName);
        System.out.println("Total after discount: $" + total);
        System.out.println("-------------\n");
    }
}

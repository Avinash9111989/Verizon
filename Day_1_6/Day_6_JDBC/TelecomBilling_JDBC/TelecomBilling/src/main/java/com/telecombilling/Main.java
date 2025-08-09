
package com.telecombilling;

public class Main {
    public static void main(String[] args) {
        TelecomBillingSystem billingSystem = new TelecomBillingSystem();
        Customer customer = new Customer("CUST001", "Alice Smith", "alice@example.com", "postpaid");
        billingSystem.addCustomer(customer);
        try {
            Invoice invoice = billingSystem.generateInvoice("CUST001", 50.0, 25.0, 5.0);
            System.out.println("Invoice generated for Customer " + invoice.getCustomerId() +
                    " with amount: $" + invoice.getAmount());
        } catch (BillingException e) {
            System.err.println("Error generating invoice: " + e.getMessage());
        }
    }
}

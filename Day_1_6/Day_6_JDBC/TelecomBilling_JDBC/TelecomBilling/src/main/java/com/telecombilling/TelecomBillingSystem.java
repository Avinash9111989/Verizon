
package com.telecombilling;

import java.sql.SQLException;
import java.util.*;

public class TelecomBillingSystem {
    private Map<String, Customer> customerMap = new HashMap<>();
    private List<Invoice> invoiceHistory = new ArrayList<>();

    public void addCustomer(Customer customer) {
        customerMap.put(customer.getCustomerId(), customer);
        try {
            DatabaseManager.saveCustomer(customer);
        } catch (SQLException e) {
            System.err.println("Error saving customer: " + e.getMessage());
        }
    }

    public Invoice generateInvoice(String customerId, double callCharges, double dataCharges, double smsCharges)
            throws BillingException {
        if (!customerMap.containsKey(customerId)) {
            throw new BillingException("Customer not found.");
        }
        double totalAmount = callCharges + dataCharges + smsCharges;
        if (totalAmount < 0) {
            throw new BillingException("Calculated bill cannot be negative.");
        }
        String invoiceId = UUID.randomUUID().toString();
        Invoice invoice = new Invoice(invoiceId, customerId, totalAmount, new Date());
        invoiceHistory.add(invoice);
        try {
            DatabaseManager.saveInvoice(invoice);
        } catch (SQLException e) {
            System.err.println("Error saving invoice: " + e.getMessage());
        }
        return invoice;
    }
}

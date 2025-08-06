
package com.telecombilling;

import java.util.Date;

public class Invoice {
    private String invoiceId;
    private String customerId;
    private double amount;
    private Date billingDate;

    public Invoice(String invoiceId, String customerId, double amount, Date billingDate) {
        this.invoiceId = invoiceId;
        this.customerId = customerId;
        this.amount = amount;
        this.billingDate = billingDate;
    }

    public String getInvoiceId() { return invoiceId; }
    public String getCustomerId() { return customerId; }
    public double getAmount() { return amount; }
    public Date getBillingDate() { return billingDate; }
}

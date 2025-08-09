
package com.telecombilling;

public class Customer {
    private String customerId;
    private String name;
    private String contact;
    private String planType;

    public Customer(String customerId, String name, String contact, String planType) {
        this.customerId = customerId;
        this.name = name;
        this.contact = contact;
        this.planType = planType;
    }

    public String getCustomerId() { return customerId; }
    public String getName() { return name; }
    public String getContact() { return contact; }
    public String getPlanType() { return planType; }
}

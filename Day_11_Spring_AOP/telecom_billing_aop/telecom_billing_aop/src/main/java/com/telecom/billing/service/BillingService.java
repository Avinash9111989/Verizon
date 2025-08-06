package com.telecom.billing.service;

import org.springframework.stereotype.Service;

@Service
public class BillingService {
    public double generateBill(String customerId, int callMinutes) {
        System.out.println("Calculating bill for customer: " + customerId);
        return callMinutes * 1.5;
    }
}


package com.verizon.recharge.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Recharge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
   
    private Long id;
    private String userId;
    private double amount;
    private String planType;
    private LocalDate rechargeDate;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public String getPlanType() { return planType; }
    public void setPlanType(String planType) { this.planType = planType; }
    public LocalDate getRechargeDate() { return rechargeDate; }
    public void setRechargeDate(LocalDate rechargeDate) { this.rechargeDate = rechargeDate; }
}

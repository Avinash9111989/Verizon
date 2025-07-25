package com.vas;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String userId;
    private String name;
    private String phoneNumber;
    private int balance;
    private List<VAS> activeVAS = new ArrayList<>();

    public User(String userId, String name, String phoneNumber, int balance) {
        this.userId = userId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }

    public String getUserId() { return userId; }
    public String getName() { return name; }
    public String getPhoneNumber() { return phoneNumber; }
    public int getBalance() { return balance; }
    public void setBalance(int balance) { this.balance = balance; }
    public List<VAS> getActiveVAS() { return activeVAS; }
}

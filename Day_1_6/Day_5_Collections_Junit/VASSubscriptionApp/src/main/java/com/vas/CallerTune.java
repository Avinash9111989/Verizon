package com.vas;

public class CallerTune extends VAS implements Billing {
    public CallerTune() { super("Caller Tune"); }
    public int getCost() { return 100; }
    public int deduct(User u) { return u.getBalance() - getCost(); }
}

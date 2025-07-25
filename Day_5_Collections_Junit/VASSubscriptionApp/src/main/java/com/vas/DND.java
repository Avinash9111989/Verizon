package com.vas;

public class DND extends VAS implements Billing {
    public DND() { super("DND"); }
    public int getCost() { return 0; }
    public int deduct(User u) { return u.getBalance(); }
}

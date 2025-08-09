package com.vas;

public abstract class VAS {
    private String name;
    public VAS(String name) { this.name = name; }
    public String getName() { return name; }
    public abstract int getCost();
}

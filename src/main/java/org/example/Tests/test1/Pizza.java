package org.example.Tests.test1;

public class Pizza {
    public String name;
    public int price_L;
    public int price_S;
    public int price_M;

    public Pizza(int price_M, int price_S, int price_L, String name) {
        this.price_M = price_M;
        this.price_S = price_S;
        this.price_L = price_L;
        this.name = name;
    }

}

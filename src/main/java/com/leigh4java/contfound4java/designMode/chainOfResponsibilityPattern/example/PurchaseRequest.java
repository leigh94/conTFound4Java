package com.leigh4java.contfound4java.designMode.chainOfResponsibilityPattern.example;

// 请求类
public class PurchaseRequest {
    private int id;
    private String description;
    private double amount; // 采购金额

    public PurchaseRequest(int id, String description, double amount) {
        this.id = id;
        this.description = description;
        this.amount = amount;
    }

    // getters
    public int getId() { return id; }
    public String getDescription() { return description; }
    public double getAmount() { return amount; }

    @Override
    public String toString() {
        return "采购请求#" + id + " [" + description + "] 金额: ¥" + amount;
    }
}


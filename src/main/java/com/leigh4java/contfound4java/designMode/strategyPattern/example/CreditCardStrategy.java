package com.leigh4java.contfound4java.designMode.strategyPattern.example;

// 信用卡支付策略
public class CreditCardStrategy implements PaymentStrategy {
    private String cardNumber;
    private String cvv;
    private String expiryDate;

    public CreditCardStrategy(String cardNumber, String cvv, String expiryDate) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean pay(double amount) {
        // 模拟信用卡支付逻辑
        System.out.println("使用信用卡支付: 卡号=" + maskCardNumber(cardNumber) + ", 金额=" + amount);
        // 模拟支付处理
        try {
            Thread.sleep(800); // 模拟银行处理时间
            System.out.println("信用卡支付成功!");
            return true;
        } catch (InterruptedException e) {
            System.out.println("信用卡支付失败!");
            return false;
        }
    }

    @Override
    public String getPaymentMethod() {
        return "信用卡";
    }

    @Override
    public double getFee(double amount) {
        // 信用卡手续费：1.5%
        return amount * 0.015;
    }

    private String maskCardNumber(String cardNumber) {
        if (cardNumber.length() <= 4) {
            return cardNumber;
        }
        return "****-****-****-" + cardNumber.substring(cardNumber.length() - 4);
    }
}
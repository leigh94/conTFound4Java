package com.leigh4java.contfound4java.designMode.strategyPattern.example;

// 银联支付策略
public class UnionPayStrategy implements PaymentStrategy {
    private String cardNumber;

    public UnionPayStrategy(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean pay(double amount) {
        // 模拟银联支付逻辑
        System.out.println("使用银联支付: 卡号=" + maskCardNumber(cardNumber) + ", 金额=" + amount);
        // 模拟支付处理
        try {
            Thread.sleep(600); // 模拟银行处理时间
            System.out.println("银联支付成功!");
            return true;
        } catch (InterruptedException e) {
            System.out.println("银联支付失败!");
            return false;
        }
    }

    @Override
    public String getPaymentMethod() {
        return "银联支付";
    }

    @Override
    public double getFee(double amount) {
        // 银联支付手续费：0.8%
        return amount * 0.008;
    }

    private String maskCardNumber(String cardNumber) {
        if (cardNumber.length() <= 4) {
            return cardNumber;
        }
        return "****-****-****-" + cardNumber.substring(cardNumber.length() - 4);
    }
}

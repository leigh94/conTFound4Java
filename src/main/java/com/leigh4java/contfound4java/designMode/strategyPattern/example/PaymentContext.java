package com.leigh4java.contfound4java.designMode.strategyPattern.example;

// 支付上下文 - 负责管理支付策略
public class PaymentContext {
    private PaymentStrategy paymentStrategy;
    private String orderId;
    private double amount;

    public PaymentContext(String orderId, double amount) {
        this.orderId = orderId;
        this.amount = amount;
    }

    /**
     * 设置支付策略
     */
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    /**
     * 执行支付
     */
    public boolean executePayment() {
        if (paymentStrategy == null) {
            System.out.println("错误：未设置支付策略");
            return false;
        }

        System.out.println("开始支付订单: " + orderId);
        System.out.println("支付方式: " + paymentStrategy.getPaymentMethod());
        System.out.println("支付金额: " + amount);
        System.out.println("手续费: " + paymentStrategy.getFee(amount));
        System.out.println("实付金额: " + (amount + paymentStrategy.getFee(amount)));

        return paymentStrategy.pay(amount + paymentStrategy.getFee(amount));
    }

    /**
     * 获取支付信息
     */
    public void displayPaymentInfo() {
        if (paymentStrategy != null) {
            System.out.println("订单号: " + orderId);
            System.out.println("支付方式: " + paymentStrategy.getPaymentMethod());
            System.out.println("商品金额: " + amount);
            System.out.println("手续费: " + paymentStrategy.getFee(amount));
            System.out.println("总金额: " + (amount + paymentStrategy.getFee(amount)));
        } else {
            System.out.println("未设置支付方式");
        }
    }

    // Getter方法
    public String getOrderId() {
        return orderId;
    }

    public double getAmount() {
        return amount;
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }
}

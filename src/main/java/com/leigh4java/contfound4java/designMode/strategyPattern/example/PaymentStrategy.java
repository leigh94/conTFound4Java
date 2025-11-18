package com.leigh4java.contfound4java.designMode.strategyPattern.example;

// 支付策略接口
public interface PaymentStrategy {
    /**
     * 支付方法
     * @param amount 支付金额
     * @return 支付结果
     */
    boolean pay(double amount);

    /**
     * 获取支付方式名称
     * @return 支付方式名称
     */
    String getPaymentMethod();

    /**
     * 获取支付手续费
     * @param amount 支付金额
     * @return 手续费
     */
    default double getFee(double amount) {
        return 0.0;
    }
}

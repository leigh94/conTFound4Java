package com.leigh4java.contfound4java.designMode.strategyPattern.example;

// 支付宝支付策略
public class AlipayStrategy implements PaymentStrategy {
    private String account;
    private String password;

    public AlipayStrategy(String account, String password) {
        this.account = account;
        this.password = password;
    }

    @Override
    public boolean pay(double amount) {
        // 模拟支付宝支付逻辑
        System.out.println("使用支付宝支付: 账户=" + account + ", 金额=" + amount);
        // 模拟支付处理
        try {
            Thread.sleep(500); // 模拟网络延迟
            System.out.println("支付宝支付成功!");
            return true;
        } catch (InterruptedException e) {
            System.out.println("支付宝支付失败!");
            return false;
        }
    }

    @Override
    public String getPaymentMethod() {
        return "支付宝";
    }

    @Override
    public double getFee(double amount) {
        // 支付宝手续费：0.6%
        return amount * 0.006;
    }
}

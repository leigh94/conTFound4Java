package com.leigh4java.contfound4java.designMode.strategyPattern.example;

// 微信支付策略
public class WechatPayStrategy implements PaymentStrategy {
    private String openId;

    public WechatPayStrategy(String openId) {
        this.openId = openId;
    }

    @Override
    public boolean pay(double amount) {
        // 模拟微信支付逻辑
        System.out.println("使用微信支付: OpenID=" + openId + ", 金额=" + amount);
        // 模拟支付处理
        try {
            Thread.sleep(300); // 模拟网络延迟
            System.out.println("微信支付成功!");
            return true;
        } catch (InterruptedException e) {
            System.out.println("微信支付失败!");
            return false;
        }
    }

    @Override
    public String getPaymentMethod() {
        return "微信支付";
    }

    @Override
    public double getFee(double amount) {
        // 微信支付手续费：0.55%
        return amount * 0.0055;
    }
}

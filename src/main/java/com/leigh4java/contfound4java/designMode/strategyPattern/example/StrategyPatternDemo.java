package com.leigh4java.contfound4java.designMode.strategyPattern.example;

import java.util.Arrays;
import java.util.List;

// 策略模式演示
public class StrategyPatternDemo {
    public static void main(String[] args) {
        System.out.println("=== 策略模式演示：支付系统 ===\n");

        // 创建支付上下文
        PaymentContext context = new PaymentContext("ORDER-2024-001", 1000.0);

        // 演示不同支付策略
        System.out.println("1. 支付宝支付演示:");
        PaymentStrategy alipay = new AlipayStrategy("user@alipay.com", "encrypted_pwd");
        context.setPaymentStrategy(alipay);
        context.displayPaymentInfo();
        boolean result1 = context.executePayment();
        System.out.println("支付结果: " + (result1 ? "成功" : "失败"));

        System.out.println("\n" + "=".repeat(50) + "\n");

        System.out.println("2. 微信支付演示:");
        PaymentStrategy wechatPay = new WechatPayStrategy("wx_openid_123456");
        context.setPaymentStrategy(wechatPay);
        context.displayPaymentInfo();
        boolean result2 = context.executePayment();
        System.out.println("支付结果: " + (result2 ? "成功" : "失败"));

        System.out.println("\n" + "=".repeat(50) + "\n");

        System.out.println("3. 信用卡支付演示:");
        PaymentStrategy creditCard = new CreditCardStrategy("1234567812345678", "123", "12/25");
        context.setPaymentStrategy(creditCard);
        context.displayPaymentInfo();
        boolean result3 = context.executePayment();
        System.out.println("支付结果: " + (result3 ? "成功" : "失败"));

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 使用策略工厂
        System.out.println("4. 使用策略工厂创建支付策略:");
        try {
            PaymentStrategy unionPay = PaymentStrategyFactory.createStrategy("unionpay", "6225880123456789");
            context.setPaymentStrategy(unionPay);
            context.displayPaymentInfo();
            boolean result4 = context.executePayment();
            System.out.println("支付结果: " + (result4 ? "成功" : "失败"));
        } catch (Exception e) {
            System.out.println("创建支付策略失败: " + e.getMessage());
        }

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 比较不同支付方式的手续费
        System.out.println("5. 不同支付方式手续费比较:");
        comparePaymentFees(1000.0);
    }

    /**
     * 比较不同支付方式的手续费
     */
    private static void comparePaymentFees(double amount) {
        List<PaymentStrategy> strategies = Arrays.asList(
                new AlipayStrategy("test@alipay.com", "pwd"),
                new WechatPayStrategy("wx_test"),
                new CreditCardStrategy("1234567890123456", "123", "12/25"),
                new UnionPayStrategy("6225880112345678")
        );

        System.out.println("支付金额: " + amount);
        System.out.println("\n支付方式比较:");
        System.out.println("支付方式\t\t手续费\t\t总金额");
        System.out.println("-".repeat(50));

        for (PaymentStrategy strategy : strategies) {
            double fee = strategy.getFee(amount);
            double total = amount + fee;
            System.out.printf("%s\t\t%.2f\t\t%.2f\n",
                    strategy.getPaymentMethod(), fee, total);
        }
    }
}

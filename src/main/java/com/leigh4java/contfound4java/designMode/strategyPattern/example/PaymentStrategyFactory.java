package com.leigh4java.contfound4java.designMode.strategyPattern.example;

import java.util.Arrays;
import java.util.List;

// 支付策略工厂
public class PaymentStrategyFactory {

    /**
     * 创建支付策略
     */
    public static PaymentStrategy createStrategy(String type, Object... params) {
        switch (type.toLowerCase()) {
            case "alipay":
                if (params.length >= 2) {
                    return new AlipayStrategy((String) params[0], (String) params[1]);
                }
                break;
            case "wechat":
                if (params.length >= 1) {
                    return new WechatPayStrategy((String) params[0]);
                }
                break;
            case "creditcard":
                if (params.length >= 3) {
                    return new CreditCardStrategy((String) params[0], (String) params[1], (String) params[2]);
                }
                break;
            case "unionpay":
                if (params.length >= 1) {
                    return new UnionPayStrategy((String) params[0]);
                }
                break;
            default:
                throw new IllegalArgumentException("不支持的支付类型: " + type);
        }
        throw new IllegalArgumentException("参数不足");
    }

    /**
     * 获取所有支持的支付方式
     */
    public static List<String> getSupportedPayments() {
        return Arrays.asList("alipay", "wechat", "creditcard", "unionpay");
    }
}

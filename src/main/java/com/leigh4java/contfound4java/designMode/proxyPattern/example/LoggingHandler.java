package com.leigh4java.contfound4java.designMode.proxyPattern.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 动态代理处理器
public class LoggingHandler implements InvocationHandler {
    private Object target; // 真实对象

    public LoggingHandler(Object target) {
        this.target = target;
    }

    // 创建代理对象
    public static Object createProxy(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new LoggingHandler(target)
        );
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 前置处理
        long startTime = System.currentTimeMillis();
        System.out.println("【日志】开始执行: " + method.getName() +
                ", 参数: " + (args != null ? String.join(", ", toString(args)) : "无"));

        // 执行真实方法
        Object result = method.invoke(target, args);

        // 后置处理
        long endTime = System.currentTimeMillis();
        System.out.println("【日志】执行完成: " + method.getName() +
                ", 耗时: " + (endTime - startTime) + "ms");

        return result;
    }

    private String[] toString(Object[] args) {
        String[] strArgs = new String[args.length];
        for (int i = 0; i < args.length; i++) {
            strArgs[i] = String.valueOf(args[i]);
        }
        return strArgs;
    }
}
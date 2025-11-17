package com.leigh4java.contfound4java.designMode.proxyPattern.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 权限检查处理器
public class SecurityHandler implements InvocationHandler {
    private Object target;
    private String currentUser;

    public SecurityHandler(Object target, String currentUser) {
        this.target = target;
        this.currentUser = currentUser;
    }

    public static Object createProxy(Object target, String currentUser) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new SecurityHandler(target, currentUser)
        );
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();

        // 权限检查
        if (methodName.startsWith("add") || methodName.startsWith("delete") ||
                methodName.startsWith("update")) {
            if (!"admin".equals(currentUser)) {
                System.out.println("【安全】权限不足: 用户 " + currentUser + " 无法执行 " + methodName);
                return null;
            }
        }

        System.out.println("【安全】权限检查通过: " + currentUser + " 执行 " + methodName);
        return method.invoke(target, args);
    }
}

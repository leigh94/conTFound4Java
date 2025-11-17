package com.leigh4java.contfound4java.designMode.proxyPattern.example;

public class DynamicProxyDemo {
    public static void main(String[] args) {
        System.out.println("=== JDK动态代理模式演示 ===\n");

        // 创建真实对象
        UserService realService = new UserServiceImpl();

        System.out.println("1. 原始对象调用:");
        realService.addUser("张三");

        System.out.println("\n2. 日志代理:");
        UserService loggingProxy = (UserService) LoggingHandler.createProxy(realService);
        loggingProxy.addUser("李四");
        loggingProxy.getUser("李四");

        System.out.println("\n3. 安全代理 - 普通用户:");
        UserService securityProxy1 = (UserService) SecurityHandler.createProxy(realService, "user1");
        securityProxy1.addUser("王五"); // 应该被拒绝
        securityProxy1.getUser("王五"); // 应该允许

        System.out.println("\n4. 安全代理 - 管理员:");
        UserService securityProxy2 = (UserService) SecurityHandler.createProxy(realService, "admin");
        securityProxy2.addUser("赵六"); // 应该允许
        securityProxy2.deleteUser("赵六"); // 应该允许

        System.out.println("\n5. 组合代理 (日志 + 安全):");
        // 先创建安全代理，再包装日志代理
        UserService securityProxy = (UserService) SecurityHandler.createProxy(realService, "user2");
        UserService combinedProxy = (UserService) LoggingHandler.createProxy(securityProxy);
        combinedProxy.updateUser("钱七");
    }
}

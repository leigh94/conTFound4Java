package com.leigh4java.contfound4java.designMode.abstractFactoryPattern.example;

import com.leigh4java.contfound4java.designMode.abstractFactoryPattern.example.factory.GUIFactory;

// 客户端演示
public class AbstractFactoryDemo {
    public static void main(String[] args) {
        System.out.println("=== 抽象工厂模式演示 ===\n");
        // 演示1：手动指定操作系统
        testSpecificOS();

        // 演示2：自动检测操作系统
        testAutoDetection();

        // 演示3：测试所有操作系统
        testAllOperatingSystems();

        // 演示4：使用配置
        testWithConfig();
    }

    private static void testSpecificOS() {
        System.out.println("1. 手动指定Windows系统:");
        GUIFactory windowsFactory = GUIFactoryProvider.getFactory(GUIFactoryProvider.OSType.WINDOWS);
        Application windowsApp = new Application(windowsFactory);
        windowsApp.render();
        windowsApp.simulateUserInteraction();
    }

    private static void testAutoDetection() {
        System.out.println("2. 自动检测操作系统:");
        try {
            GUIFactory autoFactory = GUIFactoryProvider.getFactory();
            Application autoApp = new Application(autoFactory);
            autoApp.render();
            autoApp.simulateUserInteraction();
        } catch (UnsupportedOperationException e) {
            System.out.println("自动检测失败: " + e.getMessage());
        }
    }

    private static void testAllOperatingSystems() {
        System.out.println("3. 测试所有操作系统:");

        for (GUIFactoryProvider.OSType osType : GUIFactoryProvider.OSType.values()) {
            System.out.println("\n--- " + osType + " 系统 ---");
            try {
                GUIFactory factory = GUIFactoryProvider.getFactory(osType);
                Application app = new Application(factory);
                app.render();
            } catch (Exception e) {
                System.out.println("创建失败: " + e.getMessage());
            }
        }
    }

    private static void testWithConfig() {
        System.out.println("4. 使用配置创建:");
        ApplicationConfig config = ApplicationConfig.loadFromConfig();
        GUIFactory factory = config.createFactory();
        Application app = new Application(factory);
        app.render();
    }
}
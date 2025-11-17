package com.leigh4java.contfound4java.designMode.proxyPattern.example;

public class ProxyPatternApplication {
    public static void main(String[] args) {
        System.out.println("=== 代理模式综合应用 ===\n");

        System.out.println("场景1: 图片查看器 (虚拟代理)");
        Image image1 = new ImageProxy("large_photo.jpg");
        Image image2 = new ImageProxy("small_photo.png");

        // 图像只有在显示时才加载
        System.out.println("创建代理完成，图像尚未加载");
        image1.display(); // 第一次显示会加载
        image1.display(); // 第二次直接显示

        System.out.println("\n场景2: 服务层AOP (动态代理)");
        UserService userService = new UserServiceImpl();
        UserService enhancedService = (UserService) LoggingHandler.createProxy(userService);

        enhancedService.addUser("测试用户");
        enhancedService.getUser("测试用户");

        System.out.println("\n场景3: 权限控制 (保护代理)");
        UserService protectedService = (UserService) SecurityHandler.createProxy(userService, "guest");
        protectedService.deleteUser("重要用户"); // 应该被拒绝

        System.out.println("\n场景4: 缓存功能 (CGLIB代理)");
        QueryService queryService = new QueryService();
        QueryService cachedService = (QueryService) new CacheProxy(queryService).getProxy();

        cachedService.getData("config");
        cachedService.getData("config"); // 从缓存获取
    }
}

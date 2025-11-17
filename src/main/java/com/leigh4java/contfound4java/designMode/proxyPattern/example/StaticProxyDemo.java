package com.leigh4java.contfound4java.designMode.proxyPattern.example;

public class StaticProxyDemo {
    public static void main(String[] args) {
        System.out.println("=== 静态代理模式演示 ===\n");

        // 创建代理对象
        ImageProxy image1 = new ImageProxy("photo1.jpg");
        ImageProxy image2 = new ImageProxy("photo2.png");

        System.out.println("1. 创建代理对象，但真实对象尚未创建");
        image1.showImageInfo();
        image2.showImageInfo();

        System.out.println("\n2. 第一次显示图像 - 会加载真实对象");
        image1.display();

        System.out.println("\n3. 第二次显示同一图像 - 直接使用已加载的对象");
        image1.display();

        System.out.println("\n4. 第二个图像的状态");
        image2.showImageInfo();

        System.out.println("\n5. 显示第二个图像");
        image2.display();
    }
}

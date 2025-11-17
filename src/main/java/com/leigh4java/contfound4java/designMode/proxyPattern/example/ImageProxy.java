package com.leigh4java.contfound4java.designMode.proxyPattern.example;

// 静态代理类
public class ImageProxy implements Image {
    private RealImage realImage;
    private String fileName;

    public ImageProxy(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        // 延迟加载 - 只有在真正需要时才创建真实对象
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }

    @Override
    public void loadFromDisk() {
        // 代理可以控制对真实对象的访问
        if (realImage == null) {
            System.out.println("代理: 图像尚未加载到内存");
        } else {
            realImage.loadFromDisk();
        }
    }

    // 代理可以添加额外功能
    public void showImageInfo() {
        System.out.println("图像信息: " + fileName);
        System.out.println("图像状态: " + (realImage != null ? "已加载" : "未加载"));
    }
}

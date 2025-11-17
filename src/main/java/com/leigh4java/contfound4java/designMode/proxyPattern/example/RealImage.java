package com.leigh4java.contfound4java.designMode.proxyPattern.example;

// 真实对象 - 高分辨率图像
public class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(); // 构造函数中加载图像，模拟重量级操作
    }

    @Override
    public void display() {
        System.out.println("显示图像: " + fileName);
    }

    @Override
    public void loadFromDisk() {
        System.out.println("从磁盘加载图像: " + fileName + " (这是一个耗时的操作)");
        // 模拟加载时间
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

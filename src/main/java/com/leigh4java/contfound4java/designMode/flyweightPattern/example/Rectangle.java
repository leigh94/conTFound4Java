package com.leigh4java.contfound4java.designMode.flyweightPattern.example;

// 具体享元类 - 矩形
public class Rectangle implements Shape {
    private String type; // 内部状态

    public Rectangle(String type) {
        this.type = type;
        System.out.println("创建矩形，类型: " + type);
    }

    @Override
    public void draw(int x, int y, int width, int height, String color) {
        System.out.println("绘制 " + type + " 矩形: 位置(" + x + "," + y +
                "), 尺寸(" + width + "x" + height + "), 颜色: " + color);
    }

    public String getType() {
        return type;
    }
}

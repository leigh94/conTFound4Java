package com.leigh4java.contfound4java.designMode.flyweightPattern.example;

// 具体享元类 - 圆形
public class Circle implements Shape {
    private String type; // 内部状态 - 可以共享

    public Circle(String type) {
        this.type = type;
        System.out.println("创建圆形，类型: " + type);
    }

    @Override
    public void draw(int x, int y, int width, int height, String color) {
        System.out.println("绘制 " + type + " 圆形: 位置(" + x + "," + y +
                "), 尺寸(" + width + "x" + height + "), 颜色: " + color);
    }

    public String getType() {
        return type;
    }
}

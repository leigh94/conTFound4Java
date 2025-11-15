package com.leigh4java.contfound4java.designMode.factoryPattern.example.entity;

/**
 * 具体产品 - 矩形
 */
public class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("绘制矩形，宽度: " + width + ", 高度: " + height);
    }

    @Override
    public double calculateArea() {
        return width * height;
    }
}
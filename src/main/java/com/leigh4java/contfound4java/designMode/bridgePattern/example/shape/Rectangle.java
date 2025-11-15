package com.leigh4java.contfound4java.designMode.bridgePattern.example.shape;

import com.leigh4java.contfound4java.designMode.bridgePattern.example.colour.Color;

// 扩展抽象化角色 - 矩形
public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(Color color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        color.applyColor();
        System.out.println("的矩形，尺寸: " + width + "x" + height);
    }

    @Override
    public String getShapeInfo() {
        return width + "x" + height + "的" + color.getColorName() + "矩形";
    }

    public double calculateArea() {
        return width * height;
    }
}
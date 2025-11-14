package com.leigh4java.contfound4java.designMode.bridgePattern.shape;

import com.leigh4java.contfound4java.designMode.bridgePattern.colour.Color;

// 扩展抽象化角色 - 三角形
public class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(Color color, double base, double height) {
        super(color);
        this.base = base;
        this.height = height;
    }

    @Override
    public void draw() {
        color.applyColor();
        System.out.println("的三角形，底: " + base + "，高: " + height);
    }

    @Override
    public String getShapeInfo() {
        return "底" + base + "高" + height + "的" + color.getColorName() + "三角形";
    }

    public double calculateArea() {
        return base * height / 2;
    }
}
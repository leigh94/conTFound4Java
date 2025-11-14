package com.leigh4java.contfound4java.designMode.bridgePattern.shape;

import com.leigh4java.contfound4java.designMode.bridgePattern.colour.Color;

// 扩展抽象化角色 - 圆形
public class Circle extends Shape {
    private double radius;

    public Circle(Color color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public void draw() {
        color.applyColor();
        System.out.println("的圆形，半径: " + radius);
    }

    @Override
    public String getShapeInfo() {
        return radius + "半径的" + color.getColorName() + "圆形";
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}
package com.leigh4java.contfound4java.designMode.factoryPattern.entity;

import com.leigh4java.contfound4java.designMode.factoryPattern.Shape;

/**
 * 具体产品 - 圆形
 */
public class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("绘制圆形，半径: " + radius);
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}
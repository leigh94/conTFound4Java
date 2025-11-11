package com.leigh4java.contfound4java.designMode.factoryPattern.entity;

import com.leigh4java.contfound4java.designMode.factoryPattern.Shape;

/**
 * 具体产品 - 三角形
 */
public class Triangle implements Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("绘制三角形，底边: " + base + ", 高度: " + height);
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}
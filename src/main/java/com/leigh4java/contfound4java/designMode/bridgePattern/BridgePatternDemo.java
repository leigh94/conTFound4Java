package com.leigh4java.contfound4java.designMode.bridgePattern;

import com.leigh4java.contfound4java.designMode.bridgePattern.colour.BlueColor;
import com.leigh4java.contfound4java.designMode.bridgePattern.colour.Color;
import com.leigh4java.contfound4java.designMode.bridgePattern.colour.GreenColor;
import com.leigh4java.contfound4java.designMode.bridgePattern.colour.RedColor;
import com.leigh4java.contfound4java.designMode.bridgePattern.shape.Circle;
import com.leigh4java.contfound4java.designMode.bridgePattern.shape.Rectangle;
import com.leigh4java.contfound4java.designMode.bridgePattern.shape.Shape;
import com.leigh4java.contfound4java.designMode.bridgePattern.shape.Triangle;

public class BridgePatternDemo {
    public static void main(String[] args) {
        // 创建颜色实现
        Color red = new RedColor();
        Color blue = new BlueColor();
        Color green = new GreenColor();

        System.out.println("=== 桥接模式演示 ===\n");

        // 创建不同颜色和形状的组合
        Shape redCircle = new Circle(red, 5.0);
        Shape blueRectangle = new Rectangle(blue, 4.0, 6.0);
        Shape greenTriangle = new Triangle(green, 3.0, 4.0);

        // 绘制图形
        redCircle.draw();
        blueRectangle.draw();
        greenTriangle.draw();

        System.out.println("\n=== 动态切换颜色 ===");

        // 动态切换颜色
        Circle circle = new Circle(red, 3.0);
        circle.draw();

        // 切换为蓝色
        circle.setColor(blue);
        circle.draw();

        // 切换为绿色
        circle.setColor(green);
        circle.draw();

        System.out.println("\n=== 获取图形信息 ===");
        System.out.println("图形1: " + redCircle.getShapeInfo());
        System.out.println("图形2: " + blueRectangle.getShapeInfo());
        System.out.println("图形3: " + greenTriangle.getShapeInfo());

        // 演示计算面积
        System.out.println("\n=== 计算面积 ===");
        System.out.println("圆形面积: " + ((Circle) redCircle).calculateArea());
        System.out.println("矩形面积: " + ((Rectangle) blueRectangle).calculateArea());
        System.out.println("三角形面积: " + ((Triangle) greenTriangle).calculateArea());

        // 演示更多组合
        System.out.println("\n=== 更多组合 ===");
        Shape[] shapes = {
                new Circle(blue, 2.0),
                new Rectangle(red, 3.0, 5.0),
                new Triangle(green, 6.0, 8.0)
        };

        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}
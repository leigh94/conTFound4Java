package com.leigh4java.contfound4java.designMode.flyweightPattern.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DrawingApp {
    public static void main(String[] args) {
        System.out.println("=== 享元模式演示 - 图形绘制应用 ===\n");

        // 模拟绘制多个图形
        List<Graphic> graphics = createGraphics();

        System.out.println("\n=== 开始绘制图形 ===");
        for (Graphic graphic : graphics) {
            graphic.draw();
        }

        // 显示享元工厂统计信息
        ShapeFactory.showAllShapes();

        System.out.println("\n=== 内存使用分析 ===");
        System.out.println("实际绘制的图形数量: " + graphics.size());
        System.out.println("实际创建的对象数量: " + ShapeFactory.getShapeCount());
        System.out.println("节省内存: " + (graphics.size() - ShapeFactory.getShapeCount()) + " 个对象");
    }

    private static List<Graphic> createGraphics() {
        List<Graphic> graphics = new ArrayList<>();
        Random random = new Random();

        String[] circleTypes = {"实心", "空心", "虚线"};
        String[] rectangleTypes = {"圆角", "直角", "3D"};
        String[] colors = {"红色", "蓝色", "绿色", "黄色", "黑色"};

        // 创建20个图形
        for (int i = 0; i < 20; i++) {
            int x = random.nextInt(100);
            int y = random.nextInt(100);
            int width = random.nextInt(50) + 10;
            int height = random.nextInt(50) + 10;
            String color = colors[random.nextInt(colors.length)];

            if (i % 2 == 0) {
                // 圆形
                String type = circleTypes[random.nextInt(circleTypes.length)];
                Shape shape = ShapeFactory.getShape(type, "circle");
                graphics.add(new Graphic(shape, x, y, width, height, color));
            } else {
                // 矩形
                String type = rectangleTypes[random.nextInt(rectangleTypes.length)];
                Shape shape = ShapeFactory.getShape(type, "rectangle");
                graphics.add(new Graphic(shape, x, y, width, height, color));
            }
        }

        return graphics;
    }
}

// 图形包装类 - 包含外部状态
class Graphic {
    private Shape shape;        // 内部状态（共享）
    private int x;              // 外部状态
    private int y;              // 外部状态
    private int width;          // 外部状态
    private int height;         // 外部状态
    private String color;       // 外部状态

    public Graphic(Shape shape, int x, int y, int width, int height, String color) {
        this.shape = shape;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void draw() {
        shape.draw(x, y, width, height, color);
    }
}

package com.leigh4java.contfound4java.designMode.factoryPattern.example;

import com.leigh4java.contfound4java.designMode.factoryPattern.example.entity.Shape;
import com.leigh4java.contfound4java.designMode.factoryPattern.example.factory.CircleFactory;
import com.leigh4java.contfound4java.designMode.factoryPattern.example.factory.RectangleFactory;
import com.leigh4java.contfound4java.designMode.factoryPattern.example.factory.ShapeFactory;
import com.leigh4java.contfound4java.designMode.factoryPattern.example.factory.TriangleFactory;

/**
 * 测试代码
 */
public class FactoryMethodDemo {
    public static void main(String[] args) {
        System.out.println("=== 工厂方法模式演示 ===\n");

        // 使用具体的工厂创建产品
        testConcreteFactories();

        System.out.println("\n=== 使用工厂提供者 ===\n");

        // 使用工厂提供者创建产品
        testFactoryProvider();

        System.out.println("\n=== 批量创建测试 ===\n");

        // 批量创建测试
        testBatchCreation();
    }

    private static void testConcreteFactories() {
        // 创建圆形工厂
        ShapeFactory circleFactory = new CircleFactory();
        Shape circle = circleFactory.createShapeWithParams(5.0);
        circle.draw();
        System.out.printf("圆形面积: %.2f\n", circle.calculateArea());

        // 创建矩形工厂
        ShapeFactory rectangleFactory = new RectangleFactory();
        Shape rectangle = rectangleFactory.createShapeWithParams(4.0, 6.0);
        rectangle.draw();
        System.out.printf("矩形面积: %.2f\n", rectangle.calculateArea());

        // 创建三角形工厂
        ShapeFactory triangleFactory = new TriangleFactory();
        Shape triangle = triangleFactory.createShapeWithParams(3.0, 4.0);
        triangle.draw();
        System.out.printf("三角形面积: %.2f\n", triangle.calculateArea());
    }

    private static void testFactoryProvider() {
        String[] shapeTypes = {"circle", "rectangle", "triangle"};

        for (String type : shapeTypes) {
            try {
                ShapeFactory factory = ShapeFactoryProvider.getFactory(type);
                Shape shape = factory.createShape(); // 使用默认参数创建
                shape.draw();
                System.out.printf("%s 默认面积: %.2f\n",
                        type, shape.calculateArea());
            } catch (IllegalArgumentException e) {
                System.out.println("错误: " + e.getMessage());
            }
        }
    }

    private static void testBatchCreation() {
        // 模拟从配置或数据库中读取形状配置
        double[][] shapeConfigs = {
                {2.0},           // 圆形半径
                {3.0, 4.0},      // 矩形宽高
                {5.0, 6.0}       // 三角形底高
        };

        String[] shapeTypes = {"circle", "rectangle", "triangle"};

        for (int i = 0; i < shapeTypes.length; i++) {
            try {
                ShapeFactory factory = ShapeFactoryProvider.getFactory(shapeTypes[i]);
                Shape shape = factory.createShapeWithParams(shapeConfigs[i]);
                shape.draw();
                System.out.printf("配置创建的面积: %.2f\n\n", shape.calculateArea());
            } catch (Exception e) {
                System.out.println("创建失败: " + e.getMessage());
            }
        }
    }
}
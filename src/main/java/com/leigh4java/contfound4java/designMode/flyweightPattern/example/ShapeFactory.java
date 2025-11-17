package com.leigh4java.contfound4java.designMode.flyweightPattern.example;

import java.util.HashMap;
import java.util.Map;

// 享元工厂
public class ShapeFactory {
    private static final Map<String, Shape> shapeMap = new HashMap<>();

    // 获取享元对象
    public static Shape getShape(String type, String category) {
        String key = category + "_" + type;
        Shape shape = shapeMap.get(key);

        if (shape == null) {
            switch (category) {
                case "circle":
                    shape = new Circle(type);
                    break;
                case "rectangle":
                    shape = new Rectangle(type);
                    break;
                default:
                    throw new IllegalArgumentException("不支持的图形类型: " + category);
            }
            shapeMap.put(key, shape);
            System.out.println("=== 创建新对象: " + key + " ===");
        } else {
            System.out.println("=== 重用现有对象: " + key + " ===");
        }

        return shape;
    }

    // 获取工厂中对象数量
    public static int getShapeCount() {
        return shapeMap.size();
    }

    // 显示所有共享对象
    public static void showAllShapes() {
        System.out.println("\n=== 当前共享对象列表 ===");
        for (String key : shapeMap.keySet()) {
            System.out.println("Key: " + key);
        }
        System.out.println("总对象数: " + getShapeCount());
    }
}

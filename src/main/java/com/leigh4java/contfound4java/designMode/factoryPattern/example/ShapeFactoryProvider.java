package com.leigh4java.contfound4java.designMode.factoryPattern.example;

import com.leigh4java.contfound4java.designMode.factoryPattern.example.factory.CircleFactory;
import com.leigh4java.contfound4java.designMode.factoryPattern.example.factory.RectangleFactory;
import com.leigh4java.contfound4java.designMode.factoryPattern.example.factory.ShapeFactory;
import com.leigh4java.contfound4java.designMode.factoryPattern.example.factory.TriangleFactory;

/**
 * 工厂提供者 - 简化工厂获取
 */
public class ShapeFactoryProvider {

    public static ShapeFactory getFactory(String shapeType) {
        switch (shapeType.toLowerCase()) {
            case "circle":
                return new CircleFactory();
            case "rectangle":
                return new RectangleFactory();
            case "triangle":
                return new TriangleFactory();
            default:
                throw new IllegalArgumentException("不支持的图形类型: " + shapeType);
        }
    }
}
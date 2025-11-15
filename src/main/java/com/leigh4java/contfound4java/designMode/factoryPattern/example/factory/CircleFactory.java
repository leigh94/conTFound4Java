package com.leigh4java.contfound4java.designMode.factoryPattern.example.factory;

import com.leigh4java.contfound4java.designMode.factoryPattern.example.entity.Circle;
import com.leigh4java.contfound4java.designMode.factoryPattern.example.entity.Shape;

/**
 * 具体工厂 - 圆形工厂
 */
public class CircleFactory implements ShapeFactory {

    @Override
    public Shape createShape() {
        // 默认半径为1的圆
        return new Circle(1.0);
    }

    @Override
    public Shape createShapeWithParams(double... params) {
        if (params.length < 1) {
            throw new IllegalArgumentException("创建圆形需要半径参数");
        }
        return new Circle(params[0]);
    }
}

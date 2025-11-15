package com.leigh4java.contfound4java.designMode.factoryPattern.example.factory;

import com.leigh4java.contfound4java.designMode.factoryPattern.example.entity.Rectangle;
import com.leigh4java.contfound4java.designMode.factoryPattern.example.entity.Shape;

/**
 * 具体工厂 - 矩形工厂
 */
public class RectangleFactory implements ShapeFactory {

    @Override
    public Shape createShape() {
        // 默认1x1的矩形
        return new Rectangle(1.0, 1.0);
    }

    @Override
    public Shape createShapeWithParams(double... params) {
        if (params.length < 2) {
            throw new IllegalArgumentException("创建矩形需要宽度和高度参数");
        }
        return new Rectangle(params[0], params[1]);
    }
}
package com.leigh4java.contfound4java.designMode.factoryPattern.factory;

import com.leigh4java.contfound4java.designMode.factoryPattern.Shape;
import com.leigh4java.contfound4java.designMode.factoryPattern.entity.Triangle;

/**
 * 具体工厂 - 三角形工厂
 */
public class TriangleFactory implements ShapeFactory {

    @Override
    public Shape createShape() {
        // 默认底边和高都为1的三角形
        return new Triangle(1.0, 1.0);
    }

    @Override
    public Shape createShapeWithParams(double... params) {
        if (params.length < 2) {
            throw new IllegalArgumentException("创建三角形需要底边和高度参数");
        }
        return new Triangle(params[0], params[1]);
    }
}
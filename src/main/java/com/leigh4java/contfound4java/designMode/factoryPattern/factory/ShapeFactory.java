package com.leigh4java.contfound4java.designMode.factoryPattern.factory;

import com.leigh4java.contfound4java.designMode.factoryPattern.Shape;

/**
 * 抽象工厂
 */
public interface ShapeFactory {
    Shape createShape();
    Shape createShapeWithParams(double... params);
}
package com.leigh4java.contfound4java.designMode.factoryPattern;

import com.leigh4java.contfound4java.designMode.factoryPattern.entity.Shape;
import com.leigh4java.contfound4java.designMode.factoryPattern.factory.ShapeFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 带缓存的对象池工厂
 */
public class CachedShapeFactory implements ShapeFactory {
    private final ShapeFactory targetFactory;
    private final Map<String, Shape> cache = new HashMap<>();

    public CachedShapeFactory(ShapeFactory targetFactory) {
        this.targetFactory = targetFactory;
    }

    @Override
    public Shape createShape() {
        String key = "default";
        return cache.computeIfAbsent(key, k -> targetFactory.createShape());
    }

    @Override
    public Shape createShapeWithParams(double... params) {
        String key = Arrays.toString(params);
        return cache.computeIfAbsent(key, k -> targetFactory.createShapeWithParams(params));
    }

    public int getCacheSize() {
        return cache.size();
    }
}